package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TMarasmusDao;
import com.model.TMarasmus;
import com.service.TMarasmusService;
@Service
public class TMarasmusServiceImpl extends BaseServiceImpl<TMarasmus, Long>  implements TMarasmusService  {
	@Resource
	public void setBaseDao(TMarasmusDao tMarasmusDAO){
		this.baseDAO = tMarasmusDAO;
	}
}
