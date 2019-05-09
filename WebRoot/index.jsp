<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
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
  
 <body>
 <div class="main-content">
  	<div class="header">
        <div class="logo"></div>
        <div class="title">Mercer驾校信息管理系统</div>
        <div class="version">V1.0.0</div>
        <div class="hr"><hr style="height: 6px; color: gray"></div>
    </div>
    
    
   
	<div class="login-container">
 		<form action="loginAction" method="post">
 	<div class="login-item">
 		<span style="color:#F00"><s:fielderror fieldName="accounts.username"></s:fielderror></span>
    	<div class="input-label">用户名</div>
    	
    	<div class="input-detail">
    		
    		<input type="text" name="accounts.username"  Class="input">
    	</div>
    </div>	
    <div class="login-item">
     	<span style="color:#F00"><s:fielderror fieldName="accounts.password"></s:fielderror></span>
    	<div class="input-label">密码</div>
    	<div class="input-detail">
    		<input type="password" name="accounts.password"   Class="input">
    	</div>	
    </div>
    		
    	<div class="actionerror"><span><s:actionerror cssClass="tips"/></span></div>
    	<div class="button-p">
    	 	<div>
    			<input type="submit" class="login-btn-login" value="登陆">
    			<input type="reset" class="login-btn-reset" value="重置">
    		</div>
    		<div class="register">
    		<a href="register.jsp" style="color: red;font-size: 15px;">还没账号？点击注册</a>
    		</div>
    	</div>
    
    </form>
   </div> 
   <div id="myFocus" class="mF_liuzg">
    <div class="loading"><span>请稍候...</span></div>
    <ul class="pic">
        <li>
        <img src="images/1.jpg"/></a>
        
        </li>
        
        <li>
        <img src="images/2.jpg"/></a>
     
        </li>
        
        <li>
        <img src="images/3.jpg"/></a>
        </li>
        

    </ul>
	</div>
   </div>

 
</body>
</html>
