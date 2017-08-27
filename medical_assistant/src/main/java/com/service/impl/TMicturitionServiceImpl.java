package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TMicturitionDao;
import com.model.TMicturition;
import com.service.TMicturitionService;
@Service
public class TMicturitionServiceImpl extends BaseServiceImpl<TMicturition, Long>  implements TMicturitionService  {

	@Resource
	public void setBaseDao(TMicturitionDao tMicturitionDAO){
		this.baseDAO = tMicturitionDAO;
	}
}
