<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询试题</title>
    
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
		}#div1{
		   margin:60px 0 0 0;
		   padding:0px;
		   width:100%;
		   height:99%;  
		   font-size:14px;
		   position:absolute;
		   text-align: center;
		}
		#div2{
			margin:0 0 0 30px;
			padding:0px;
			width:900px;
			border: 1px solid #F0F0F0;
		}
		
		.divtitle{
			height: 40px;
			line-height: 40px;
			color: #3180D8;
			font-family: "Microsoft YaHei";
			border-bottom: 1px dotted #ededed;
			float: left;
		}
		.divtitle2{
			margin: 10px 0 0 50px;
			float:left;
		}
		table{
			border:0px;
			margin:0px;
			padding:0px;
			width:100%;
			text-align: center;
			font-size: 12px;
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
		.pagediv{
			height: 20px;
			float: right;
			margin-bottom: 10px;
			font-size: 12px;
		}
	</style>
	
	
	
  </head>
  
  <body>
	<div class="divtitle">
		<strong>查找试题：</strong>	
    </div>
    <div class="divtitle2">
    	<form  action="${pageContext.request.contextPath }/question_ckQuestion.action?page=1" target="mainFrame" method="post" >
    		<select id="qt" name="qtid">
    			<option value="0">---请选择题型---</option>
    			<option value="1" ${qtid=="1"?'selected':''}>选择题</option>
    			<option value="2" ${qtid=="2"?'selected':''}>判断题</option>
    			<option value="3" ${qtid=="3"?'selected':''}>填空题</option>
    			
    		</select>
    		<select id="qscope" name="qscope">
    			<option>全部</option>
    			<option value="第一单元">第一单元</option>
    			<option value="第二单元">第二单元</option>
    			<option value="第三单元">第三单元</option>
    			<option value="第四单元">第四单元</option>
    			<option value="第五单元">第五单元</option>
    			
    		</select>
    		<select id="qdifficulty" name="qdifficulty">
    			<option>全部</option>
    			<option>简单</option>
    			<option>中等</option>
    			<option>困难</option>
    		</select>
    		<input type="text" id="qcontent" name="qcontent">
    		<input class="search" type="submit" value="搜索"/>
    	</form>
    </div>
    <div id="div1">
  	  <div id="div2">
   		<table border="0px" cellspacing="0px">
   			<tr style="background-color: #DEEFFF">
   				<td style="width: 70px">试题编号</td>
   				<td style="width:620px;">试题内容</td>
				<td style="width:70">试题难度</td>
				<td style="width:70">试题范围</td>
				<td>操作</td>
			</tr>
   			<s:iterator value="pb.list" var="q">
   			  <tr>
   			  	<td><s:property value="#q.qid"/></td>
   			  	<td style="text-align: left;"><s:property value="#q.qcontent"/></td>
   			  	<td><s:property value="#q.qdifficulty"/></td>
   			  	<td><s:property value="#q.qscope"/></td>
   			  	<td><a href="${pageContext.request.contextPath }/question_ckAdminQuestionDetail.action?qid=<s:property value="#q.qid"/>">查看</a>&nbsp;|&nbsp;<a href="${pageContext.request.contextPath }/question_deleteQuestion.action?qid=<s:property value="#q.qid"/>">删除</a></td>
   			  </tr>
   			</s:iterator>
   		</table>
   		<div class="pagediv">
   		<s:if test="pb.list != null">
   		    <span>共<s:property value="pb.totalCount"/>条记录</span>
   			<span>第<s:property value="pb.page"/>/<s:property value="pb.totalPage"/>页&nbsp;</span>
   			<s:if test="pb.page != 1">
   				<a class="pageUp" href="javascript:void(0)">&nbsp;上一页&nbsp;</a>
   			</s:if>
   			
   			<s:if test="pb.page != pb.totalPage">
   				<a class="pageDown" href="javascript:void(0)">&nbsp;下一页</a>
   			</s:if>
   		</s:if>
   		</div>
   		</div>
   		<div id="sp1" style="display: none">
   		<span class="sp2"><s:property value="pqtid" /></span>
   		<span class="sp3"><s:property value="qscopee" /></span>
   		<span class="sp4"><s:property value="qdifficultye" /></span>
  	    </div>
  	</div>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery.js"></script>
  	<script>
  	 $(function(){
  	   
  	       //$("#qt").val($(".sp2").text());
  	       //$("#qscope").val($(".sp3").text());
  	       if("${pb.totalCount}"=="0"){
  	        alert("查询记录为空！");
  	       }
  	       if("${qscopee}"=="全部"){
  	        $("#qscope").val("${qscopee}");
  	       }else{
  	        $("#qscope").val("${pb.list[0].qscope}");
  	       }
  	       if("${qdifficultye}"=="全部"){
  	        $("#qdifficulty").val("${qdifficultye}");
  	       }else{
  	        $("#qdifficulty").val("${pb.list[0].qdifficulty}");
  	       }
  	       if("${qcontente}"!=""){
  	        $("#qcontent").val("${qcontente}");
  	       }
               
          
  	       //$("#qdifficulty").val($(".sp4").text());
  	       //$("#qscope").find("option[text=$('.sp3').text()]").attr("selected",true);
  	   
//   	    $(".page").on("click",function(){
//   	     var $url =$(this).attr("href");
//   	     $("#div1").load($url + " #div1 > *",{qscope:$("#qscope").val(),qdifficulty:$("#qdifficulty").val(),num:Math.random()});
//   	     return false;
//   	   }); 
           $(".pageUp").on("click",function(){
             var $f = $("form").attr("action","${pageContext.request.contextPath }/question_ckQuestion.action?page=<s:property value="pb.page-1"/>");
             $f.submit();
           });
           $(".pageDown").on("click",function(){
             var $f = $("form").attr("action","${pageContext.request.contextPath }/question_ckQuestion.action?page=<s:property value="pb.page+1"/>");
             $f.submit();
           });
  	   
  	   
  	   
/*   	   $(".search").on("click",function(){
  	     var $u = $("form").attr("action");
  	     $("#div1").load($u + " #div1 > *");
  	     return false;

  	   }); */
  	 
  	 
  	 })
  	</script>
  </body>
</html>
