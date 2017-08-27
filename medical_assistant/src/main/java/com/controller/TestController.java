package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.AccountDao;
import com.model.Account;
import com.model.TAbnormalskin;
import com.service.TAbnormalskinService;
import com.util.DateUtil;
import com.util.vo.ServiceResult;

@Controller("testController")
@Scope("prototype")
public class TestController {
	
//	@Autowired
//	private AccountService accountService;
	
	@Autowired
	private AccountDao accountDAO;
	
	@Autowired
	private TAbnormalskinService tAbnormalskinService;
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String basicIndex(HttpServletRequest request, ModelMap modelMap) {
		
		return "/WEB-INF/index";
	}
	
	@RequestMapping(value = "/test3.action", method = RequestMethod.GET)
	public String getTest3(HttpServletRequest request){
		TAbnormalskin tAbnormalskin = new TAbnormalskin();
		tAbnormalskin.setAbnormalSkin(Short.valueOf("1"));
		tAbnormalskin.setCreateTime(DateUtil.getNowTimestamp());
		tAbnormalskin.setLimbsTrunk(Short.valueOf("2"));
		tAbnormalskin.setOtherProblem("other problem");
		tAbnormalskin.setSerialNo("xxxx");
		tAbnormalskinService.save(tAbnormalskin);
		return "/WEB-INF/index";
	}
	
	@RequestMapping(value = "/test2.action", method = RequestMethod.GET)
	public String getTest(HttpServletRequest request){
		return "/WEB-INF/index";
	}
	
	@RequestMapping(value = "/test.action", produces="application/json; charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String postTest(HttpServletRequest request) {
			ServiceResult result = new ServiceResult();
			List<String> list = new ArrayList<String>();
			for(int i=0;i < 10 ;i++){
				list.add(String.valueOf(i));
			}
			result.addData("list", list);
			result.setIsSuccess(true);
			result.setMessage("success");
			Account account = new Account();
			account.setAccount("qinmp@qq.com");
			account.setCreateTime(DateUtil.getNowTimestamp());
			account.setEmail("qinmp@qq.com");
			account.setName("qinmp");
			account.setTel("18684048891");
			account.setPassword("hello");
			account.setIsDelete(0);
			accountDAO.save(account);
			Account returnAccount = accountDAO.load("account", "qinmp@qq.com");
			result.addData("account", returnAccount);
			return result.toJSON();
	}
}
