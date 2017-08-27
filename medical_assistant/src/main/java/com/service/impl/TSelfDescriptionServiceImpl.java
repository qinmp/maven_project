package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TSelfDescriptionDao;
import com.model.TSelfDescription;
import com.service.TSelfDescriptionService;
@Service
public class TSelfDescriptionServiceImpl extends BaseServiceImpl<TSelfDescription, Long>  implements TSelfDescriptionService  {
	@Resource
	public void setBaseDao(TSelfDescriptionDao tSelfDescriptionDAO){
		this.baseDAO = tSelfDescriptionDAO;
	}
}
