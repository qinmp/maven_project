package com.service;
import com.bean.PersonHistoryReqBean;
import com.model.TPersonHistory;
import com.util.vo.ServiceResult;
public interface TPersonHistoryService extends BaseService<TPersonHistory, Long> {

	void getPersonHistory(String serialNoStr, ServiceResult result, Long accountId);

	void savePersonHistory(PersonHistoryReqBean bean2, ServiceResult result, Long accountId);

	void deletePersonHistory(String serialNo, ServiceResult result, Long accountId);
}
