package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.THaematemesisDao;
import com.model.THaematemesis;
import com.service.THaematemesisService;
@Service
public class THaematemesisServiceImpl extends BaseServiceImpl<THaematemesis, Long>  implements THaematemesisService  {

	@Resource
	public void setBaseDao(THaematemesisDao tHaematemesisDAO){
		this.baseDAO = tHaematemesisDAO;
	}
}
