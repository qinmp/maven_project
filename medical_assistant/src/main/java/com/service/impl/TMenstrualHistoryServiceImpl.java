package com.service.impl;
import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bean.MenstrualHistoryReqBean;
import com.dao.TMenstrualHistoryDAO;
import com.model.TMenstrualHistory;
import com.service.TMenstrualHistoryService;
import com.util.DateUtil;
import com.util.string.MyStringUtil;
import com.util.vo.ServiceResult;
@Service
public class TMenstrualHistoryServiceImpl extends BaseServiceImpl<TMenstrualHistory, Long>  implements TMenstrualHistoryService  {

	@Resource
	private TMenstrualHistoryDAO menstrualHistoryDAO;
	
    @Resource
    public void setBaseDao(TMenstrualHistoryDAO tMenstrualHistoryDAO) {
        this.baseDAO = tMenstrualHistoryDAO;
    }

	@Override
	public void getMenstrualHistory(String serialNoStr, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		boolean isEmpty = true;
		TMenstrualHistory tMenstrualHistory = menstrualHistoryDAO.load("serialNo", MyStringUtil.genSerialNo(serialNoStr, accountId));
		if(null != tMenstrualHistory){
			isEmpty = false;
		}
		if(!isEmpty){
			result.addData("menstrualHistoryModel", tMenstrualHistory);
			result.setIsSuccess(true);
			result.setMessage("获取成功");
		}else{
			result.setIsSuccess(false);
			result.setMessage("获取失败");
		}
	}

	@Override
	public void deleteMenstrualHistory(String serialNo, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		result.setIsSuccess(false);
		result.setMessage("删除失败");
		boolean isDelete = false;
		String realSerialNo = MyStringUtil.genSerialNo(serialNo, accountId);
		TMenstrualHistory menstrualHistory = menstrualHistoryDAO.load("serialNo", realSerialNo);
		if(menstrualHistory != null){
			menstrualHistoryDAO.delete(menstrualHistory);
			isDelete = true;
		}
		if(isDelete){
			result.setIsSuccess(true);
			result.setMessage("删除成功");
		}
	}

	@Override
	public void saveMenstrualHistory(MenstrualHistoryReqBean bean4, String serialNo, ServiceResult result,
			Long accountId) {
		// TODO Auto-generated method stub
		this.checkMainStatuValid(accountId, serialNo);
		TMenstrualHistory menstrualHistory = this.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null == menstrualHistory){
			menstrualHistory = new TMenstrualHistory();
			menstrualHistory.setSerialNo(MyStringUtil.genSerialNo(serialNo, accountId));
			menstrualHistory.setCreateTime(DateUtil.getNowTimestamp());
		}
		menstrualHistory.setLastMenstrualPeriod(new Timestamp(DateUtil.toDate(bean4.getLastMenstrualPeriod()).getTime()));
		menstrualHistory.setFirstMenstrualAge(bean4.getFirstMenstrualAge());
		menstrualHistory.setHowManyDayMenstrual(bean4.getHowManyDayMenstrual());
		menstrualHistory.setTwoMenstrualIntervals(bean4.getTwoMenstrualIntervals());
		
		this.saveOrUpdate(menstrualHistory);
		result.setIsSuccess(true);
		result.setMessage("保存月经史成功");
	}

}
