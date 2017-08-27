package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TCoughDao;
import com.model.TCough;
import com.service.TCoughService;
@Service
public class TCoughServiceImpl extends BaseServiceImpl<TCough, Long>  implements TCoughService  {

	@Resource
	public void setBaseDao(TCoughDao tCoughDAO){
		this.baseDAO = tCoughDAO;
	}

}
