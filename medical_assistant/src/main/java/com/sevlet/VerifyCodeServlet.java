package com.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.image.SCaptcha;
import com.util.vo.GlobalConstants;

/**
 * <h3>概要:</h3> 
 *    该类主要用于生成图片验证码
 * <br>
 * <h3>功能:</h3>
 * <ol>
 * 		<li>TODO(这里用一句话描述功能点)</li>
 * </ol>
 * <h3>履历:</h3>
 * <ol>
 * 		<li>2015-1-12[suxh] 新建</li>
 * </ol>
 */
@WebServlet(urlPatterns = "/image/verifycode.jpg")
public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = -7514717430561901414L;
	public VerifyCodeServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SCaptcha sCaptcha = new SCaptcha();  
		request.getSession().setAttribute(GlobalConstants.VERIFYCODE_SESSION,sCaptcha.getCode());//这里请定义为你的session，到时候以便在验证登录时的验证码是否正确
		 // 设置响应的类型格式为图片格式   
        response.setContentType("image/jpeg");  
        // 禁止图像缓存。   
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        sCaptcha.write(response.getOutputStream());  

	}

}
