<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript">
    	function query(){
    		window.open("show");
    	}
    </script>
  </head>
  
  <body>
    <div id="main">
    	<input type="button" value="主机1" onclick="query()"/>
    </div>
  </body>
</html>
