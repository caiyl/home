<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<html>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="assets/js/jquery-1.8.2.min.js"></script>
   <script src="assets/js/bootstrap.min.js"></script>
   <script src="assets/bootstrapjquery/js/dropdown.js"></script>


<style type="text/css">
body {
}

.starter {
	padding: 40px 15px;
	text-align: center;
}
</style>
<title>Insert title here</title>
</head>
<body>

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

</body>
</html>