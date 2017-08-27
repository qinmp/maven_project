package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TTicAndConvulsionDao;
import com.model.TTicAndConvulsion;
import com.service.TTicAndConvulsionService;
@Service
public class TTicAndConvulsionServiceImpl extends BaseServiceImpl<TTicAndConvulsion, Long>  implements TTicAndConvulsionService  {
	@Resource
	public void setBaseDao(TTicAndConvulsionDao tTicAndConvulsionDAO){
		this.baseDAO = tTicAndConvulsionDAO;
	}
}
