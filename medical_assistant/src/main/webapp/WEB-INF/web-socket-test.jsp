<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/inc.jsp"%>
<html lang="en">
<head>
	<title>web-socket-test</title>
	<style> 
		body{text-align:center} 
		a{text-decoration:none;font-size:12px;}
		.txt{width:320px;border:1px solid #000;margin:0 auto;text-align:left;}
		.forgetpwdclass{font-size:12px;}
		.tips{font-size:9px;}
	</style>
	<base href="<%=basePath%>">
	<link rel="Shortcut Icon" href="statics/images/favicon.ico" type="image/x-icon">
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>
	
	输入发送内容： <input type="text" id="input-text" /> <input type="button" id="input-btn" value="发送"><br>
	
	<script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>  
	<script src="/webs/js/web-socket-test.js"></script>
</body>
</html>
