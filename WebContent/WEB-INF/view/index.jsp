<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="viewport" content="width=device-width,initial-scale=1">
<script src="assets/js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/main.css">
<script src="assets/js/bootstrap.min.js"></script>

<script type="text/javascript">

$(document).ready(function(){
	
	$('#nav_ul li').click(function() {
		$('#nav_ul li').removeClass('active');
		$(this).addClass('active');
	});

});


</script>

<title>首页</title>
</head>
<body>

	<nav class="navbar navbar-default navbar-background-color" style="margin-bottom: 0">
		<div class="container-fluid ">
			<!-- Brand and toggle get grouped for better mobile display -->
			<!-- <div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div> -->

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="nav_ul">
					<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
					<li><a href="#">菜单2</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">系统管理<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="userListView.do" target="mainFrame">用户管理</a>
							</li>
							<li role="separator" class="divider"></li>
							<li><a href="#">角色管理</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">权限管理</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">部门管理</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">...</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><shiro:authenticated> 用户<shiro:principal />
						</shiro:authenticated></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<iframe name="mainFrame" id="mainFrame" frameborder="0" src="home.jsp" 
		style="margin: 0 auto; width: 100%; height: 800px;"></iframe>

</body>
</html>