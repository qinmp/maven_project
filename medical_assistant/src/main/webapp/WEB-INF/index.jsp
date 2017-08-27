<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/inc.jsp" %>
<html>
<head>
	<base href="<%=basePath%>">
	<title>医疗小助手</title>
	<style type="text/css">
		body{text-align:center} 
		.basicInfo{text-align:left;}
		.mainSuit{text-align:left;}
		a{text-decoration:none;font-size:12px;}
		.txt{width:320px;border:1px solid #000;margin:0 auto;text-align:left;}
		.forgetpwdclass{font-size:12px;}
		.tips{font-size:9px;}
	</style>
</head>
<body>
<h4 class="headClass">病史录</h4>
<div class="basicInfo">
	<span >编号:${basicInfo.serialNo}</span><br>
	<span >记录时间:${basicInfo.createTime}</span><br>
	<span >姓名:${basicInfo.name}</span><br>
	<span >真实出生日期:${basicInfo.realBirthDay}</span><br>
	<span >年龄:${basicInfo.age}</span><br>
	<span >性别:${basicInfo.sex}</span><br>
	<span >籍贯:${basicInfo.nativePlace}</span><br>
	<span >现居住地:${basicInfo.presentResidence}</span><br>
</div>
<br>
<div class="mainSuit">
	<span >主诉:</span><br>
	
	<span >${basicInfo.serialNo}</span><br>
</div>
</body>
</html>
