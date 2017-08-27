package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TFatDao;
import com.model.TFat;
import com.service.TFatService;
@Service
public class TFatServiceImpl extends BaseServiceImpl<TFat, Long>  implements TFatService  {

	@Resource
	public void setBaseDao(TFatDao tFatDAO){
		this.baseDAO = tFatDAO;
	}

}
