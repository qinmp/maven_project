package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TVomitDao;
import com.model.TVomit;
import com.service.TVomitService;
@Service
public class TVomitServiceImpl extends BaseServiceImpl<TVomit, Long>  implements TVomitService  {
	@Resource
	public void setBaseDao(TVomitDao tVomitDAO){
		this.baseDAO = tVomitDAO;
	}
}
