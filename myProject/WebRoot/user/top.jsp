<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
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
	<script type="text/javascript">
	 history.go(1);
	 function loginout(){
	  window.top.location.href="${pageContext.request.contextPath }/user_sessionDestroy.action";
	 
	 }
	
	
	
	
	</script>
	
	
</head>


<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="${pageContext.request.contextPath }/user/welcome.jsp" target="rightFrame"><img src="images/loginlogo.png" title="系统首页" /></a>
    </div>
        
    
            
    <div class="topright">    
    <ul>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="javascript:void(0)">帮助</a></li>
    <li><a href="javascript:void(0)">关于</a></li>
    <li><a onclick="loginout()" href="javascript:void(0)" >安全退出</a></li>
    </ul>
     
    <div class="user">
    <span><s:property value="#session.user.username" /></span>
    
    </div>    
    
    </div>
</body>
</html>
