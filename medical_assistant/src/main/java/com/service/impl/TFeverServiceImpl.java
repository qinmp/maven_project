package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TFeverDao;
import com.model.TFever;
import com.service.TFeverService;
@Service
public class TFeverServiceImpl extends BaseServiceImpl<TFever, Long>  implements TFeverService  {

	@Resource
	public void setBaseDao(TFeverDao tFeverDAO){
		this.baseDAO = tFeverDAO;
	}
}
