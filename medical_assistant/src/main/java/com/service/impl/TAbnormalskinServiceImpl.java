package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.service.TAbnormalskinService;
import com.dao.TAbnormalskinDao;
import com.model.TAbnormalskin;
@Service
public class TAbnormalskinServiceImpl extends BaseServiceImpl<TAbnormalskin, Long>  implements TAbnormalskinService  {
	
	@Resource
	public void setBaseDao(TAbnormalskinDao tAbnormalskinDAO){
		this.baseDAO = tAbnormalskinDAO;
	}
	
}
