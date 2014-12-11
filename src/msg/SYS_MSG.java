package msg;

import java.util.List;

public class SYS_MSG {
	private List<DiskMsg> disk;//磁盘空间
	private String hostname;//主机名称
	private String netstatus;//网络状态
	private List<String[]> checkstatus;//检测服务器的情况
	private String appStatus;//应用状态
	private String sysResource;//系统资源
	private String dbStatus;//数据库状态
	private String backup;//备份情况

	public List<DiskMsg> getDisk() {
		return disk;
	}
	public void setDisk(List<DiskMsg> disk) {
		this.disk = disk;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getNetstatus() {
		return netstatus;
	}
	public void setNetstatus(String netstatus) {
		this.netstatus = netstatus;
	}
	public List<String[]> getCheckstatus() {
		return checkstatus;
	}
	public void setCheckstatus(List<String[]> checkstatus) {
		this.checkstatus = checkstatus;
	}
	public String getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}
	public String getSysResource() {
		return sysResource;
	}
	public void setSysResource(String sysResource) {
		this.sysResource = sysResource;
	}
	public String getDbStatus() {
		return dbStatus;
	}
	public void setDbStatus(String dbStatus) {
		this.dbStatus = dbStatus;
	}
	public String getBackup() {
		return backup;
	}
	public void setBackup(String backup) {
		this.backup = backup;
	}
}