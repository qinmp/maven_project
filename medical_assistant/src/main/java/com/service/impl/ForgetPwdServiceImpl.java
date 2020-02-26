package com.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bean.ForgetReqBean;
import com.exception.BusinessException;
import com.service.ForgetPwdService;
import com.util.session.SessionUtil;
import com.util.string.MyStringUtil;
import com.util.vo.GlobalConstants;
import com.util.vo.ServiceResult;

@Service
public class ForgetPwdServiceImpl implements ForgetPwdService {
	private Logger logger=Logger.getLogger(AccountServiceImpl.class);
	@Override
	public void sendVerifyCode(ForgetReqBean bean, String subject, HttpServletRequest request, ServiceResult result) {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(bean.getTel())){
			throw new BusinessException("邮箱不能为空");
		}else if(!MyStringUtil.checkEmail(bean.getTel(), bean.getTel().length())){
			throw new BusinessException("邮箱格式不正确");
		} else if(StringUtils.isBlank(bean.getCode())){
			throw new BusinessException("图形验证码不能为空");
		}else if(!bean.getCode().equals((String)SessionUtil.getSession(request, GlobalConstants.VERIFYCODE_SESSION))){
			throw new BusinessException("图形验证码不正确");
		}
		
		Integer randomCode = (int)((Math.random()*9+1)*100000);
		SessionUtil.setSession(request, bean.getTel() + GlobalConstants.VERIFYCODE_SESSION, randomCode.toString());
		//发送验证码
//		MailUtil.sendMail(GlobalConstants.sendMailAccount, GlobalConstants.sendMailPwd, new String[]{bean.getTel()}, subject, randomCode.toString());
		logger.info("the verifyCode is: " + randomCode.toString());
		result.setIsSuccess(true);
		result.setMessage("验证码已经成功发送，请查收！");
		result.addData("account", bean.getTel());
	}

}
