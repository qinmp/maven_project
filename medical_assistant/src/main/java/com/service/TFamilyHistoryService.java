package com.service;
import com.bean.FamilyHistoryReqBean;
import com.model.TFamilyHistory;
import com.util.vo.ServiceResult;
public interface TFamilyHistoryService extends BaseService<TFamilyHistory, Long> {

	void getFamilyHistory(String serialNoStr, ServiceResult result, Long accountId);

	void deleteFimalyHistory(String serialNo, ServiceResult result, Long accountId);

	void saveFamilyHistory(FamilyHistoryReqBean bean3, String serialNo, ServiceResult result, Long accountId);
}
