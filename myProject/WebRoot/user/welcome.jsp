<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="${pageContext.request.contextPath }/css/style1.css" rel="stylesheet" type="text/css" />
	
	<script language="JavaScript" src="${pageContext.request.contextPath }/js/jQuery.js"></script>
    <script language="javascript">
         var t = null;
		 t = setTimeout(time,1000);//开始执行
		 var date = new Date();
		
	     var year = date.getFullYear();
	     var month = date.getMonth()+1;
	     var day = date.getDate();
	     var week = date.getDay();
	
		 function getWeek(num)
		 {
			var weeks = ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'];

			return weeks[num];
		 }
		 function time()
		 {
		    clearTimeout(t);//清除定时器
		    dt = new Date();
		    var h=dt.getHours();
		    var m=dt.getMinutes();
		    var s=dt.getSeconds();
		    document.getElementById("timeShow").innerHTML = year+"-"+month+"-"+day+" "+getWeek(week)+" "+h+":"+m+":"+s;
		    t = setTimeout(time,1000); //设定定时器，循环执行            
		 }
  	</script>
  </head>
  
  <body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>欢迎页面</li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b><s:property value="#session.user.username" />，您好，欢迎使用C语言在线考试系统</b>
    
    </div>
    
    <div class="welinfo">
    <span><img src="images/time.png" alt="时间" /></span>
    <b>现在是北京时间:<label id="timeShow"></label></b>
    </div>
    
    
    
    
    
    
    
    
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="images/dp.png" alt="提醒" /></span>
    <b>C语言考试系统使用指南</b>
    </div>
    
    <ul class="infolist">
    <li><span>您可以进行C语言科目考试</span><a href="${pageContext.request.contextPath }/user/ksxz.jsp" target="rightFrame" class="ibtn">开始考试</a></li>
    <li><span>您可以查看考试记录</span><a target="rightFrame" href="${pageContext.request.contextPath}/user_ckTestRecord.action?uid=<s:property value="#session.user.uid"/>" class="ibtn">查看考试记录</a></li>
    <li><span>您可以查看我的班级</span><a target="rightFrame" href="${pageContext.request.contextPath }/user_myBanJi.action?uid=<s:property value="#session.user.uid"/>" class="ibtn">查看我的班级</a></li>
    <li><span>您可以进行密码修改</span><a target="rightFrame" href="${pageContext.request.contextPath }/user/upw.jsp" class="ibtn">修改密码</a></li>
    </ul>
    
    <div class="xline"></div>
    
    
    
    
    
    
    </div>
</body>
</html>
