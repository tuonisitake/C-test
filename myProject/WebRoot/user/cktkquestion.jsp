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
    
    <title>查看填空题</title>
    
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
    <li><a href="javascript:void(0)">考试记录</a></li>
    <li><a href="javascript:void(0)">答题情况</a></li>
    <li><a href="javascript:void(0)">查看试题详情</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>详细信息</span></div>
    
    <ul class="forminfo">
    <li><label>题目</label><textarea style="overflow-y:scroll" readonly="readonly" name="" cols="" rows=""  class="textinput"><s:property value="questionDetail.qcontent"/></textarea></li>
    
    
    <li><label>正确答案</label><textarea readonly="readonly" name="" type="text" class="dfinput" ><s:property value="questionDetail.qanswer"/></textarea></li>
    <li><label>试题难度</label><textarea readonly="readonly" name="" type="text" class="dfinput" ><s:property value="questionDetail.qdifficulty"/></textarea></li>
    <li><label>试题范围</label><textarea readonly="readonly" name="" type="text" class="dfinput" ><s:property value="questionDetail.qscope"/></textarea></li>
    <li><label>关键字</label><textarea readonly="readonly" name="" type="text" class="dfinput" ><s:property value="questionDetail.qkword"/></textarea></li>
    <li><label>试题解析</label><textarea style="overflow-y:scroll" readonly="readonly"  name="" cols="" rows="" class="textinput"><s:property value="questionDetail.qanalysis"/></textarea></li>
    
    </ul>
    
    
    </div>
</body>
</html>
