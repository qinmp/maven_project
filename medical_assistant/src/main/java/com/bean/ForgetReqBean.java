package com.bean;

public class ForgetReqBean {
	
	//邮箱
	private String tel;
	
	//图形验证码
	private String code;
	
	//验证码
	private String verifyCode;
	
	private String newPwd;
	
	private String newPwdAgain;
	
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getNewPwdAgain() {
		return newPwdAgain;
	}
	public void setNewPwdAgain(String newPwdAgain) {
		this.newPwdAgain = newPwdAgain;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
