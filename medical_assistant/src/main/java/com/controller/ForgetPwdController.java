package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.ForgetReqBean;
import com.exception.MyException;
import com.service.AccountService;
import com.service.ForgetPwdService;
import com.util.vo.ServiceResult;

@Controller("forgetPwdController")
@Scope("prototype")
public class ForgetPwdController extends BaseController  {
	
	@Autowired
	private ForgetPwdService forgetPwdService;
	
	@Autowired
	private AccountService accountService;
	
//	"会话过期，请重新登录"
	@RequestMapping(value = "/forgetPwd.html", method = RequestMethod.GET)
	public String forgetPwd1(HttpServletRequest request, ModelMap modelMap) {
			return "/WEB-INF/forget_pwd_step1";
	}
	
	@RequestMapping(value = "/forgetPwd2.html", method = RequestMethod.GET)
	public String forgetPwd2(HttpServletRequest request, ModelMap modelMap) {
			String account = (String)request.getParameter("account");
			modelMap.put("account", account);
			return "/WEB-INF/forget_pwd_step2";
	}
	
	@RequestMapping(value = "/sendVerifyCode.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String sendVerifyCode(@ModelAttribute("req") ForgetReqBean bean, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "发送失败");
		try {
			forgetPwdService.sendVerifyCode(bean, "验证码发放", request, result);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/verifyCode.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String verifyCode(@ModelAttribute("req") ForgetReqBean bean, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "修改密码失败");
		try {
			accountService.changePwd(request, bean, result);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
}
