package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bean.PersonHistoryReqBean;
import com.bean.enumobj.DrinkTypeEnum;
import com.bean.enumobj.SmokingTypeEnum;
import com.dao.TPersonHistoryDAO;
import com.exception.MyException;
import com.model.TPersonHistory;
import com.service.TPersonHistoryService;
import com.util.DateUtil;
import com.util.string.MyStringUtil;
import com.util.vo.ServiceResult;
@Service
public class TPersonHistoryServiceImpl extends BaseServiceImpl<TPersonHistory, Long>  implements TPersonHistoryService  {

	@Resource
	private TPersonHistoryDAO personHistoryDAO;
	
    @Resource
    public void setBaseDao(TPersonHistoryDAO tPersonHistoryDAO) {
        this.baseDAO = tPersonHistoryDAO;
    }

	@Override
	public void getPersonHistory(String serialNoStr, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		boolean isEmpty = true;
		TPersonHistory tPersonHistory = personHistoryDAO.load("serialNo", MyStringUtil.genSerialNo(serialNoStr, accountId));
		if(null != tPersonHistory){
			isEmpty = false;
		}
		if(!isEmpty){
			result.addData("personHistoryModel", tPersonHistory);
			result.setIsSuccess(true);
			result.setMessage("获取成功");
		}else{
			result.setIsSuccess(false);
			result.setMessage("获取失败");
		}
	}

	@Override
	public void savePersonHistory(PersonHistoryReqBean bean2, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		this.checkMainStatuValid(accountId, bean2.getSerialNo());
		this.checkTypeIsNotZero(bean2);
		this.innerSavePersonHistory(bean2, accountId, result);
		result.setIsSuccess(true);
		result.setMessage("保存个人史成功");
		
	}

	private void innerSavePersonHistory(PersonHistoryReqBean bean2, Long accountId, ServiceResult result) {
		// TODO Auto-generated method stub
		TPersonHistory personHistory = this.load("serialNo", MyStringUtil.genSerialNo(bean2.getSerialNo(), accountId));
		if(null == personHistory){
			personHistory = new TPersonHistory();
			personHistory.setSerialNo( MyStringUtil.genSerialNo(bean2.getSerialNo(), accountId));
			personHistory.setCreateTime(DateUtil.getNowTimestamp());
		}
		personHistory.setDrinkType(bean2.getDrinkType());
		personHistory.setAlcoholType(bean2.getAlcoholType());
		personHistory.setSmokingType(bean2.getSmokingType());
		personHistory.setHasLifeEpidemicArea(bean2.getHasLifeEpidemicArea());
		//已经不吸烟了
		personHistory.setHasSmokingYear(bean2.getHasSmokingYear());
		personHistory.setHowManyCigaretteEachDay(bean2.getHowManyCigaretteEachDay());
		if(SmokingTypeEnum.isHasNotSmoking(personHistory.getSmokingType())){
			personHistory.setNotSmokingYear(bean2.getNotSmokingYear());
		}
		personHistory.setHasDrinkYear(bean2.getHasDrinkYear());
		personHistory.setHowManyDrinkEachDay(bean2.getHowManyDrinkEachDay());
		if(DrinkTypeEnum.isHasNotDrink(bean2.getDrinkType())){
			personHistory.setNotDrinkYear(bean2.getNotDrinkYear());
		}
		if(bean2.getHasLifeEpidemicArea() == 2){
			personHistory.setEpidemicAreaPlace(bean2.getEpidemicAreaPlace());
		}
		this.saveOrUpdate(personHistory);
	}

	private void checkTypeIsNotZero(PersonHistoryReqBean bean) {
	    if(bean.getSerialNo() == null){
	    	throw new MyException("序列号不能为空");  
	    } else if(bean.getSmokingType() == 0){
			throw new MyException("请选择是否有过吸烟史");
		} else if(bean.getDrinkType() == 0){
			throw new MyException("请选择是否有过喝酒史");
		} else if(bean.getHasLifeEpidemicArea() == 0){
			throw new MyException("请选择是否到过疫地生活");
		} else if(bean.getDrinkType() != 1 && bean.getAlcoholType() == 0){
			throw new MyException("请选择酒精类型");
		} 
	}
	
	@Override
	public void deletePersonHistory(String serialNo, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		result.setIsSuccess(false);
		result.setMessage("删除失败");
		boolean isDelete = false;
		String realSerialNo = MyStringUtil.genSerialNo(serialNo, accountId);
		TPersonHistory personHistory = personHistoryDAO.load("serialNo", realSerialNo);
		if(personHistory != null){
			personHistoryDAO.delete(personHistory);
			isDelete = true;
		}
		if(isDelete){
			result.setIsSuccess(true);
			result.setMessage("删除成功");
		}
	}

}
