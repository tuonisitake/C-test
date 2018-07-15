<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
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
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
  </head>
  
 <body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>菜单栏</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span></span>进行考试
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath }/user/ksxz.jsp" target="rightFrame">开始考试</a><i></i></li>
        
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span></span>考试记录
    </div>
    <ul class="menuson">
        <li><cite></cite><a target="rightFrame" href="${pageContext.request.contextPath}/user_ckTestRecord.action?uid=<s:property value="#session.user.uid"/>">查看考试记录</a><i></i></li>

        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span></span>我的班级</div>
    <ul class="menuson">
        <li><cite></cite><a target="rightFrame" href="${pageContext.request.contextPath }/user_myBanJi.action?uid=<s:property value="#session.user.uid"/>">查看班级</a><i></i></li>

    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span></span>密码管理</div>
    <ul class="menuson">
        <li><cite></cite><a target="rightFrame" href="${pageContext.request.contextPath }/user/upw.jsp">修改密码</a><i></i></li>
        
    </ul>
    
    </dd>   
    
    </dl>
</body>
</html>
