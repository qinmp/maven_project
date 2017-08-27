package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

import com.bean.BasicInfoReqBean;
import com.model.BasicInfo;
import com.util.vo.ServiceResult;

public interface BasicInfoService extends BaseService<BasicInfo, Long>  {
	void saveBasicInfo(BasicInfoReqBean bean, ServiceResult result, Long accountId);
	
	String getNewestSerialNoByAccountId(Long accountId);
	
	void accInfo(HttpServletRequest request, ModelMap modelMap);

	void deleteBasicInfo(BasicInfoReqBean bean, ServiceResult result, Long accountId);
	
	void downloadReport(HttpServletRequest request, ModelMap modelMap, HttpServletResponse response) throws Exception;
}
