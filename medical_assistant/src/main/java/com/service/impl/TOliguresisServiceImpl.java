package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TOliguresisDao;
import com.model.TOliguresis;
import com.service.TOliguresisService;
@Service
public class TOliguresisServiceImpl extends BaseServiceImpl<TOliguresis, Long>  implements TOliguresisService  {

	@Resource
	public void setBaseDao(TOliguresisDao tOliguresisDAO){
		this.baseDAO = tOliguresisDAO;
	}
}
