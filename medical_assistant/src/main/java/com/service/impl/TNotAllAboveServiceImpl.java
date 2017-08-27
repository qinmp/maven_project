package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TNotAllAboveDao;
import com.model.TNotAllAbove;
import com.service.TNotAllAboveService;
@Service
public class TNotAllAboveServiceImpl extends BaseServiceImpl<TNotAllAbove, Long>  implements TNotAllAboveService  {
	@Resource
	public void setBaseDao(TNotAllAboveDao tNotAllAboveDAO){
		this.baseDAO = tNotAllAboveDAO;
	}

}
