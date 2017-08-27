package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TPalpitationDao;
import com.model.TPalpitation;
import com.service.TPalpitationService;
@Service
public class TPalpitationServiceImpl extends BaseServiceImpl<TPalpitation, Long>  implements TPalpitationService  {
	@Resource
	public void setBaseDao(TPalpitationDao tPalpitationDAO){
		this.baseDAO = tPalpitationDAO;
	}
}
