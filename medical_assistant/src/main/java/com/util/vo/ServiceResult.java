package com.util.vo;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.LinkedHashMap;


public class ServiceResult implements Serializable {

	private static Logger logger = Logger.getLogger(ServiceResult.class);
	private static final long serialVersionUID = -4600212442781650484L;
	/**
	 * 返回的信息
	 */
	private String message;

	/**
	 * position:提示位置
	 * 
	 * @since v2.0
	 **/
	private String position;
	/**
	 * 执行是否成功
	 */
	private Boolean isSuccess;
	
	/*定时任务不打印日志*/
	private Boolean isLog = true;

	private LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();

	public ServiceResult() {
		
	}

	public ServiceResult(Boolean isSuccess) {
		super();
		this.isSuccess = isSuccess;
	}

	public ServiceResult(Boolean isSuccess,String message) {
		super();
		this.message = message;
		this.isSuccess = isSuccess;
	}
	
	public ServiceResult(Boolean isSuccess,String message, Boolean isLog) {
		super();
		this.message = message;
		this.isSuccess = isSuccess;
		this.isLog = isLog;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public Boolean getIsLog() {
		return isLog;
	}

	public void setIsLog(Boolean isLog) {
		this.isLog = isLog;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @Description: 将执行结果以json的形式，返回界面
	 * @Create: 2012-10-26 下午10:57:21
	 * @author jcf
	 * @update logs
	 * @return
	 * @throws Exception
	 */
	public String toJSON() {
		// 建一个json序列化的配置
		JsonConfig config = new JsonConfig();
		// 设置属性过滤 参数为实现了PropertyFilter接口的匿名内部类
		config.setJsonPropertyFilter(new PropertyFilter() {
			// 实现apply方法
			public boolean apply(Object object, String name, Object value) {
				if (name.equals("pageNo") || name.equals("order") 
						|| name.equals("pageSize") || name.equals("sort")) {
					return true;
				} else {
					return false;
				}
			}
		});
		LinkedHashMap<String, Object> resultMap = new LinkedHashMap<String, Object>();
		resultMap.put("isSuccess", isSuccess);
		if (StringUtils.isNotBlank(message)) {
			resultMap.put("message", message);
		}
		if (StringUtils.isNotBlank(position)) {
			resultMap.put("position", position);
		}
		if (data.size()!=0) {
			resultMap.put("data", data);
		}
		// 序列化的时候把配置的config传进去
		JSONObject result = JSONObject.fromObject(resultMap, config);
		if(isLog){
			logger.info(result);
		}
		return result.toString();
	}

	/**
	 * @Description: 添加数据
	 * @Create: 2012-12-18 下午11:08:30
	 * @author jcf
	 * @update logs
	 * @param key
	 * @param value
	 */
	public void addData(String key, Object value) {
		data.put(key, value);
	}

	public LinkedHashMap<String, Object> getData() {
		return data;
	}

	public void setData(LinkedHashMap<String, Object> data) {
		this.data = data;
	}
	
	public Object getData(String key){
		return data.get(key);
	}
	

}
