package com.service;
import com.bean.BirthHistoryReqBean;
import com.model.TBirthHistory;
import com.util.vo.ServiceResult;
public interface TBirthHistoryService extends BaseService<TBirthHistory, Long> {

	void getBirthHistory(String serialNoStr, ServiceResult result, Long accountId);

	void deleteBirthHistory(String serialNo, ServiceResult result, Long accountId);

	void saveBirthHistory(BirthHistoryReqBean bean5, String serialNo, ServiceResult result, Long accountId);
}
