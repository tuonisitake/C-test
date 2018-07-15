<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<c:url value='/css/main.css' />" rel="stylesheet" type="text/css" />
	
    
   
	<script type="text/javascript">
		function checkForm() {
			if(!$("#adminname").val()) {
				alert("管理员名称不能为空！");
				return false;
			}
			if(!$("#adminpwd").val()) {
				alert("管理员密码不能为空！");
				return false;
			}
			return true;
		}
	</script>
  </head>
  
  <body>


<div class="login">
    <div class="box png">
		<div class="logo png"></div>
        <form action="${pageContext.request.contextPath}/admin_login.action" method="post" onsubmit="return checkForm()" target="_self">
		<div class="input">
			<div class="log">
				<div class="name">
					<label>用户名</label><input id="adminname" type="text" class="text" id="value_1" placeholder="用户名" name="adminname" tabindex="1">
				</div>
				<div class="pwd">
					<label>密　码</label><input id="adminpwd" type="password" class="text" id="value_2" placeholder="密码" name="password" tabindex="2">
					<input type="submit" class="submit" tabindex="3" value="登录">
					<div class="check"></div>
				</div>
				<div class="tip"></div>
			</div>
		</div>
        </form>
	</div>
    
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>

<script type="text/javascript" src="<c:url value='js/jQuery.js'/>"></script>
<script type="text/javascript" src="<c:url value='js/fun.base.js'/>"></script>
<script type="text/javascript" src="<c:url value='js/script.js'/>"></script>


<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">


</div>
</body>
</html>
