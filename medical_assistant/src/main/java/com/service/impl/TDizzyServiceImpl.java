package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TDizzyDao;
import com.model.TDizzy;
import com.service.TDizzyService;
@Service
public class TDizzyServiceImpl extends BaseServiceImpl<TDizzy, Long>  implements TDizzyService  {

	@Resource
	public void setBaseDao(TDizzyDao tDizzyDAO){
		this.baseDAO = tDizzyDAO;
	}

}
