package com.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.ForgetReqBean;
import com.bean.LoginAndRegisterReqBean;
import com.bean.enumobj.IsDeleteType;
import com.dao.AccountDao;
import com.exception.MyException;
import com.model.Account;
import com.service.AccountService;
import com.util.DateUtil;
import com.util.session.SessionUtil;
import com.util.string.MyStringUtil;
import com.util.vo.GlobalConstants;
import com.util.vo.ServiceResult;

@Service
public class AccountServiceImpl  extends BaseServiceImpl<Account, Long> implements AccountService {
	private Logger logger=Logger.getLogger(AccountServiceImpl.class);
	@Autowired
	private AccountDao accountDao;
	
	@Resource
	public void setBaseDao(AccountDao AccountDao){
		this.baseDAO = AccountDao;
	}
	
	@Override
	public void toLogin(HttpServletRequest request, LoginAndRegisterReqBean bean, ServiceResult result) {
		if(StringUtils.isBlank(bean.getTel())){
			throw new MyException("用户邮箱不能为空");
		}
		//管理员特殊处理
		if(Account.isContainAdminAccount(bean.getTel())){	
			Account account = accountDao.load("account", bean.getTel());
			if(!bean.getPassword().equals(account.getPassword()) 
					|| !bean.getTel().equals(account.getAccount())){
				throw new MyException("用户名或密码错误");
			}
			SessionUtil.setSession(request, Account.LOGIN_ACCOUNT_ID, account.getId());
			SessionUtil.setSession(request, Account.LOGIN_ACCOUNT_ACCOUNT, account.getAccount());
			result.setIsSuccess(true);
			result.setMessage("登录成功");
			return;
		}
		if(!MyStringUtil.checkEmail(bean.getTel(), bean.getTel().length())){
			throw new MyException("邮箱格式不对");
		}
		if(StringUtils.isBlank(bean.getPassword())){
			throw new MyException("密码不能为空");
		}
		Account account = accountDao.load("account", bean.getTel());
		if(null == account){
			throw new MyException("该用户还未注册");
		}
		if(!bean.getPassword().equals(account.getPassword()) 
				|| !bean.getTel().equals(account.getAccount())){
			throw new MyException("用户名或密码错误");
		}
		SessionUtil.setSession(request, Account.LOGIN_ACCOUNT_ID, account.getId());
		SessionUtil.setSession(request, Account.LOGIN_ACCOUNT_ACCOUNT, account.getAccount());
		result.setIsSuccess(true);
		result.setMessage("登录成功");
	}

	@Override
	public void toRegister(HttpServletRequest request, LoginAndRegisterReqBean bean, ServiceResult result) {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(bean.getName())){
			throw new MyException("用户名不能为空");
		}
		if(StringUtils.isBlank(bean.getPassword())){
			throw new MyException("密码不能为空");
		}
		if(StringUtils.isBlank(bean.getPasswordAgain())){
			throw new MyException("确认密码不能为空");
		}
		if(StringUtils.isBlank(bean.getTel())){
			throw new MyException("邮箱不能为空");
		}
		if(!MyStringUtil.checkEmail(bean.getTel(), bean.getTel().length())){
			throw new MyException("邮箱格式不对");
		}
		if(bean.getPassword().length() < 6){
			throw new MyException("密码不能少于6位");
		}
		if(!bean.getPassword().equals(bean.getPasswordAgain())){
			throw new MyException("密码和确认密码不一致");
		}
		Account account = accountDao.load("account", bean.getTel());
		if(null != account){
			throw new MyException("用户名已经存在");
		}
		account = new Account();
		account.setAccount(bean.getTel());
		account.setEmail(bean.getTel());
		account.setCreateTime(DateUtil.getNowTimestamp());
		account.setIsDelete(IsDeleteType.NOTDELETE.getValue());
		account.setName(bean.getName());
		account.setPassword(bean.getPassword());
		account.setTel(bean.getTel());
		accountDao.save(account);
		result.setIsSuccess(true);
		result.setMessage("注册成功");
		SessionUtil.setSession(request, Account.LOGIN_ACCOUNT_ID, account.getId());
		SessionUtil.setSession(request, Account.LOGIN_ACCOUNT_ACCOUNT, account.getAccount());
	}

	@Override
	public void changePwd(HttpServletRequest request, ForgetReqBean bean, ServiceResult result) {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(bean.getTel())){
			throw new MyException("邮箱不能为空");
		}else if(!MyStringUtil.checkEmail(bean.getTel(), bean.getTel().length())){
			throw new MyException("邮箱格式不正确");
		} else if(StringUtils.isBlank(bean.getVerifyCode())){
			throw new MyException("验证码不能为空");
		}else if(StringUtils.isBlank(bean.getNewPwd())){
			throw new MyException("新密码不能为空");
		}else if(StringUtils.isBlank(bean.getNewPwdAgain())){
			throw new MyException("再次密码不能为空");
		}else if(!bean.getNewPwd().equals(bean.getNewPwdAgain())){
			throw new MyException("新密码和确认密码不一致");
		}else if(!bean.getVerifyCode().equals((String)SessionUtil.getSession(request, bean.getTel() + GlobalConstants.VERIFYCODE_SESSION))){
			throw new MyException("验证码不正确");
		}
		Account account = this.load("account", bean.getTel());
		if(account == null){
			throw new MyException("用户不存在");
		}
		account.setPassword(bean.getNewPwd());
		accountDao.saveOrUpdate(account);
		result.setIsSuccess(true);
		result.setMessage("密码修改成功");
		//注销验证码
		SessionUtil.setSession(request, bean.getTel() + GlobalConstants.VERIFYCODE_SESSION, null);
	}

}
