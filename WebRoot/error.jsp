<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'error.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">

window.onload = function(){
 var msg = "${tipMessage}";  // 获取错误信息
  if(msg != null){
  var url = document.referrer; //获取上一个页面的地址
  if(url.indexOf("tipMessage") > 0){
   url = url.substring(0, url.indexOf("tipMessage") - 1); //得到去掉含有错误信息的地址
  }
   if (url.indexOf("?") > 0){  //为了分开是否还有传其他值
   window.location.href = url + "&tipMessage="+"错误提示:${tipMessage}";  //跳转到上一个页面
  } else {
   window.location.href = url + "?tipMessage="+"错误提示:${tipMessage}";  //跳转到上一个页面
  }
  }
}

< /script>

上一个页面增加初期化处理

< script type="text/javascript">

$(function() {

var msg = "${tipMessage}" ;
  if (msg != "") {
   alertMsg(msg);  // 自制弹窗
  }

</script>
</head>

<body>
	This is my JSP page.
	<br>
</body>
</html>
