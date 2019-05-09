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

<title>My JSP 'home.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script language="javascript" src="js/jquery.js" type="text/javascript"></script>
<script language="javascript" src="js/jquery.min.js"
	type="text/javascript"></script>
<script language="javascript" src="js/time.js" type="text/javascript"></script>
<script language="javascript" src="js/echarts.js" type="text/javascript"></script>
<script language="javascript" src="js/jquery-2.1.0.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>

<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/home.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
<link rel="stylesheet" type="text/css" href="css/show.css">
<link rel="stylesheet" type="text/css" href="css/print.css"
	media="print">
<link rel="stylesheet" type="text/css" href="css/simple-calendar.css">
<link rel="stylesheet" type="text/css" href="stylesheets/stylesheet.css"
	media="screen">
<link href='https://fonts.googleapis.com/css?family=Architects+Daughter'
	rel='stylesheet' type='text/css'>



<style>
#calendar {
	width: 100%
}

.clearfix {
	margin-bottom: 50px !important;
}
</style>

</head>
<%
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
	ICarDao carDao = (ICarDao)factory.getBean("carDao");
	IStudentsDao studentsDao = (IStudentsDao)factory.getBean("studentsDao");
	ICoachesDao coachesDao = (ICoachesDao)factory.getBean("coachesDao");
	IOrderTestDao orderTestDao = (IOrderTestDao)factory.getBean("ordertestDao");
	List<Car> car=carDao.getAll();
	List<Jxstudents> students = studentsDao.findAllStudents();
	List<Coaches> coaches = coachesDao.findAllCoaches();
	List<Ordertest> order = orderTestDao.findAllOrder();
	
	
%>

<body onload="showTime()">
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
					<dt onClick="changeImage()">
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
		<div class="calendar">
			<div id='calendar'></div>
		</div>
		<div class="charts">
			<div id="chartContainer"></div>
		</div>

		<script type="text/javascript" src="js/javascripts/simple-calendar.js"></script>
		<script>
			var myCalendar = new SimpleCalendar('#calendar');
		</script>

		<script type="text/javascript" src="js/canvas.js"></script>
		<script type="text/javascript">
			var stunum=<%=students.size() %>
			var coanum=<%=coaches.size() %>
			var carnum=<%=car.size() %>
			var ordernum=<%=order.size() %>
			new CanvasJS.Chart('chartContainer', {
				theme : 'light7', //主题
				animationEnabled : true,
				title : {
					text : "驾校信息统计表"
				},
				data : [
					{
						// 数据
						type : "column",
						dataPoints : [
							{
								label : "学员人数",
								y : stunum
							},
							{
								label : "教练人数",
								y : coanum
							},
							{
								label : "车辆数",
								y : carnum
							},
							{
								label : "预约考试人数",
								y : ordernum
							},
						
						]
					}
				]
			}).render();
		</script>
	</div>

</body>
</html>
