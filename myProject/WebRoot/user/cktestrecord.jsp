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
    
    <title>查看考试记录</title>
    
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
    <li>考试记录</li>

    </ul>
    </div>
    
    <div class="rightinfo">
    
   
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        
        <th>考试名称</th>
        <th>开考时间</th>
        <th>交卷时间</th>
        <th>成绩</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="list" var="tr">
   			<tr>
   				<td><s:property value="#tr.trname"/></td>
   				<td><s:property value="#tr.stime"/></td>
				<td><s:property value="#tr.etime"/></td>
				<td><s:property value="#tr.trscore"/></td>
				<td><a class="tablelink" href="${pageContext.request.contextPath }/user_ckAnswerSituation.action?trid=<s:property value="#tr.trid"/>">答题情况</a></td>
   			</tr>
   			</s:iterator>
                
        </tbody>
    </table>
    
   
    
    
    
    
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
