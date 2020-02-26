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

import com.bean.LoginAndRegisterReqBean;
import com.exception.BusinessException;
import com.service.AccountService;
import com.util.vo.ServiceResult;

@Controller("loginAndRegisterController")
@Scope("prototype")
public class LoginAndRegisterController extends BaseController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(HttpServletRequest request, ModelMap modelMap) {
			return "/WEB-INF/login";
	}
	
	@RequestMapping(value = "/register.html", method = RequestMethod.GET)
	public String register(HttpServletRequest request, ModelMap modelMap) {
			return "/WEB-INF/register";
	}
	
	@RequestMapping(value = "/register.action", produces="application/json; charset=utf-8" ,method = RequestMethod.POST)
	@ResponseBody
	public String saveRegister(@ModelAttribute("req") LoginAndRegisterReqBean bean,HttpServletRequest request) {
			final String returnFailMessage = "访问失败";
			ServiceResult result = new ServiceResult(false, returnFailMessage);
			try {
				accountService.toRegister(request, bean, result);
			} catch (BusinessException e) {
				result.setIsSuccess(false);
				result.setMessage(e.getMessage());
			} catch (Exception e) {
				result.setIsSuccess(false);
				result.setMessage(returnFailMessage);
			}
			return result.toJSON();
	}
	
	@RequestMapping(value = "/login.action", produces="application/json; charset=utf-8" ,method = RequestMethod.POST)
	@ResponseBody
	public String saveLogin(@ModelAttribute("req") LoginAndRegisterReqBean bean,HttpServletRequest request) {
			final String returnFailMessage = "访问失败";
			ServiceResult result = new ServiceResult(false, returnFailMessage);
			try {
				accountService.toLogin(request, bean, result);
			} catch (BusinessException e) {
				result.setIsSuccess(false);
				result.setMessage(e.getMessage());
			} catch (Exception e) {
				result.setIsSuccess(false);
				result.setMessage(returnFailMessage);
			}
			return result.toJSON();
	}
}
