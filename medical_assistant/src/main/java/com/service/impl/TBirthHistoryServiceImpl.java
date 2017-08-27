package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bean.BirthHistoryReqBean;
import com.dao.TBirthHistoryDAO;
import com.model.TBirthHistory;
import com.service.TBirthHistoryService;
import com.util.DateUtil;
import com.util.string.MyStringUtil;
import com.util.vo.ServiceResult;
@Service
public class TBirthHistoryServiceImpl extends BaseServiceImpl<TBirthHistory, Long>  implements TBirthHistoryService  {

	@Resource
	private TBirthHistoryDAO birthHistoryDAO;
	
	@Resource
    public void setBaseDao(TBirthHistoryDAO tBirthHistoryDAO) {
        this.baseDAO = tBirthHistoryDAO;
    }

	@Override
	public void getBirthHistory(String serialNoStr, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		boolean isEmpty = true;
		TBirthHistory tBirthHistory = birthHistoryDAO.load("serialNo", MyStringUtil.genSerialNo(serialNoStr, accountId));
		if(null != tBirthHistory){
			isEmpty = false;
		}
		if(!isEmpty){
			result.addData("birthHistoryModel", tBirthHistory);
			result.setIsSuccess(true);
			result.setMessage("获取成功");
		}else{
			result.setIsSuccess(false);
			result.setMessage("获取失败");
		}
	}

	@Override
	public void deleteBirthHistory(String serialNo, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		result.setIsSuccess(false);
		result.setMessage("删除失败");
		boolean isDelete = false;
		String realSerialNo = MyStringUtil.genSerialNo(serialNo, accountId);
		TBirthHistory birthHistory = birthHistoryDAO.load("serialNo", realSerialNo);
		if(birthHistory != null){
			birthHistoryDAO.delete(birthHistory);
			isDelete = true;
		}
		if(isDelete){
			result.setIsSuccess(true);
			result.setMessage("删除成功");
		}
	}

	@Override
	public void saveBirthHistory(BirthHistoryReqBean bean5, String serialNo, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		this.checkMainStatuValid(accountId, serialNo);
		TBirthHistory birthHistory = this.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null == birthHistory){
			birthHistory = new TBirthHistory();
			birthHistory.setSerialNo(MyStringUtil.genSerialNo(serialNo, accountId));
			birthHistory.setCreateTime(DateUtil.getNowTimestamp());
		}
		birthHistory.setHowManyTimesDelivered(bean5.getHowManyTimesDelivered());
		birthHistory.setHowManyTimesPregnant(bean5.getHowManyTimesPregnant());
		this.saveOrUpdate(birthHistory);
		result.setIsSuccess(true);
		result.setMessage("保存生育史成功");
	}

}
