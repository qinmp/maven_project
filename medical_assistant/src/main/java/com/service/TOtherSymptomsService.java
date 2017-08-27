package com.service;
import com.bean.OtherSymptomReqBean;
import com.model.TOtherSymptoms;
import com.util.vo.ServiceResult;
public interface TOtherSymptomsService extends BaseService<TOtherSymptoms, Long>{

	void saveOtherSymptom(OtherSymptomReqBean bean, ServiceResult result, Long accountId);

	void getOtherSymptom(String serialNo, ServiceResult result, Long accountId);

	void deleteOtherSymptom(String serialNo, ServiceResult result, Long accountId);
}
