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
    	function query(elem){
    		var param = elem.name;
    		window.open("show?query="+param);
    	}
    	function query1(elem){
    		window.open("shownew");
    	}
    </script>
  </head>
  
  <body>
    <div id="main">
    	<input type="button" name="server" value="测试环境" onclick="query(this)"/>
    	<input type="button" name="server" value="测试环境2" onclick="query1(this)"/>
    	
    </div>
  </body>
</html>
