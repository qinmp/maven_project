package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TExpectorationDao;
import com.model.TExpectoration;
import com.service.TExpectorationService;
@Service
public class TExpectorationServiceImpl extends BaseServiceImpl<TExpectoration, Long>  implements TExpectorationService  {

	@Resource
	public void setBaseDao(TExpectorationDao tExpectorationDAO){
		this.baseDAO = tExpectorationDAO;
	}

}
