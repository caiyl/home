
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String basePath = request.getScheme() + "://" //协议
			+ request.getServerName() //服务地址
			+ ":" + request.getServerPort() //端口
			+ request.getContextPath() + "/";//根路径
%>
<!DOCTYPE html>
<html lang="en" class="no-js">

<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/home-default.css">
<link rel="stylesheet" href="css/public-style.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/main.css">
<script src="assets/js/jquery-1.9.1.min.js"></script>
<script src="assets/js/lang.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/pagejs/system/userlist.js"></script>


</head>

<body>

<div class="content-wrap">
	
	<table
            class="table table-hover table-condensed table-bordered table-striped table-page-position">
        <thead class="cf">
        <tr>
            <th width="40px">选择</th>
            <th>用户id</th>
            <th>用户名</th>
            <th>编辑</th>
        </tr>
        </thead>
        <tbody id="tabbody" >

        </tbody>
    </table>


	<!-- 分页 -->
	<div class="pagecontent">
		<div class="pagebox">
			共<font id="totalnum" color="red"></font>条记录 第<font id="nowpage"
				color="red"></font>页 共<font id="totalpage" color="red"></font>页 <input
				type="text" size="1" style="color: #000" name="page_no" id="page_no"
				value="" /> <input type="button" value="go" id="goPage"
				onClick="go();" /> 每页<select onchange="changePerPage();"
				id="pageSize">
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="20">50</option>
			</select> <input type="button" id="firstpage" class="firstpage"
				onclick="firstPage();" value="首页" /> <input type="button"
				id="uppage" class="uppage" onclick="uppage();" value="上页 " /> <input
				type="button" id="nextpage" class="nextpage" onclick="nextPage();"
				value="下页 " /> <input type="button" id="lastpage" class="lastpage"
				onclick="lastPage();" value="尾页" />
		</div>
	</div>

</div>

</body>

</html>

