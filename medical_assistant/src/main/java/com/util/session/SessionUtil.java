package com.util.session;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;


public class SessionUtil {

	private static Logger logger = Logger.getLogger(SessionUtil.class);

	static {
	}

	/**
	 * 获取session中大小
	 * 
	 * @param request
	 * @param str
	 * @return
	 */
	public static Object getSession(HttpServletRequest request, String str) {
		return request.getSession().getAttribute(str);
	}

	/**
	 * @Description: 验证码是否正确
	 * @Create: 2016年9月7日 下午4:56:03
	 * @author jcf
	 * @update logs
	 * @param request
	 * @param verifyCode
	 * @return
	 */
	public static boolean verifycode(HttpServletRequest request, String verifyCode) {
		return true;
	}

	/**
	 * 验证下发的短信验证码
	 * 
	 * @param request
	 * @param code 验证码
	 * @return
	 */
	public static boolean verifyCode(HttpServletRequest request, String code, Object objBindValue) {
		return true;
	}

	/**
	 * 设置session值
	 * 
	 * @param request
	 * @param str
	 * @param obj
	 */
	public static void setSession(HttpServletRequest request, String str, Object obj) {
		request.getSession().setAttribute(str, obj);
	}
	
	/**
	 * @Description: 检查发送频率(校验验证码下发过快)
	 * @Create: 2016年12月8日 上午11:59:30
	 * @author maitao
	 * @update logs
	 * @param request
	 * @param kind
	 * @return
	 */
	/*public static boolean checkCodeFrequency(HttpServletRequest request, int kind) {
		String kindString = "";
		if (kind == 0)
			kindString = GlobalConstants.PERSON_EMAIL_VERIFYCODE_SESSION;
		else if (kind == 1)
			kindString = GlobalConstants.SMS_VERIFYCODE_SESSION;
		else if (kind == 2)
			kindString = GlobalConstants.VOICE_VERIFYCODE_SESSION;
		else if (kind == 3)
			kindString = GlobalConstants.COMPANY_EMAIL_VERIFYCODE_SESSION;
		else
			throw new MyException(GlobalConstants.TIP_MSG006);
		SessionBean sessionBean = (SessionBean) SessionUtil.getSession(request, kindString);
		if (null != sessionBean) {
			long create = sessionBean.getCreatetime();
			long now = System.currentTimeMillis();
			long between = (now - create) / 1000;// 间隔多少s
			if (between <= 30) {
				return false;
			}
		}
		return true;
	}*/
	
	/**
	 * @Description: 将验证码放到session中
	 * @Create: 2016年12月19日 下午5:13:39
	 * @author jcf
	 * @update logs
	 * @param request
	 * @param code
	 * @param bindValue
	 * @param kind
	 *//*
	public static void setVerifyCodeSession(HttpServletRequest request, String code, String bindValue, int kind) {
		String kindString = "";
		if (kind == 0)
			kindString = GlobalConstants.PERSON_EMAIL_VERIFYCODE_SESSION;
		if (kind == 1)
			kindString = GlobalConstants.SMS_VERIFYCODE_SESSION;
		if (kind == 2)
			kindString = GlobalConstants.VOICE_VERIFYCODE_SESSION;
		if (kind == 3)
			kindString = GlobalConstants.COMPANY_EMAIL_VERIFYCODE_SESSION;
		SessionBean smsbean = new SessionBean();
		smsbean.setObj(code);
		smsbean.setObjBindValue(bindValue);
		smsbean.setCreatetime(System.currentTimeMillis());
		smsbean.setPasstime(GlobalConstants.SMS_VALIDATE_SEC);// 过期时间
		SessionUtil.setSession(request, kindString, smsbean);
		SessionUtil.setSession(request, GlobalConstants.VERIFYCODE_SESSION_WAY, kindString);
	}*/

	/**
	 * 安全报告：会话标识未更新 严重性：中 风险： 可能会窃取或操纵客户会话和
	 * cookie，它们可能用于模仿合法用户，从而使黑客能够以该用户身份查看或变更用户记录以及执行事务 解决方式：登录之后更改会话标识符值
	 * 
	 * @date: 2015-3-19
	 * @author:cbz
	 */
	public static void updateSession(HttpServletRequest request) {
		try {
			request.getSession().invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession(true);
	}
	
	
}
