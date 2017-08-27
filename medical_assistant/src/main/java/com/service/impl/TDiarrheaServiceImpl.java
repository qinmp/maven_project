package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TDiarrheaDao;
import com.model.TDiarrhea;
import com.service.TDiarrheaService;
@Service
public class TDiarrheaServiceImpl extends BaseServiceImpl<TDiarrhea, Long>  implements TDiarrheaService  {

	@Resource
	public void setBaseDao(TDiarrheaDao tDiarrheaDAO){
		this.baseDAO = tDiarrheaDAO;
	}

}
