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

<title>单元测试情况</title>

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
</head>
<body>
	<div class="container">
		<div class="pannel pannel-default">
			<div class="pannel-heading">
				<h3 class="text-center pannel-title"><s:property value="listq[0].qscope" />测试详情</h3>
			</div>
			<div class="pannel-body">
				<table class="table table-bordered table-striped text-center">
					<thead>
						<tr>
							<td>题号</td>
							<td>内容</td>
							<td>正确答案</td>
							<td>试题解析</td>
							<td>您的答案</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listq" var="q" status="index">
							<tr>
								<td><s:property value="#index.getCount()" />
								</td>
								<td><s:property value="#q.qcontent" />
								</td>
								<td><s:property value="#q.qanswer" />
								</td>
								<td><s:property value="#q.qanalysis" />
								</td>
								<td class="text-danger"><s:property value="as[#index.getCount()-1]" />
								</td>
							</tr>
						</s:iterator>
					</tbody>
					<tfoot>
						<tr>
							<td style="color:red;" class="text-right" colspan="5">总分：<s:property value="sum"/>分</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
