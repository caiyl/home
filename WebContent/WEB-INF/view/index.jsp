<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String basePath = request.getScheme()+"://" +request.getServerName() + ":"+request.getServerPort() +request.getContextPath()+"/" ; %>
<html>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<style type="text/css">
	body{
		padding-top:50px;
	}
	.starter{
		padding:40px 15px;
		text-align:center;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
	<!-- 		<div class="navbar-header">
				<a href="#" class="navbar-brand">project name</a>
			</div> -->
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class=active"><a href="#">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
			
		</div>

	</nav>
	
<div class="container">
	<div class="starter">
		<h1>Bootstrap starter temlate</h1>
		<p clas="lead">
			欢迎来到bootstrap欢迎来到bootstrap欢迎来到bootstrap欢迎来到bootstrap欢迎来到bootstrap欢迎来到bootstrap欢迎来到bootstrap
		</p>
	</div>
</div>
	
</body>
</html>