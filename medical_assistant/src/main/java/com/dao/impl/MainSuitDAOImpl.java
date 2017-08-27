package com.dao.impl;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.dao.MainSuitDao;
import com.model.MainSuit;

@Repository
public class MainSuitDAOImpl extends BaseDAOImpl<MainSuit, Long>  implements MainSuitDao {
	private Logger logger=Logger.getLogger(MainSuitDAOImpl.class);
	@Override
	public List<MainSuit> getMainSuitBySerialNo(String serialNoStr) {
		List<MainSuit> mainSuitList = new ArrayList<MainSuit>();
		StringBuffer sqlStringBuffer=new StringBuffer();
		sqlStringBuffer.append(" SELECT * FROM ")
						.append(" (SELECT id, serial_no AS serialNo, main_suit_content AS mainSuitContent, main_suit_value AS mainSuitValue, attack_time AS attackTime"
								+ " , create_time AS createTime , update_time AS updateTime  FROM t_main_suit ")
						.append(" where serial_no=:serialNo ) a ");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serialNo", serialNoStr);
		logger.info("getNextSerialNo SQL====>" + sqlStringBuffer.toString());
		List<Map<String, Object>> list = this.query(sqlStringBuffer.toString(), map);
		for(Map<String, Object> mainSuitMap:list){
			MainSuit mainSuit = new MainSuit();
			BigInteger id = (BigInteger)mainSuitMap.get("id");
			String serialNo = (String)mainSuitMap.get("serialNo");
			Date createTime = (Date)mainSuitMap.get("createTime");
			String mainSuitContent = (String)mainSuitMap.get("mainSuitContent");
			Integer mainSuitValue = (Integer)mainSuitMap.get("mainSuitValue");
			Date attackTime = (Date)mainSuitMap.get("attackTime");
			Date updateTime = (Date)mainSuitMap.get("updateTime");
			mainSuit.setId(id.longValue());
			mainSuit.setSerialNo(serialNo);
			mainSuit.setCreateTime(new Timestamp(createTime.getTime()));
			mainSuit.setAttackTime(new Timestamp(attackTime.getTime()));
			mainSuit.setMainSuitContent(mainSuitContent);
			mainSuit.setMainSuitValue(mainSuitValue.intValue());
			mainSuit.setUpdateTime(new Timestamp(updateTime.getTime()));
			mainSuitList.add(mainSuit);
		}
		return mainSuitList;
	}

}
