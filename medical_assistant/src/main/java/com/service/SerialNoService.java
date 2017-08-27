package com.service;

import com.model.SerialNo;

public interface SerialNoService extends BaseService<SerialNo, Long>  {

	/**
	 * 获取下一个序列号
	 * @Description: 
	 * @Create: 2017年5月20日 下午7:59:03
	 * @author qinmaoping
	 * @update logs
	 * @return
	 */
	Long updateAndGetNextSerialNo();
	
	void updateOrSaveSerialNo(SerialNo serialNo);
}
