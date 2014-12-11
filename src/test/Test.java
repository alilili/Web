package test;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import serverimpl.NetServerImpl;
import tools.XMLRead;
import client.ClientSocket;
import cmd.impl.IPCommand;

public class Test {

	@org.junit.Test
	public void test() {
		IPCommand ipcommand = new IPCommand("172.16.111.86:8080");
		System.out.println(ipcommand.commandName);
		System.out.println(ipcommand.translate());
		File file = new File("src/ip.xml");
		System.out.println(file.exists());
	}
	
	@org.junit.Test
	public void SocketTest(){
		ClientSocket cs = new ClientSocket();
		File file = new File("src/checkip.xml");
		Map<String, String> map = XMLRead.readFile(file, "check");
		//获取服务服务器的ip：port
		String ip = map.get("ip");
		System.out.println(ip);
		int port = Integer.parseInt(map.get("port"));
		//获取被检测服务器绑定的服务服务器
		String bind = map.get("bind");
		//被检测的服务器可否被当前服务的服务器检测
		if(bind.equals("server")){
			String res = cs.SendMsg(ip, port, "check");
			System.out.println(res);
		}else{
			System.out.println("当前服务器不可检测!");
		}
	}
	
	@org.junit.Test
	public void SocketTest1(){
		ClientSocket cs = new ClientSocket();
		File file = new File("src/server.xml");
		File checkfiel = new  File("src/checkip.xml");
		Map<String, String> map = XMLRead.readFile(file, "server");
		Map<String, String> checkmap = XMLRead.readFile(checkfiel, "check");
		//获取服务服务器的ip：port
		String ip = map.get("ip");
		int port = Integer.parseInt(map.get("port"));
		//获取被检测服务器绑定的服务服务器
		String bind = checkmap.get("bind");
		System.out.println(bind);
		//被检测的服务器可否被当前服务的服务器检测
		if(bind.equals("server")){
			String res = cs.SendMsg(ip, port, "check1");
			System.out.println(res);
		}else{
			System.out.println("当前服务器不可检测!");
		}
	}
	@org.junit.Test
	public void pingTest() throws UnknownHostException, IOException{
		String host = "172.16.111.86";
		boolean status = InetAddress.getByName(host).isReachable(3000);
		System.out.println(status);
	}
	
	@org.junit.Test
	public void XMLReadTest(){
		File file = new File("src/server.xml");
		Map<String, String> result = XMLRead.readFile(file,"server");
		System.out.println(result.get("name"));
		File file2 = new File("src/checkip.xml");
		XMLRead.readFile(file2, "check");
	}
	@org.junit.Test
	public void getInfo(){
		NetServerImpl nsi = new NetServerImpl();
		try {
			nsi.getNetInfo("server");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@org.junit.Test
	public void splitTest(){
		String str = "aaa.bbb.ccc";
		String[] strs = str.split("\\.");
		System.out.println(strs.length);
		for(int i = 0;i<strs.length;i++){
			System.out.println(strs[i]);
		}
	}
	@org.junit.Test
	public void NetServerImplTest() throws UnknownHostException, IOException{
		NetServerImpl nsi = new NetServerImpl();
		nsi.getNetInfo("server");
	}
	@org.junit.Test
	public void getAlltagsTest(){
		File file = new File("src/checkip.xml");
		List<String> tags = XMLRead.getAllTags(file);
		Iterator<String> it = tags.iterator();
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
	}
}
