<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upwsuccess.jsp' starting page</title>
    
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
    <li><a href="javascript:void(0)">密码管理</a></li>
    <li><a href="javascript:void(0)">修改密码</a></li>
    <li><a href="javascript:void(0)">修改密码成功</a></li>
    </ul>
    </div>
    <div>
     <span style="font-size: 24px">成功修改密码!</span>
    
    
    </div>
    
  </body>
</html>
