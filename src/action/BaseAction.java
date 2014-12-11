package action;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import msg.DiskMsg;
import msg.NetStatus;
import msg.SYS_MSG;

import org.apache.struts2.interceptor.RequestAware;

import server.DiskServer;
import server.NetServer;
import tools.XMLRead;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements RequestAware{
	private static final long serialVersionUID = 1L;
	//声明Map类型的session
	private Map<String, Object> request;
	//声明网络信息服务类
	private NetServer netServer;
	//声明磁盘查询服务类
	private DiskServer diskServer;
	//相应的get和set方法
	public NetServer getNetServer() {
		return netServer;
	}
	public void setNetServer(NetServer netServer) {
		this.netServer = netServer;
	}
	
	public DiskServer getDiskServer() {
		return diskServer;
	}
	public void setDiskServer(DiskServer diskServer) {
		this.diskServer = diskServer;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	//默认方法
	public String execute() throws UnknownHostException, IOException{
		List<SYS_MSG> list = new ArrayList<SYS_MSG>();
		List<String> server = XMLRead.getAllServer();
		Iterator<String> iterator = server.iterator();	
		while(iterator.hasNext()){
			SYS_MSG sys_msg = new SYS_MSG();
			String nserver = iterator.next();
			NetStatus ns = netServer.getNetInfo(nserver);
			List<DiskMsg> dlist = diskServer.getInfo(nserver);
			sys_msg.setDisk(dlist);
			sys_msg.setHostname(ns.getHostname());
			sys_msg.setNetstatus(ns.getResult());
			sys_msg.setCheckstatus(ns.getIplist());
			sys_msg.setAppStatus("良好");
			sys_msg.setSysResource("80%");
			sys_msg.setDbStatus("up");
			sys_msg.setBackup("无");
			list.add(sys_msg);
		}
		request.put("result",list);
		return SUCCESS;
	}
}
