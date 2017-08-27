package com.service;

import com.bean.MainSuitReqBean;
import com.model.MainSuit;
import com.util.vo.ServiceResult;

public interface MainSuitService extends BaseService<MainSuit, Long>  {

	void saveMainSuit(MainSuitReqBean bean, ServiceResult result, Long accountId);

	void deleteMainSuit(MainSuitReqBean bean, ServiceResult result, Long accountId);
	
}
