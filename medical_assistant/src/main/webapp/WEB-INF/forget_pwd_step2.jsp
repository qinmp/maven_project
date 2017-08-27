<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/inc.jsp"%>
<html lang="en">
<head>
	<title>忘记密码</title>
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
<h2>找回密码</h2>
  <form  name="forgetPwdForm2"  id="forgetPwdForm2">  
	   验证码: <input type="text" name="verifyCode"><br>
	   新密码: <input type="password" name="newPwd"><br>  
	   再次输入: <input type="password" name="newPwdAgain"><br>  
	 <input type="hidden" name="tel" value="${account}"><br>    
	 <input type="submit" value="确定">
  <form>
<script type="text/javascript">
 jQuery(document).ready(function (){
	 $("#forgetPwdForm2").submit(function (){ 
	     var ajax_url = "verifyCode.action"; //表单目标 
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
