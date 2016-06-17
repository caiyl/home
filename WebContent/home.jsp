<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="css/main.css">
<script src="assets/js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
   <script src="assets/js/bootstrap.min.js"></script>


<title>Insert title here</title>
</head>
<body>
<div class="content-wrap">
2222222

<shiro:hasRole name="admin">　
　　<a >admin</a>　
　　</shiro:hasRole>
<shiro:hasRole name="teacher">　
　　<a >teacher</a>　
　　</shiro:hasRole>
<shiro:hasRole name="student">　
　　<a >student</a>　
　　</shiro:hasRole>



<shiro:hasPermission name="all">　
　　<a >admin:all</a>　
　　</shiro:hasPermission>
<shiro:hasPermission name="writeread">　
　　<a >teacher:writeread</a>　
　　</shiro:hasPermission>
<shiro:hasPermission name="read">　
　　<a >student:read</a>　
　　</shiro:hasPermission>
</div>
</body>
</html>