package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TBellyacheDao;
import com.model.TBellyache;
import com.service.TBellyacheService;
@Service
public class TBellyacheServiceImpl extends BaseServiceImpl<TBellyache, Long>  implements TBellyacheService  {
	
	@Resource
	public void setBaseDao(TBellyacheDao tBellyacheDAO){
		this.baseDAO = tBellyacheDAO;
	}

}
