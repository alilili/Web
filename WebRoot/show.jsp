<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri = "/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>详细信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="refresh" content="5">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript">
		window.onload=function(){
			alert("打开页面！");
		};
	</script>
  </head>
  
  <body>
  	<div id="main" align="center">
    	<table>
    		<tr>
    			<td>磁盘空间：</td>
    			<td><s:property value="#request.message.disk"/></td>
    		</tr>
    		<tr>
    			<td colspan="2">网络状态</td>
    		</tr>
    		<tr>
    			<td>&nbsp;&nbsp;&nbsp;&nbsp;IP/PORT:</td>
    			<td><s:property value="#request.message.address"/></td>
    		</tr>
    		<tr>
    			<td>应用状态：</td>
    			<td><s:property value="#request.message.appStatus"/></td>
    		</tr>
    		<tr>
    			<td>系统资源：</td>
    			<td><s:property value="#request.message.sysResource"/></td>
    		</tr>
    		<tr>
    			<td>数据库状态：</td>
    			<td><s:property value="#request.message.dbStatus"/></td>
    		</tr>
    		<tr>
    			<td>备份情况：</td>
    			<td><s:property value="#request.message.backup"/></td>
    		</tr>
    		<tr>
    			<td>测试</td>
    			<td><s:property value="#request.message.flag"/></td>
    		</tr>
    	</table>
    </div>
  </body>
</html>
