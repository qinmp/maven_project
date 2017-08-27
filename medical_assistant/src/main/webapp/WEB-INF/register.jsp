<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/inc.jsp"%>
<html lang="en">
<head>
	<title>注册</title>
	<style> 
		body{text-align:center} 
		a{text-decoration:none;font-size:12px;}
		.txt{width:320px;border:1px solid #000;margin:0 auto;text-align:left;}
	</style>
	<base href="<%=basePath%>">
	<link rel="Shortcut Icon" href="statics/images/favicon.ico" type="image/x-icon">
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>
<h2>请注册</h2>
  <form  name="registerForm"  id="registerForm">  
	   用户名称: <input type="text" name="name"><br>  
	   用户密码: <input type="password" name="password" ><br>  
	   确认密码: <input type="password" name="passwordAgain"><br>  
	   注册邮箱: <input type="text" name="tel" ><br>
	 <input type="submit" value="注册"><a href="login.html">登录</a>
  <form>
<script type="text/javascript">
 jQuery(document).ready(function (){
	 $("#registerForm").submit(function (){ 
	     var ajax_url = "register.action"; //表单目标 
	     var ajax_data = $(this).serialize(); //表单数据 
	     $.ajax({
	        type:"post", //表单提交类型 
	       	url:ajax_url, //表单提交目标 
	        data:ajax_data, //表单数据
	        success:function(msg){
	        	if(msg.isSuccess){
	        		alert(msg.message);
	        		window.location.href="user/index.html";
	        	} else {
		        	alert(msg.message);
	        	}
	      	},
	      	error:function(msg){
	      		alert("error");
	      	}
	     }); 
	     return false; //阻止表单的默认提交事件 
	 });
 });
 
</script>
</body>
</html>
