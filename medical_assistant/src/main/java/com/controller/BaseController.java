package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.exception.MyException;
import com.util.string.StringEscapeEditor;

public class BaseController {

	protected String getStringSession(HttpServletRequest request, String name) {
		Object obj = getSession(request).getAttribute(name);
		return obj == null ? null : obj.toString();
	}

	protected Long getLongSession(HttpServletRequest request, String name) {
		Object obj = getSession(request).getAttribute(name);
		return obj == null ? null : Long.parseLong(obj.toString());
	}
	
	protected Integer getIntegerSession(HttpServletRequest request, String name) {
		Object obj = getSession(request).getAttribute(name);
		return obj == null ? null : Integer.parseInt(obj.toString());
	}

	protected HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}

	/** 基于@ExceptionHandler异常处理 */
	@ExceptionHandler
	public String exp(HttpServletRequest request, Exception ex) {
		request.setAttribute("ex", ex);
		// 根据不同错误转向不同页面
		if (ex instanceof MyException) {
			return "/myException";
		} else {
			return "/error";
		}
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		/**
		 * 自动转换日期类型的字段格式
		 */
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		/**
		 * 防止XSS攻击
		 */
		binder.registerCustomEditor(String.class, new StringEscapeEditor(true, false, true));
	}
}

