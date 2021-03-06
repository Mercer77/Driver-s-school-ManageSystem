<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="org.springframework.beans.factory.xml.XmlBeanFactory"%>
<%@ page import="entity.*"%>
<%@ page import="dao.*"%>
<%@ page import="org.springframework.core.io.*"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showorder.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script language="javascript" src="js/jquery.js" type="text/javascript"></script>
<script language="javascript" src="js/time.js" type="text/javascript"></script>
<script language="javascript" src="js/jquery-2.1.0.min.js"
	type="text/javascript"></script>


<link rel="stylesheet" type="text/css" href="css/columnDrag.css" />
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/home.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
<link rel="stylesheet" type="text/css" href="css/show.css">

</head>

<body onload="showTime()">
	<%
		try {
			XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
			IOrderTestDao ordertest = (IOrderTestDao) factory.getBean("ordertestDao");
			List<Ordertest> list = ordertest.findAllOrder();
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
	<div class="main-content">
		<div class="header">
			<div class="logo"></div>
			<div class="title">欢迎使用Mercer驾校信息管理系统</div>
			<div class="version">V1.0.0</div>
			<div class="home">
				<a href="home.jsp">首页</a>
			</div>
			<div class="exit">
				<a href="index.jsp" onClick="return confirm('确定退出登录?');">退出登录</a>
			</div>
			<div class="time">
				<span id="timedate" style="font-size: 20px;"></span>
			</div>
		</div>

		<div class="container">
			<div class="leftsidebar_box">
				<div class="line"></div>

				<dl class="custom">
					<dt id="students" onClick="changeImage()">
						学员管理<img src="images/left/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<a href="signuppage.jsp">添加学员</a>
					</dd>
					<dd>
						<a href="showstud.jsp">查看学员</a>
					</dd>

				</dl>
				<dl class="source">
					<dt>
						教练管理<img src="images/left/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<a href="addcoach.jsp">添加教练</a>
					</dd>
					<dd>
						<a href="showcoach.jsp">查看信息</a>
					</dd>

				</dl>

				<dl class="cloud">
					<dt>
						考试预约<img src="images/left/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<a href="order.jsp">添加预约</a>
					</dd>
					<dd>
						<a href="showorder.jsp">查看信息</a>
					</dd>
				</dl>

				<dl class="syetem_management">
					<dt>
						车辆分配管理<img src="images/left/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<a href="traincar.jsp">分配车辆</a>
					</dd>
					<dd>
						<a href="showtraincar.jsp">查看分配信息</a>
					</dd>

				</dl>
			</div>

		</div>
		<div class="show-content">
			<div class="title">
				<h2 style="text-shadow:1px 1px 1px black;">考试预约登记信息</h2>
			</div>

			<div id="chenkbox">
				<table id="tableSort">
					<tr>
						<th onClick="sortTable('tableSort',0)" title="点击排序">预约编号</th>
						<th onClick="sortTable('tableSort',1)" title="点击排序">学员编号</th>
						<th onClick="sortTable('tableSort',2)" title="点击排序">姓名</th>
						<th onClick="sortTable('tableSort',3)" title="点击排序">预约科目</th>
						<th onClick="sortTable('tableSort',4)" title="点击排序">联系电话</th>
						<th onClick="sortTable('tableSort',5)" title="点击排序">考试地点</th>
						<th onClick="sortTable('tableSort',6)" title="点击排序">预约登记时间</th>

						<th>操作</th>
						<th>操作</th>

					</tr>
					<c:forEach items="${list }" var="list">
						<tr>
							<td><c:out value="${list.id }"></c:out></td>
							<td><a href="showonestud.jsp?name=${list.jxstudents.num }"><c:out
										value="${list.jxstudents.num }"></c:out></a></td>
							<td><c:out value="${list.name }"></c:out></td>
							<td><c:out value="${list.test }"></c:out></td>
							<td><c:out value="${list.phone }"></c:out></td>
							<td><c:out value="${list.address}"></c:out></td>
							<td><c:out value="${list.time }"></c:out></td>
							<td><a href="updateorder.jsp?name=${list.id }">编辑</a></td>
							<td><a href="deleteOrder?name=${list.id }">删除</a></td>
						</tr>
					</c:forEach>
				</table>
				<div id="box"></div>
			</div>

			<script language="javascript" src="js/columnDrag.js"
				type="text/javascript"></script>
		</div>
	</div>


</body>
</html>
