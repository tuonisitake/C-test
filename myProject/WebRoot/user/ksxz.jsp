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
    
    <title>考试注意事项</title>
    
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
  </head>
  
  <body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0)">进行考试</a></li>
    <li><a href="javascript:void(0)">开始考试</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo" style="text-align:center">
    <span></span>
    <b style="font-size:24px">2018年C语言在线考试</b>
    
    </div>
    
    
    
    
    
    

    
    
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img style=" width:25px;" src="images/tanhao.jpg" alt="提醒" /></span>
    <b>考前注意事项</b>
    </div>
    
    <ul class="infolist">
    <li><span>一、开始考试后禁止刷新页面，如果因刷新页面造成无法考试等其他问题由考生自己承担。</span></li>
    <li><span>二、试卷分为单元试卷测试和综合试卷测试，试卷满分为100分</span></li>
    <li><span>三、试卷中包含6题选择题，每题分值为10分；3题判断题，每题分值为5分；1题读程序题，分值为25分</span></li>
    <li><span>四、请在规定时间内答完试卷，时间结束将自动提交试卷</span></li>
    </ul>
    
    <div class="xline"></div>
    <div class="welinfo">
    <span></span>
    <b></b>
    </div>
    
    <ul class="infolist">
    <li><span></span></li>
    <li><span></span></li>
    <li><span></span></li>
    </ul>
    <div class="welinfo">
    <span></span>
    <b></b>
    </div>
    <div style="text-align:center">
    
    <ul class="infolist" >
    <li><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><a href="${pageContext.request.contextPath }/user/unit.jsp " class="ibtn">单元测试</a><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>&nbsp;</span><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><a target="_blank" href="${pageContext.request.contextPath }/test_startTest.action?uid=<s:property value="#session.user.uid"/>" class="ibtn">综合考试</a></li>
    
    </ul>
    </div>
    
   
    
   
    
    
    </div>
</body>
</html>
