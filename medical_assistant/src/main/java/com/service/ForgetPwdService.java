package com.service;

import javax.servlet.http.HttpServletRequest;

import com.bean.ForgetReqBean;
import com.util.vo.ServiceResult;

public interface ForgetPwdService {
	public void sendVerifyCode(ForgetReqBean bean, String subject, HttpServletRequest request, ServiceResult result);
}
