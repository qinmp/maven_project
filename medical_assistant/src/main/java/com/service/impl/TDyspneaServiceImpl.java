package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TDyspneaDao;
import com.model.TDyspnea;
import com.service.TDyspneaService;
@Service
public class TDyspneaServiceImpl extends BaseServiceImpl<TDyspnea, Long>  implements TDyspneaService  {

	@Resource
	public void setBaseDao(TDyspneaDao tDyspneaDAO){
		this.baseDAO = tDyspneaDAO;
	}

}
