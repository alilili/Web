package action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import test.Test;
import msg.SYS_MSG;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements RequestAware{
	//声明Map类型的session
	private Map<String, Object> request;
	//信息集合类，存储需要显示的信息
	private SYS_MSG sys_msg;
	//相应的get和set方法
	public SYS_MSG getSys_msg() {
		return sys_msg;
	}
	public void setSys_msg(SYS_MSG sys_msg) {
		this.sys_msg = sys_msg;
	}
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	//默认方法
	public String execute(){
		sys_msg.disk = "1000G";
		sys_msg.address = "172.16.111.68:8080";
		sys_msg.appStatus = "良好";
		sys_msg.sysResource="80%";
		sys_msg.dbStatus = "up";
		sys_msg.backup = "无";
		sys_msg.flag = Test.flag;
		request.put("message", sys_msg);	
		Test.flag++;
		return SUCCESS;
	}
	
}
