
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String basePath = request.getScheme() + "://" //协议
			+ request.getServerName() //服务地址
			+ ":" + request.getServerPort() //端口
			+ request.getContextPath() + "/";//根路径
%>
<html>
<!DOCTYPE html>
<html lang="en" class="no-js">

<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="assets/js/jquery-1.8.2.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

</head>

<body>
	<table class="table  table-striped table-bordered table-hover" >
	<thead>
	<tr>
		<td align="center">用户id</td>
		<td align="center">用户名</td>
		<td align="center">编辑</td>
	</tr>
	</thead>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td align="center">${user.id}</td>
				<td align="center">${user.name}</td>
				<td align="center">${user.name}</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<nav>
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="active"><a href="#">1</a></li>
    <li class=""><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>

<nav>
  <ul class="pager">
    <li><a href="#">Previous</a></li>
    <li><a href="#">Next</a></li>
  </ul>
</nav>
	
</body>

</html>

