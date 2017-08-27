package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exception.MyException;
import com.service.BasicInfoService;
import com.util.session.SessionUtil;

@Controller("indexController")
@Scope("prototype")
@RequestMapping(value = "/user/")
public class IndexController extends BaseController {
	
	@Autowired
	private BasicInfoService  basicInfoService;
	
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String basicIndex(HttpServletRequest request, ModelMap modelMap){
		try {
			basicInfoService.accInfo(request, modelMap);
		} catch (MyException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return "/WEB-INF/pc/index";
	}
	
	@RequestMapping(value = "/download.html", method = RequestMethod.GET)
	public void download(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		try {
			//获取生成报告数据
			basicInfoService.accInfo(request, modelMap);
			//下载报告
			basicInfoService.downloadReport(request, modelMap, response);
			
		} catch (MyException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, ModelMap modelMap) {
		try {
			SessionUtil.updateSession(request);
		} catch (MyException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return "redirect:/user/index.html"; 
	}
}
