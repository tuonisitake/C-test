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
    
    <title>修改密码</title>
    
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
		function checkPW(pw1){
		
			var pw = document.getElementById("pw").value;
			var pwspan = document.getElementById("pwspan");
			var flag;
			if(pw1 != pw){
				pwspan.innerHTML = "* 密码错误".fontcolor("red").fontsize("2px");
				flag = false;
			}else{
				pwspan.innerHTML = "";
				flag = true;
			}
			return flag;
		}
		
		function checkQRPW(){
			var qrpw = document.getElementById("qrpw").value;
			var qrspan = document.getElementById("qrspan");
			var newPW = document.getElementById("newPW").value;
			var flag;
			if((newPW == qrpw) && qrpw != ""){
				qrspan.innerHTML = "";
				flag = true;
			}else{
				qrspan.innerHTML = "* 两次密码不一致".fontcolor("red").fontsize("2px");
				flag = false;
			}
			return flag;
		}
		

	</script>
  </head>
  
  <body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0)">密码管理</a></li>
    <li><a href="javascript:void(0)">修改密码</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改密码</span></div>
    <form id="form1" action="${pageContext.request.contextPath }/user_updatePW.action?uid=<s:property value="#session.user.uid"/>" method="post" target="rightFrame" >
    
    <ul class="forminfo">
    <li><label>原密码</label><input id="pw"  type="password" class="dfinput" /><i id="pwspan"></i></li>
    <li><label>新密码</label><input id="newPW" name="newPW" type="password" class="dfinput" onblur="checkNPW()" /><i></i></li>
    
    <li><label>确认密码</label><input id="qrpw" name="qrpw"  type="password" class="dfinput" onblur="checkQRPW()" /><i id="qrspan"></i></li>
   
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认修改"/></li>
   
    </ul>
    </form>
    
    
    </div>
</body>
</html>
