package com.dao;

import com.model.BasicInfo;

public interface BasicInfoDao extends BaseDao<BasicInfo, Long>  {
	String getNewestSerialNoByAccountId(Long accountId);
	BasicInfo getBasicInfoBySerialNo(String serialNo);
}
