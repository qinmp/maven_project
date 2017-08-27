package com.service;

import javax.servlet.http.HttpServletRequest;

import com.bean.ForgetReqBean;
import com.bean.LoginAndRegisterReqBean;
import com.model.Account;
import com.util.vo.ServiceResult;

public interface AccountService extends BaseService<Account, Long>  {
	/**
	 * @Description: 登录
	 * @Create: 2017年5月14日 上午10:39:58
	 * @author qinmaoping
	 * @update logs
	 * @param request
	 * @param bean
	 * @param result
	 */
	void toLogin(HttpServletRequest request, LoginAndRegisterReqBean bean, ServiceResult result);
	
	void toRegister(HttpServletRequest request, LoginAndRegisterReqBean bean, ServiceResult result);
	
	void changePwd(HttpServletRequest request, ForgetReqBean bean, ServiceResult result);
	
}
