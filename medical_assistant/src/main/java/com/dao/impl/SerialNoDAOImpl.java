package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.dao.SerialNoDao;
import com.model.SerialNo;

@Repository
public class SerialNoDAOImpl extends BaseDAOImpl<SerialNo, Long>  implements SerialNoDao {

	private Logger logger=Logger.getLogger(SerialNoDAOImpl.class);
	@Override
	public Map<String, Object> getNextSerialNo() {
		StringBuffer sqlStringBuffer=new StringBuffer();
		sqlStringBuffer.append(" SELECT * FROM ")
						.append(" (SELECT id, serial_no AS serialNo, create_time AS createTime FROM t_serialno ")
						.append(" ORDER BY id DESC LIMIT 1) a ");
		
		logger.info("getNextSerialNo SQL====>" + sqlStringBuffer.toString());
		List<Map<String, Object>> mapList = this.query(sqlStringBuffer.toString());
		if(!mapList.isEmpty()){
			return mapList.get(0);
		}
		return null;
	}

}
