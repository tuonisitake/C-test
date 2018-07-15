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
    
    <title>查看答题情况</title>
    
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
    <li><a target="rightFrame" href="${pageContext.request.contextPath}/user_ckTestRecord.action?uid=<s:property value="#session.user.uid"/>">考试记录</a></li>
    <li>答题情况</li>

    </ul>
    </div>
    
    <div class="rightinfo">
    
   
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        
        <th>试题内容</th>
        <th>试题范围</th>
        <th>试题难度</th>
        <th>考查知识点</th>
        <th>答题情况</th>
        <th>试题详情</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="xzqas" var="a">
   			<tr>
   				<td style="text-align: left;"><s:property value="#a.question.qcontent"/></td>
   		        <td><s:property value="#a.question.qscope"/></td>
				<td><s:property value="#a.question.qdifficulty"/></td>
				<td><s:property value="#a.question.qkword"/></td>
				<s:if test="#a.situation == 1">
					<td>正确</td>
				</s:if>
				<s:if test="#a.situation == 2">
					<td>错误</td>
				</s:if>
				<s:if test="#a.situation == 3">
					<td>错误</td>
				</s:if>
				<td><a class="tablelink" href="${pageContext.request.contextPath }/question_ckQuestionDetail.action?qid=<s:property value="#a.question.qid"/>">详情</a></td>
   			</tr>
   			</s:iterator>
   			<s:iterator value="pdqas" var="a">
   			<tr>
   				<td style="text-align: left;"><s:property value="#a.question.qcontent"/></td>
                <td><s:property value="#a.question.qscope"/></td>
				<td><s:property value="#a.question.qdifficulty"/></td>
				<td><s:property value="#a.question.qkword"/></td>
				<s:if test="#a.situation == 1">
					<td>正确</td>
				</s:if>
				<s:if test="#a.situation == 2">
					<td>错误</td>
				</s:if>
				<s:if test="#a.situation == 3">
					<td>错误</td>
				</s:if>
				<td><a class="tablelink" href="${pageContext.request.contextPath }/question_ckQuestionDetail.action?qid=<s:property value="#a.question.qid"/>">详情</a></td>
   			</tr>
   			</s:iterator>
   			<s:iterator value="tkqas" var="a">
   			<tr>
   				<td style="text-align: left;"><s:property value="#a.question.qcontent"/></td>
                <td><s:property value="#a.question.qscope"/></td>
				<td><s:property value="#a.question.qdifficulty"/></td>
				<td><s:property value="#a.question.qkword"/></td>
				<s:if test="#a.situation == 1">
					<td>正确</td>
				</s:if>
				<s:if test="#a.situation == 2">
					<td>错误</td>
				</s:if>
				<s:if test="#a.situation == 3">
					<td>错误</td>
				</s:if>
				<td><a class="tablelink" href="${pageContext.request.contextPath }/question_ckQuestionDetail.action?qid=<s:property value="#a.question.qid"/>">详情</a></td>
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
