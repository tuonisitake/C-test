<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>单元测试</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath }/js/jQuery.js"></script>
<style>
 .pannel-heading{margin-top:40px;}
</style>
<script type="text/javascript">
	history.go(1);
	var i;
	var t;
	function check1(x) {
		t = x * 60;
		i = self.setInterval("jishi()", 1000);
	}
	function jishi() {
		h = parseInt(t / 3600);
		m = parseInt((t - h * 60 * 60) / 60);
		mm = t - h * 60 * 60 - m * 60;
		document.getElementById("span1").innerHTML = h + "时" + m + "分" + mm
				+ "秒";
		t--;
		if (t == 600) {
			alert("距离考试结束还有10分钟，请抓紧时间！");
		}
		if (t < 0) {
			i = window.clearInterval(i);
			var f = document.getElementById("form1");
			alert("考试结束");
			f.submit();
		}
	}
// 	function checkradio(){
// 	 $(':radio').each(function(){
// 	   if($('[name="'+this.name+'"]:checked').length=0){
// 	     alert("您有未完成的选择题或填空题！");
// 	   }else{
//  	   $('form').submit();
// 	   }
// 	 });
   $(function(){
     document.getElementsByTagName('form')[0].onsubmit = function() {
 		var obj = this.getElementsByTagName('input');
        var _F = {};
        for(var i = 0; i < obj.length; i ++) {
            if (obj[i].type.toLowerCase() == 'radio') {
                var n = obj[i].name;
                if (typeof(_F[n]) == 'undefined') _F[n] = false;
                if (obj[i].checked) _F[n] = true;
            }
        }
        for(x in _F) {
            if (!_F[x]) {
                alert('您有未完成的选择题或填空题！');
                return false;
            }
        }
        return true;
    
}
   
   
   });
     


	/* 	    function check(){
	 var tnid = document.getElementById("span2").lang;
	 if(confirm("您确定要交卷吗?")){
	 window.location.href ="${pageContext.request.contextPath}/testNote_closeTestNote.action?tnid="+tnid;
	 }else{
	
	 }
	 } */
</script>
</head>

<body onload="check1(30);">
	<div class="container">
		<nav class="navbar navbar-fixed-top">
		<div class="text-center">
			<ul class="breadcrumb">
				<li>姓名:<s:property value="#session.user.username" />
				</li>
				<li>距离考试结束还有:<span id="span1"></span>
				</li>
			</ul>
		</div>
		</nav>
		<div class="pannel pannel-default">
			<div class="pannel-heading">
				<h3 class="text-center pannel-title">
					C语言
					<s:property value="listxz[0].qscope" />
					测试
				</h3>
			</div>
			<div class="pannel-body text-left">
				<form id="form1" class="form-group"
					action="${pageContext.request.contextPath}/test_showResult.action?"
					method="post">
					<s:if test="listxz != null">
						<h3>一、单选题</h3>
						<s:iterator value="listxz" var="qpq" status="index">
							<h2>
								<span><s:property value="#index.getCount()" />、<s:property
										value="#qpq.qcontent" />
								</span>
							</h2>
							<input name="<s:property value="#qpq.qid"/>" type="radio"
								value="<s:property value="#qpq.qaoption"/>">A&nbsp;&nbsp;<s:property
								value="#qpq.qaoption" />
							<br />
							<input name="<s:property value="#qpq.qid"/>" type="radio"
								value="<s:property value="#qpq.qboption"/>">B&nbsp;&nbsp;<s:property
								value="#qpq.qboption" />
							<br />
							<input name="<s:property value="#qpq.qid"/>" type="radio"
								value="<s:property value="#qpq.qcoption"/>">C&nbsp;&nbsp;<s:property
								value="#qpq.qcoption" />
							<br />
							<input name="qid" type="hidden"
								value="<s:property value="#qpq.qid"/>">
							<br />
						</s:iterator>
					</s:if>
					<s:if test="listpd != null">
						<h3>二、判断题</h3>
						<s:iterator value="listpd" status="index" var="qpq">
							<h2>
								<span><s:property value="#index.getCount()+6" />、<s:property
										value="#qpq.qcontent" />
								</span>
							</h2>
							<input name="<s:property value="#qpq.qid"/>" type="radio"
								value="对" />对<br />
							<input name="<s:property value="#qpq.qid"/>" type="radio"
								value="错" />错<br />
							<input name="qid" type="hidden"
								value="<s:property value="#qpq.qid"/>">
							<br />
						</s:iterator>
					</s:if>
					<s:if test="listtk != null">
						<h3>三、读程序题</h3>
						<s:iterator value="listtk" status="index" var="qpq">
							<h2>
								<span><s:property value="#index.getCount()+9" />、</span>
							</h2>
							<textarea readonly id="" cols="90" rows="10">
								<s:property value="#qpq.qcontent" />
							</textarea>
							<br> 请输入结果：<input name="<s:property value="#qpq.qid"/>"
								type="text">
							<br>
							<input name="qid" type="hidden"
								value="<s:property value="#qpq.qid"/>">
							<br>
						</s:iterator>
					</s:if>
					<div class="text-center">
						<button  value="交卷" onclick="checkradio();" class="btn btn-default">交卷</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
