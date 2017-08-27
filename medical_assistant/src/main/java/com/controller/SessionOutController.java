package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("sessionOutController")
@Scope("prototype")
public class SessionOutController extends BaseController  {
//	"会话过期，请重新登录"
	@RequestMapping(value = "/session-out.html", method = RequestMethod.GET)
	public String sessionOut(HttpServletRequest request, ModelMap modelMap) {
			return "/WEB-INF/session_out";
	}
}
