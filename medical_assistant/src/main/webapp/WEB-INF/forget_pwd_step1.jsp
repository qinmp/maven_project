<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/inc.jsp"%>
<html lang="en">
<head>
	<title>忘记密码</title>
	<style> 
		body{text-align:center} 
		a{text-decoration:none;font-size:12px;}
		.txt{width:520px;border:1px solid #000 ;margin:0 auto;text-align:left;}
		.forgetpwdclass{font-size:12px;}
		.tips{font-size:9px;} 
		.verifyImg{width: 80px;height: 35px}
		.submitbtn{align:center;}
	</style>
	<base href="<%=basePath%>">
	<link rel="Shortcut Icon" href="statics/images/favicon.ico" type="image/x-icon">
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>
<h2>找回密码</h2>
  <form  name="forgetPwdForm"  id="forgetPwdForm"> 
  	<div class="txt">
		   用户邮箱: <input type="text" name="tel"><br>
		   图形验证码: <input type="text" name="code"><img alt="" class="verifyImg" src="image/verifycode.jpg"><br>    
  	</div> 
  		 <input type="submit" class="submitbtn" value="发送验证码">
  	
  <form>
<script type="text/javascript">
 jQuery(document).ready(function (){
	 $("#forgetPwdForm").submit(function (){ 
	     var ajax_url = "sendVerifyCode.action"; //表单目标 
	     var ajax_data = $(this).serialize(); //表单数据 
	     $.ajax({
	        type:"post", //表单提交类型 
	       	url:ajax_url, //表单提交目标 
	        data:ajax_data, //表单数据
	        success:function(msg){
	        	if(msg.isSuccess){
	        		alert(msg.message);
	        		window.location.href="forgetPwd2.html?account=" + msg.data["account"];
	        	} else {
		        	alert(msg.message);
	        	}
	      	},
	      	error:function(msg){
	      		alert("出错了");
	      	}
	     }); 
	     return false; //阻止表单的默认提交事件 
	 });
 });
 
</script>
</body>
</html>
