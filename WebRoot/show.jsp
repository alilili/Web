<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<meta http-equiv="refresh" content="30">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>

<body>
	<div id="main" align="center">
		<table>
			<c:forEach begin="1" end="${fn:length(result)/3+1}" step="1" varStatus="vs">
				<tr>
					<c:forEach var="message" items="${result}"
						begin="${vs.count*3-3}" end="${vs.count*3-1}" step="1">
						<td valign="top">
							<table border="1">
								<tr>
									<td>磁盘空间：</td>
									<td>100G</td>
								</tr>
								<c:forEach var="disk" items="${message.disk}">
									<tr>	
										<td>文件系统:</td>
										<td>${disk.fileSystem}</td>
									</tr>
									<tr>
										<td>容量：</td>
										<td>${disk.fileSize }</td>
									</tr>
									<tr>
										<td>已用:</td>
										
										<td>${disk.used }</td>
									</tr>
									<tr>
										<td>可用:</td>
										<td>${disk.avail }</td>
									</tr>
									<tr>
										<td>已用%：</td>
										<c:choose>
											<c:when test="${disk.use >= '0.4'}">
												<td class="red"><fmt:formatNumber value="${disk.use*100}" maxFractionDigits="0"/>%</td>
											</c:when>
											<c:otherwise>
												<td><fmt:formatNumber value="${disk.use*100}" maxFractionDigits="0"/>%</td>
											</c:otherwise>
										</c:choose>
									</tr>
									<tr>
										<td>挂载点：</td>
										<td>${disk.mounte }</td>
									</tr>
								</c:forEach>
								<tr>
									<td colspan="6" align="center">${message.hostname }:
										${message.netstatus}</td>
								</tr>
								<c:forEach var="item" items="${message.checkstatus}">
									<tr>
										<c:choose>
											<c:when test="${item[1]=='连接失败！'}">
												<td class="red">${item[0]}</td>
												<td class="red">${item[1]}</td>
											</c:when>
											<c:otherwise>
												<td>${item[0]}</td>
												<td>${item[1]}</td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
								<tr>
									<td>应用状态：</td>
									<td>${message.appStatus}</td>
								</tr>
								<tr>
									<td>系统资源：</td>
									<td>${message.sysResource}</td>
								</tr>
								<tr>
									<td>数据库状态：</td>
									<td>${message.dbStatus}</td>
								</tr>
								<tr>
									<td>备份情况：</td>
									<td>${message.backup}</td>
								</tr>
							</table></td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
		测试信息
		<hr/>
		
		
	</div>
	
</body>
</html>
