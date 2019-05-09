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

<title>My JSP 'updatestud.jsp' starting page</title>

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
			IStudentsDao studentsDao = (IStudentsDao) factory.getBean("studentsDao");
			List<Jxstudents> list = studentsDao.findOneByName(num);
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
				<form action="updateStudents" method="post">

					<table>
						<tr style="text-align: center;">
							<th colspan="2"><h2 style="text-shadow:1px 1px 1px black;">修改学员信息</h2></th>
						</tr>
						<c:forEach items="${list }" var="list">
							<tr>
								<th>学员编号：<input type="text" name="students.num"
									value="${list.num }" />
								</th>
							</tr>
							<tr>
								<th>姓名：<input type="text" name="students.name"
									value="${list.name }" />
								</th>
							</tr>
							<tr>
								<th>考试进度：<select name="ksjd">
										<option value="${list.ksjd }" selected="selected">${list.ksjd }</option>
										<option value="待报考">待报考</option>
										<option value="科目一">科目一</option>
										<option value="科目二">科目二</option>
										<option value="科目三">科目三</option>
										<option value="科目四">科目四</option>
								</select>
								</th>
							</tr>
							<tr>
								<th>性别：<select name="sex">
										<option value="${list.sex }" selected="selected">${list.sex }</option>
										<option value="男">男</option>
										<option value="女">女</option>
								</select>
								</th>
							</tr>
							<tr>
								<th>身份证号：<input type="text" value="${list.idcard }"
									name="students.idcard" />
								</th>
							</tr>
							<tr>
								<th>联系电话：<input type="text" name="students.phone"
									value="${list.phone }" />
								</th>
							</tr>
							<tr>
								<th>所属教练编号：<input type="text" name="coach"
									value="${list.coaches.num }" />
								</th>
							</tr>

							<tr>
								<th>个人照片： <img src="./studimg/${list.zp }" width="80px"
									height="80px">
								</th>
							</tr>
						</c:forEach>
						<tr>
							<th><input type="submit" value="修改" /> <input type="reset"
								value="重置" /></th>
						</tr>
					</table>

				</form>
			</div>
		</div>



	</div>

</body>
</html>