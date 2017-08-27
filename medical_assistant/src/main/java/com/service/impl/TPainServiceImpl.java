package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TPainDao;
import com.model.TPain;
import com.service.TPainService;
@Service
public class TPainServiceImpl extends BaseServiceImpl<TPain, Long>  implements TPainService  {

	@Resource
	public void setBaseDao(TPainDao tPainDAO){
		this.baseDAO = tPainDAO;
	}
}
