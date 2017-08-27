package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TAstrictionDao;
import com.model.TAstriction;
import com.service.TAstrictionService;
@Service
public class TAstrictionServiceImpl extends BaseServiceImpl<TAstriction, Long>  implements TAstrictionService  {
	
	@Resource
	public void setBaseDao(TAstrictionDao tAstrictionDAO){
		this.baseDAO = tAstrictionDAO;
	}
}
