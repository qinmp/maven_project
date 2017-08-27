package com.exception;

import java.util.LinkedHashMap;

public class MyException extends RuntimeException {

	private static final long serialVersionUID = -7419400618793645414L;
	private String code;// 异常对应的返回码
	private String msg;//异常对应的描述信息
	private LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();

	public MyException() {
		super();
	}

	public MyException(String message) {
		super(message);
		this.msg = message;
	}

	public MyException(String code, String message) {
		super(message);
		this.code = code;
		this.msg = message;
	}
	
	public MyException(String code, String message,LinkedHashMap<String, Object> data) {
		super(message);
		this.code = code;
		this.msg = message;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	public LinkedHashMap<String, Object> getData(){
		return data;
	}
}

