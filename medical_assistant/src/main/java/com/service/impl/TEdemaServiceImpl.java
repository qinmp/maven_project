package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TEdemaDao;
import com.model.TEdema;
import com.service.TEdemaService;
@Service
public class TEdemaServiceImpl extends BaseServiceImpl<TEdema, Long>  implements TEdemaService  {

	@Resource
	public void setBaseDao(TEdemaDao tEdemaDAO){
		this.baseDAO = tEdemaDAO;
	}

}
