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
    
    <title>添加试卷</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body{
			margin: 0;
			padding: 0;
		}
		#div1{
		   margin:0px;
		   padding:0px;
		   width:100%;
		   height:99%;  
		   font-size:14px;
		   position:absolute;
		   text-align: center;
		}
		#div2{
			margin:0 0 0 150px;
			padding:0px;
			width:500px;
			border: 1px solid #F0F0F0;
		}
		.divtitle{
			height: 40px;
			line-height: 40px;
			color: #3180D8;
			font-family: "Microsoft YaHei";
			border-bottom: 1px dotted #ededed;
		}
		table{
			border:0px;
			margin:0px;
			padding:0px;
			width:100%;
			text-align: center;
			font-size: 14px;
			color:#6D6D6D;
		}
		tr{
			margin:0px;
			padding:0px;
		}
		td{
			margin:0px;
			padding:0px;
			border-bottom: 1px solid #F0F0F0;
		}
		#div2 a:link,#div2 a:visited{
			color:#1183C2;
			text-decoration:none;
		}
		#div2 a:hover{
			color:#df4011;
		}
	</style>
	
	
  </head>
  
  <body>
	<div class="divtitle">
		<strong>添加试卷：</strong>
    </div>
    <div id="div1">
  	  <div id="div2">
  	   <form id="form1" action="${pageContext.request.contextPath}/testPaper_tjTestPaperSX.action?aid=<s:property value="#session.admin.aid"/>&tpid=<s:property value="testPaper.tpid"/>"  method="post" target="mainFrame" >
  	    
   		<table border="0px" cellspacing="0px" >
   			<tr style="background-color: #DEEFFF">
   				<td>题目序号</td>
   				
				<td>题目内容</td>
				<td>题目选项</td>
				
   			</tr>
   			<s:if test="listxz != null">
   			<s:iterator value="listxz" var="x" status="index">
   			  <input type="hidden" name="question"  value="<s:property value="#x.qid"/>" />
   				<tr>
   				<td><s:property value="#index.getCount()"/><br></td>
   				<td><s:property value="#x.qcontent"/><br></td>
   				<td>A.<s:property value="#x.qaoption"/>&nbsp;&nbsp;B.<s:property value="#x.qboption"/>&nbsp;&nbsp;C.<s:property value="#x.qcoption"/></td>
   			</tr>
   			</s:iterator>
   			</s:if>
   			<s:if test="listpd != null">
   			<s:iterator value="listpd" var="p" status="index">
   			   <input  type="hidden" name="question" value="<s:property value="#p.qid"/>" />
   				<tr>
   				<td><s:property value="#index.getCount()+6"/><br></td>
   				<td><s:property value="#p.qcontent"/><br></td>
   				<td>对/错</td>
   			</tr>
   			</s:iterator>
   			</s:if>
   			<s:if test="listtk != null">
   			<s:iterator value="listtk" var="t" status="index">
   			<input  type="hidden" name="question" value="<s:property value="#t.qid"/>" />
   				<tr>
   				<td><s:property value="#index.getCount()+9"/><br></td>
   				<td><s:property value="#t.qcontent"/><br></td>
   				<td></td>
   			</tr>
   			</s:iterator>
   			</s:if>
   		
   		</table>
   		<input type="submit" value="添加该试卷" />
   		</form>
   		</div>
  	</div>
  </body>
</html>
