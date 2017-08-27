package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TAffectiveSymptomsDao;
import com.model.TAffectiveSymptoms;
import com.service.TAffectiveSymptomsService;
@Service
public class TAffectiveSymptomsServiceImpl extends BaseServiceImpl<TAffectiveSymptoms, Long>  implements TAffectiveSymptomsService  {
	
	@Resource
	public void setBaseDao(TAffectiveSymptomsDao tAffectiveSymptomsDAO){
		this.baseDAO = tAffectiveSymptomsDAO;
	}
}
