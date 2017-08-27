package com.service;

import com.bean.PresentIllnessReqBean;
import com.util.vo.ServiceResult;

public interface PresentIllnessService   {

	void savePresentIllness(PresentIllnessReqBean bean, ServiceResult result, Long accountId);

	void getPresentIllness(String serialNo, ServiceResult result, Long accountId);
	
	void deletePresentIllnessBySerialNo(String serialNo, ServiceResult result, Long accountId);
}
