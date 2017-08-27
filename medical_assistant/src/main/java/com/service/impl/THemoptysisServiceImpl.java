package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.THemoptysisDao;
import com.model.THemoptysis;
import com.service.THemoptysisService;
@Service
public class THemoptysisServiceImpl extends BaseServiceImpl<THemoptysis, Long>  implements THemoptysisService  {

	@Resource
	public void setBaseDao(THemoptysisDao tHemoptysisDAO){
		this.baseDAO = tHemoptysisDAO;
	}
}
