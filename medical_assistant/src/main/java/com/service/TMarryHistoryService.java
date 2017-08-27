package com.service;
import com.model.TMarryHistory;
import com.util.vo.ServiceResult;
public interface TMarryHistoryService extends BaseService<TMarryHistory, Long> {

	void getMarryHistory(String serialNoStr, ServiceResult result, Long accountId);

	void saveMarryHistory(Integer marryType, String serialNo, ServiceResult result, Long accountId);

	void deleteMarryHistory(String serialNo, ServiceResult result, Long accountId);
}
