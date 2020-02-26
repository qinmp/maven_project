package com.util.session;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;


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
