package com.dao;

import java.util.Map;

import com.model.SerialNo;

public interface SerialNoDao extends BaseDao<SerialNo, Long>  {
	Map<String, Object> getNextSerialNo();
}
