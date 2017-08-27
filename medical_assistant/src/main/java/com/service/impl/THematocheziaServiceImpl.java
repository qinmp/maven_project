package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.THematocheziaDao;
import com.model.THematochezia;
import com.service.THematocheziaService;
@Service
public class THematocheziaServiceImpl extends BaseServiceImpl<THematochezia, Long>  implements THematocheziaService  {

	@Resource
	public void setBaseDao(THematocheziaDao tHematocheziaDAO){
		this.baseDAO = tHematocheziaDAO;
	}
}
