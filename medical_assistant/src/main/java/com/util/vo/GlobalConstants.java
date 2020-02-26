package com.util.vo;

public interface GlobalConstants {
	/** 显示的公司名称 */
	/** 验证码session名称 */
	public static String VERIFYCODE_SESSION="verify_session";
	
	public static String sendMailAccount = "m18684048891@163.com";
	public static String sendMailPwd = "31123569ljy";
	
	/** 发送验证码方式session名称 */
	public static String VERIFYCODE_SESSION_WAY="verifycode_session_way";
	/** 短信session名称 */
	public static String SMS_VERIFYCODE_SESSION="sms_verifycode_session";
	/** 短信session名称 */
	public static String VOICE_VERIFYCODE_SESSION="voice_verifycode_session";
	/** 个人邮箱验证码session名称 */
	public static String PERSON_EMAIL_VERIFYCODE_SESSION="person_email_verifycode_session";
	/** 企业邮箱验证码session名称 */
	public static String COMPANY_EMAIL_VERIFYCODE_SESSION="company_email_verifycode_session";
	/** 是否允许修改手机号 */   
	public static String IS_ALLOW_UPDATE_MOBILE_SESSION="is_allow_update_mobile_session";
	/** 是否允许修改邮箱 */   
	public static String IS_ALLOW_UPDATE_EMAIL_SESSION="is_allow_update_email_session";
	
	/** 修改邮箱号步骤 */   
	public static String MODIFY_PASSWORD_EMAIL_STEP_SESSION="modify_password_email_step_session";
	/** 修改手机号步骤*/   
	public static String MODIFY_PASSWORD_MOBILE_STEP_SESSION="modify_password_mobile_step_session";
	/** 当前修改的帐号*/
	public static String MODIFY_PASSWORD_ACCOUNT_SESSION="modify_password_account_session";
	
	public static String ACCOUNT_SOURCE="ACCOUNT_SOURCE";
	/** WX_OPENID_SESSION:微信用户id session名称 */   
	public static String WX_OPENID_SESSION="WX_OPENID";
	
	/** CODE_NEED:验证码输错次数 */   
	public static String CODE_NEED = "code_need";
	public static String PWD_ERRORCOUNT_SESSION = "pwd_errorcount_session";
	/** 通过eID验证通过的合同的uuid */
	public static String CONTRACT_FILENAME = "contract_filename";
	
	public static final String USER_INFO ="FAJIAJIA_USER_INFO";
	
	//massage Type
	public static final String MSG = "MSG";
	public static final String MAIL = "MAIL";
	public static final String LETTER = "LETTER";
	
	//合同短信
	public static final String SMS_CONTRACT001 = "SMS_CONTRACT001";
	public static final String SMS_CONTRACT002 = "SMS_CONTRACT002";
	public static final String SMS_CONTRACT003 = "SMS_CONTRACT003";
	public static final String SMS_CONTRACT004 = "SMS_CONTRACT004";
	public static final String SMS_CONTRACT005 = "SMS_CONTRACT005";
	public static final String SMS_CONTRACT006 = "SMS_CONTRACT006";
	public static final String SMS_CONTRACT007 = "SMS_CONTRACT007";
	public static final String SMS_CONTRACT008 = "SMS_CONTRACT008";
	public static final String SMS_CONTRACT009 = "SMS_CONTRACT009";
	public static final String SMS_CONTRACT010 = "SMS_CONTRACT010";
	public static final String SMS_CONTRACT011 = "SMS_CONTRACT011";

	//文件邮件
	public static final String MAIL_001 = "MAIL_001";
	public static final String MAIL_003 = "MAIL_003";
	public static final String MAIL_004 = "MAIL_004";
	public static final String MAIL_006 = "MAIL_006";
	public static final String MAIL_007 = "MAIL_007";
	public static final String MAIL_008 = "MAIL_008";
	public static final String MAIL_016 = "MAIL_016";
	public static final String MAIL_015 = "MAIL_015";
	public static final String MAIL_009 = "MAIL_009";
	public static final String MAIL_CTRL_009 = "MAIL_CTRL_009";
	public static final String MAIL_010 = "MAIL_010";
	public static final String MAIL_011 = "MAIL_011";
	public static final String MAIL_012 = "MAIL_012";
	public static final String MAIL_013 = "MAIL_013";
	public static final String MAIL_014 = "MAIL_014";

	//文件站内信
	public static final String LETTER_CONTRACT001 = "LETTER_CONTRACT001";
	public static final String LETTER_CONTRACT002 = "LETTER_CONTRACT002";
	public static final String LETTER_CONTRACT003 = "LETTER_CONTRACT003";
	public static final String LETTER_CONTRACT004 = "LETTER_CONTRACT004";
	
	//提示信息
	public final static String TIP_MSG000 = "数据加载成功";
	public final static String TIP_MSG001 = "验证码已发送，请注意查收";
	public final static String TIP_MSG002 = "暂时不能加载，请稍后再试";
	public final static String TIP_MSG003 = "暂时不能签署，请稍后再试";
	public final static String TIP_MSG004 = "暂时不能操作，请稍后再试";
	public final static String TIP_MSG005 = "您太久未操作，请重新登录";
	public final static String TIP_MSG006 = "请求参数有误，请确认填写";
	public final static String TIP_MSG007 = "您将接到来自059186398465的语音来电";
	public final static String TIP_MSG008 = "验证码下发过快";
	public final static String TIP_MSG009 = "操作成功";
	public final static String TIP_MSG010 = "不满足下载条件";
	
	
	/** 前台操作日志 */
	public interface PORTAL_LOG_MODULE 
	{
		public static String REG_LOG = "注册日志";
		public static String LOGIN_LOG = "登陆日志";
		public static String CONTRACT_LOG = "合同操作日志";
		public static String DRAFT_LOG = "草稿箱操作日志";
		public static String INFO_LOG = "账号编辑日志";
		public static String TRANS_LOG = "订购支付操作日志";
		public static String CANCEL_LOG = "订购取消操作日志";
		public static String SIGN_LOG = "签章操作日志";
		public static String USER_LOG = "用户操作日志";
		public static String GROUP_LOG = "群组操作日志";
		public static String CONTACT_LOG = "联系人操作日志";
		public static String SYS_LOG = "系统设置操作日志";
		public static String LETTER_LOG = "站内信操作日志";
		public static String DEPT_LOG = "群组操作日志";
		public static String EMPOWER_LOG = "授权操作日志";
		public static String ACCOUNTCONTRACTTEMPLATE_LOG = "合同模版操作日志";
		public static String RECHARGE_LOG = "充值操作日志";
		public static String CASH_LOG = "提现操作日志";
		public static String EVIDENCEORDER_LOG = "出证订单操作日志";
	}
	
	/**
	 * <h3>概要:</h3> 
	 *    合同模块
	 * <br>
	 * <h3>功能:</h3>
	 * <ol>
	 * </ol>
	 * <h3>履历:</h3>
	 * <ol>
	 * 		<li>2015-8-14[suxh] 新建</li>
	 * </ol>
	 */
	public interface CONTRACT_ACTIVE{
		
		/** 合同串码为空 */
		public static String CONTRACT_SERIALNO_BLANK="CONTRACT_039";
		
		/** 合同串码无法查询到结果，请检查合同串码! */
		public static String CONTRACT_SERIALNO_QUERY_NULL="CONTRACT_040";
		
		/** 合同串码查询异常 */
		public static String CONTRACT_SERIALNO_QUERY_EXCEPTION="CONTRACT_041";
		
		/** 串码有误！ */
		public static String CONTRACT_SERIALNO_ERROR="CONTRACT_042";
		
		/** 您的pdf文档未查到签章信息！ */
		public static String CONTRACT_SIGNATURE_NOT_FOUND="CONTRACT_043";
	}
	
}
