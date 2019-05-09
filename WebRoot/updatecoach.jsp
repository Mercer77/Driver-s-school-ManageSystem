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

<title>My JSP 'updatecoach.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script language="javascript" src="js/jquery.js" type="text/javascript"></script>
<script language="javascript" src="js/time.js" type="text/javascript"></script>
<script language="javascript" src="js/jquery-2.1.0.min.js"
	type="text/javascript"></script>
<script language="javascript" src="js/easyform.js"
	type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/home.css">
<link rel="stylesheet" type="text/css" href="css/table.css">

</head>

<body onload="showTime()">
	<%
		try {
			String num = request.getParameter("name");
			XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
			ICoachesDao coachesDao = (ICoachesDao) factory.getBean("coachesDao");
			List<Coaches> list = coachesDao.findOneByName(num);
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

		<div class="center-content">
			<div class="form-div">
				<form action="updateCoaches" method="post">
					<c:forEach items="${list }" var="list">
						<table>
							<tr style="text-align: center;">
								<th colspan="2"><h2 style="text-shadow:1px 1px 1px black;">修改教练信息</h2></th>
							</tr>
							<tr>
								<th>教练编号：<input type="text" name="coaches.num"
									value="${list.num }" />
								</th>
								<th>姓名：<input type="text" name="coaches.name"
									value="${list.name }" />
								</th>
							</tr>

							<tr>
								<th>年龄：<input type="text" name="coaches.age"
									value="${list.age }" size="3">
								<th>联系电话：<input type="text" name="coaches.phone"
									value="${list.phone }" />
								</th>
							</tr>
							<tr>

								<th>驾龄：<select name="worktime">
										<option value="${list.worktime }" selected="selected">${list.worktime }</option>
										<option value="1~5年">1~5年</option>
										<option value="6~10年">6~10年</option>
										<option value="11~15年">11~15年</option>
								</select>
								</th>
								<th>性别：<select name="sex">
										<option value="${list.sex }" selected="selected">${list.sex }</option>
										<option value="男">男</option>
										<option value="女">女</option>
								</select>
								</th>

							</tr>

							<tr>
								<th>个人地址：<input type="text" name="coaches.address"
									value="${list.address }" />
								</th>
								<th>个人简介：<textarea name="coaches.introduction" rows="4">  ${list.introduction }</textarea>
								</th>
							</tr>
							<tr>
								<th style="text-align: left;">个人照片：<img
									src="./coachimg/${list.zp }" width="80px" height="80px">
								</th>
							</tr>
							<tr>
								<th colspan="2"><input type="submit" value="修改" /><input
									type="reset" value="重置" /></th>
							</tr>
						</table>
					</c:forEach>
				</form>
			</div>
		</div>
	</div>


</body>
</html>