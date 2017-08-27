package com.service;

import com.bean.PastHistoryReqBean;
import com.util.vo.ServiceResult;

public interface PastHistoryService {
	public void savePastHistory(PastHistoryReqBean bean ,ServiceResult result, Long accountId);

	public void getPastHistory(String serialNo, ServiceResult result, Long accountId);

	public void deletePastHistory(String serialNo, ServiceResult result, Long accountId);
}
