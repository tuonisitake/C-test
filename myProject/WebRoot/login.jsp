<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />">
    <script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/login.js'/>"></script>
  </head>
  
  <body>
    <div class="login">
	<h2>管理员登录</h2>
	<div class="login-top">
		<h1>LOGIN FORM</h1>
		 <form target="_top" action="${pageContext.request.contextPath }/admin_login.action" method="post" id="loginForm">
		    <input type="hidden" name="method" value="login" />
			<input class="input" type="text" name="adminname" id="loginname" value="${admin.adminname }"/>
			<input class="input" type="password" name="password" id="loginpass" value="${admin.password }"/>
	    
	    <div class="forgot">
	    	<label class="error" id="msg">${msg }</label>
	    	<label id="loginnameError" class="error"></label>
	    	<label id="loginpassError" class="error"></label>
	    	<input type="submit" value="Login" class="loginBtn" />
	    </div>
	    </form>
	</div>
	<div class="login-bottom">
		<h3> &nbsp;<a href="<c:url value='/jsps/user/regist.jsp'/>" class="registBtn">立即注册</a>&nbsp </h3>
	</div>
</div>	
<div class="copyright">
	
</div>

  </body>
</html>
