package com.service;
import com.bean.MenstrualHistoryReqBean;
import com.model.TMenstrualHistory;
import com.util.vo.ServiceResult;
public interface TMenstrualHistoryService extends BaseService<TMenstrualHistory, Long> {

	void getMenstrualHistory(String serialNoStr, ServiceResult result, Long accountId);

	void deleteMenstrualHistory(String serialNo, ServiceResult result, Long accountId);

	void saveMenstrualHistory(MenstrualHistoryReqBean bean4, String serialNo, ServiceResult result, Long accountId);
}
