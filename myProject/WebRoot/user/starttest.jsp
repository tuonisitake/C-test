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
    
    <title>综合考试</title>
    
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
<style>
 .pannel-heading{margin-top:40px;}
</style>
	<script type="text/javascript">
		history.go(1);
		var i;
	    var t;
	    function check1(x){
	    	t = x*60;
	    	i = self.setInterval("jishi()",1000);
	    }
	    function jishi(){
	    	h = parseInt(t/3600);
	    	m = parseInt((t-h*60*60)/60);
	    	mm = t-h*60*60-m*60;
	    	document.getElementById("span1").innerHTML = h+"时"+m+"分"+mm+"秒";
	    	t--;
	    	if(t == 600){
	    		alert("距离考试结束还有10分钟，请抓紧时间！");
	    	}
	    	if(t<0){
	    		i = window.clearInterval(i);
	    		var f = document.getElementById("form1");
				alert("考试结束");
				f.submit();
	    	}
	    }
	    
	    
	   
		 
	    
/* 	    function check(){
	    	var tnid = document.getElementById("span2").lang;
			if(confirm("您确定要交卷吗?")){
				window.location.href ="${pageContext.request.contextPath}/testNote_closeTestNote.action?tnid="+tnid;
			}else{
			
			}
	    } */
	</script>
  </head>
  
  <body onload="check1(<s:property value="tp.tptime"/>);">
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
					<s:property value="tr.trname"/>
				</h3>
			</div>
			<div class="pannel-body text-left">
				<form id="form1" class="form-group"
					action="${pageContext.request.contextPath}/answerSituation_saveAS.action?trid=<s:property value="tr.trid"/>"
					method="post">
					<s:if test="listxzq != null">
						<h3>一、单选题</h3>
						<s:iterator value="listxzq" var="qpq" status="index">
							<h2>
								<span><s:property value="#index.getCount()" />、<s:property
										value="#qpq.question.qcontent" />
								</span>
							</h2>
							<input name="<s:property value="#qpq.question.qid"/>" type="radio" value="<s:property value="#qpq.question.qaoption"/>">A&nbsp;&nbsp;<s:property value="#qpq.question.qaoption"/><br/>
							<input name="<s:property value="#qpq.question.qid"/>" type="radio" value="<s:property value="#qpq.question.qboption"/>">B&nbsp;&nbsp;<s:property value="#qpq.question.qboption"/><br/>
							<input name="<s:property value="#qpq.question.qid"/>" type="radio" value="<s:property value="#qpq.question.qcoption"/>">C&nbsp;&nbsp;<s:property value="#qpq.question.qcoption"/><br/>
			                <input name="qid" type="hidden" value="<s:property value="#qpq.question.qid"/>">
							<br />
						</s:iterator>
					</s:if>
					<s:if test="listpdq != null">
						<h3>二、判断题</h3>
						<s:iterator value="listpdq" status="index" var="qpq">
							<h2>
								<span><s:property value="#index.getCount()+6" />、<s:property
										value="#qpq.question.qcontent" />
								</span>
							</h2>
							<input name="<s:property value="#qpq.question.qid"/>" type="radio" value="对" />对<br/>
	   			<input name="<s:property value="#qpq.question.qid"/>" type="radio" value="错" />错<br/>
	   			<input name="qid" type="hidden" value="<s:property value="#qpq.question.qid"/>">
							<br />
						</s:iterator>
					</s:if>
					<s:if test="listtkq != null">
						<h3>三、读程序题</h3>
						<s:iterator value="listtkq" status="index" var="qpq">
							<h2>
								<span><s:property value="#index.getCount()+9" />、</span>
							</h2>
							<textarea readonly id="" cols="90" rows="10">
								<s:property value="#qpq.question.qcontent"/>
							</textarea>
							<br> 请输入结果：<input name="<s:property value="#qpq.question.qid"/>"
								type="text">
							<br>
							<input name="qid" type="hidden"
								value="<s:property value="#qpq.question.qid"/>">
							<br>
						</s:iterator>
					</s:if>
					<div class="text-center">
						<input type="submit" value="交卷" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
