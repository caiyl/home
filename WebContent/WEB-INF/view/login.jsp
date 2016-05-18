<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String basePath = request.getScheme()+"://" //协议
		+request.getServerName()   //服务地址
		+ ":"+request.getServerPort() //端口
		+request.getContextPath()+"/" ;//根路径
	%>
<html>
<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>



        <meta charset="UTF-8">
        <title>登录(Login)</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="<%=basePath %>assets/css/reset.css">
        <link rel="stylesheet" href="<%=basePath %>assets/css/supersized.css">
        <link rel="stylesheet" href="<%=basePath %>assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="assets/js/html5.js"></script>
        <![endif]-->
<script src="assets/js/jquery-1.8.2.min.js"></script>

<style type="text/css">
  .html-body-overflow
  {
    overflow-x:hidden;
    overflow-y:hidden;
  }
 </style>

    </head>

    <body>

        <div class="page-container">
            <!-- <h1>登录(Login)</h1> -->
            <form action="loginIn.do" method="post">
                <input type="text" name="name" class="name" placeholder="请输入您的用户名！">
                <input type="password" name="password" class="password" placeholder="请输入您的用户密码！">
            <!--     <input type="Captcha" class="Captcha" name="Captcha" placeholder="请输入验证码！"> -->
                <button type="submit" class="submit_button">登录</button>
                <div class="error"><span>+</span></div>
            </form>
            <!-- <div class="connect">
                <p>快捷</p>
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div> -->
        </div>
		
        <!-- Javascript -->
        <script src="<%=basePath %>assets/js/jquery-1.8.2.min.js" ></script>
        <script src="<%=basePath %>assets/js/supersized.3.2.7.min.js" ></script>
        <script src="<%=basePath %>assets/js/supersized-init.js" ></script>
        <script src="<%=basePath %>assets/js/scripts.js" ></script>

    </body>
<div style="text-align:center;">
</div>
</html>

