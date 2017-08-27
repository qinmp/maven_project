package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dao.BasicInfoDao;
import com.model.BasicInfo;

@Repository
public class BasicInfoDAOImpl extends BaseDAOImpl<BasicInfo, Long>  implements BasicInfoDao {

	@Override
	public String getNewestSerialNoByAccountId(Long accountId) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select a.serial_no AS serialNo, a.create_time AS createTime, a.account_id AS "
				+ "accountId from t_basic_info a where a.account_id=:accountId order by a.create_time DESC limit 1 ;");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accountId", accountId);
		List<Map<String, Object>> list = this.query(stringBuilder.toString(), map);
		if(!list.isEmpty()){
			Map<String, Object> tempMap = list.get(0);
			String newestSerialNo = (String)tempMap.get("serialNo");
			return newestSerialNo;
		}
		return null;
	}

	@Override
	public BasicInfo getBasicInfoBySerialNo(String serialNo) {
		// TODO Auto-generated method stub
		return this.load("serialNo", serialNo);
	}

}
