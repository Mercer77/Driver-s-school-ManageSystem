<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'register.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script language="javascript" src="js/banner.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/banner.css">

</head>

<body onload="showTime()">
	<div class="main-content">
		<div class="header">
			<div class="logo"></div>
			<div class="title">Mercer驾校信息管理系统</div>
			<div class="version">V1.0.0</div>
			<div class="hr">
				<hr style="height: 6px; color: gray">
			</div>
		</div>
		<div style="position: absolute;margin-left: 41%;">
		<div class="login-container">
			
			<form action="registerAction" method="post">


				<h2 style="text-shadow:1px 1px 1px black;">注册页面</h2>
				
				<div class="login-item">
				
					<div class="input-label">用户名</div>

					<div class="input-detail">

						<s:textfield  name="accounts.username" cssClass="input"></s:textfield>
					</div>
				</div>
				<div class="login-item">
	
					<div class="input-label">密码</div>
					<div class="input-detail">
						<s:password  name="accounts.password" cssClass="input"></s:password>
					</div>
				</div>
				<div class="login-item">
	
					<div class="input-label">重复密码</div>
					<div class="input-detail">
						<s:password  name="passwordcf" cssClass="input" ></s:password>
					</div>
				</div>
				<div class="button-p">
					<div>
						<input type="submit" class="login-btn-login" value="注册"> <input
							type="reset" class="login-btn-reset" value="重置">
					</div>
				</div>
			
			</form>
			</div>
		</div>
	</div>
</body>

</html>
