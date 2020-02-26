package com.util.mail;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class MailUtil {
	
	 private static String myEmailSMTPHost = "smtp.163.com";

	 public static void sendMail(String myAccount, String myPwd, String[] toAccounts, String mailSubject, String mailContent){
        Properties props = new Properties();                // 用于连接邮件服务器的参数配置（发送邮件时才需要用到）
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        Session session= Session.getDefaultInstance(props); // 根据参数配置，创建会话对象（为了发送邮件准备的）
        session.setDebug(true);   
        // 4. 根据 Session 获取邮件传输对象
        try {
            // 3. 创建一封邮件
            MimeMessage message = createMimeMessage(session, myAccount, toAccounts, mailSubject, mailContent);
			Transport transport = session.getTransport();
			try {
				transport.connect(myEmailSMTPHost, myAccount, myPwd);
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	private static MimeMessage createMimeMessage(Session session, String myAccount, String[] toAccounts, String mailSubject, String mailContent){
		
        MimeMessage message = new MimeMessage(session);     // 创建邮件对象
        try {
			message.setFrom(new InternetAddress(myAccount, "USER_AA", "UTF-8"));
			for (int i = 0; i < toAccounts.length; i++) {
				message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toAccounts[i], "USER_AA", "UTF-8"));
			}
			message.setSubject(mailSubject, "UTF-8");
			message.setContent(mailContent, "text/html;charset=UTF-8");
			 // 6. 设置显示的发件时间
			message.setSentDate(new Date());
	        // 7. 保存设置
	        message.saveChanges();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public static void main(String[] args){
		sendMail("", "", new String[]{""}, "test", "testContent");
	}
	
}

