package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TOtherUpdSymptomDao;
import com.model.TOtherUpdSymptom;
import com.service.TOtherUpdSymptomService;
@Service
public class TOtherUpdSymptomServiceImpl extends BaseServiceImpl<TOtherUpdSymptom, Long>  implements TOtherUpdSymptomService  {

	@Resource
	public void setBaseDao(TOtherUpdSymptomDao tOtherUpdSymptomDAO){
		this.baseDAO = tOtherUpdSymptomDAO;
	}
}
