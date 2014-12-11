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
	//����Map���͵�session
	private Map<String, Object> request;
	//����������Ϣ������
	private NetServer netServer;
	//�������̲�ѯ������
	private DiskServer diskServer;
	//��Ӧ��get��set����
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
	
	//Ĭ�Ϸ���
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
			sys_msg.setAppStatus("����");
			sys_msg.setSysResource("80%");
			sys_msg.setDbStatus("up");
			sys_msg.setBackup("��");
			list.add(sys_msg);
		}
		request.put("result",list);
		return SUCCESS;
	}
}
