package com.service.impl;

import java.math.BigInteger;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SerialNoDao;
import com.model.SerialNo;
import com.service.SerialNoService;
import com.util.DateUtil;

@Service
public class SerialNoServiceImpl  extends BaseServiceImpl<SerialNo, Long> implements SerialNoService {

	@Autowired
	private SerialNoDao serialNoDao;

	@Resource
	public void setBaseDao(SerialNoDao serialNoDao){
		this.baseDAO = serialNoDao;
	}
	
	@Override
	public synchronized Long updateAndGetNextSerialNo() {
		Map<String, Object> map = serialNoDao.getNextSerialNo();
		if(null == map){
			SerialNo model = new SerialNo();
			model.setCreatTime(DateUtil.getNowTimestamp());
			model.setSerialNo(0L);
			this.updateOrSaveSerialNo(model);
			return 0L;
		} 
		BigInteger serialNo = (BigInteger)map.get("serialNo");
		BigInteger id = (BigInteger)map.get("id");
		SerialNo serialNoModel = serialNoDao.get(id.longValue());
		serialNoModel.setSerialNo(serialNo.longValue() + 1);
		serialNoDao.update(serialNoModel);
		return serialNo.longValue();
	}

	@Override
	public void updateOrSaveSerialNo(SerialNo serialNo) {
		serialNoDao.saveOrUpdate(serialNo);
	}


}
