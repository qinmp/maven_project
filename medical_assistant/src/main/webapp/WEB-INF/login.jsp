<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/inc.jsp"%>
<html lang="en">
<head>
	<title>登录</title>
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
<h2>请登录</h2>
  <form  name="loginForm" id="loginForm">  
  	<div>
  		<div class="txt">
			<label>用户邮箱: </label><input type="text" name="tel"><span class="tips">(注册邮箱)</span><br>  
		  	<label>用户密码: </label><input type="password" name="password" ><label><a href="forgetPwd.html"><span class="forgetpwdclass">忘记密码</span></a></label><br> 
  		</div>
		<input type="submit" value="登录" id="submitBtn"><a href="register.html">注册</a><br>
		
  	</div>
  <form>
 <script type="text/javascript">
 jQuery(document).ready(function (){
	 $("#loginForm").submit(function (){ 
	     var ajax_url = "login.action"; //表单目标 
	     var ajax_data = $(this).serialize(); //表单数据 
	     $.ajax({
	        type:"post", //表单提交类型 
	       	url:ajax_url, //表单提交目标 
	        data:ajax_data, //表单数据
	        success:function(msg){
	        	if(msg.isSuccess){
	        		
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
