package msg;

import java.util.List;

public class SYS_MSG {
	private List<DiskMsg> disk;//���̿ռ�
	private String hostname;//��������
	private String netstatus;//����״̬
	private List<String[]> checkstatus;//�������������
	private String appStatus;//Ӧ��״̬
	private String sysResource;//ϵͳ��Դ
	private String dbStatus;//���ݿ�״̬
	private String backup;//�������

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