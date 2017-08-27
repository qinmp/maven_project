package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TConsciousnessDisorderDao;
import com.model.TConsciousnessDisorder;
import com.service.TConsciousnessDisorderService;
@Service
public class TConsciousnessDisorderServiceImpl extends BaseServiceImpl<TConsciousnessDisorder, Long>  implements TConsciousnessDisorderService  {
	
	@Resource
	public void setBaseDao(TConsciousnessDisorderDao tConsciousnessDisorderDAO){
		this.baseDAO = tConsciousnessDisorderDAO;
	}

}
