package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bean.FamilyHistoryReqBean;
import com.dao.TFamilyHistoryDAO;
import com.model.TFamilyHistory;
import com.service.TFamilyHistoryService;
import com.util.DateUtil;
import com.util.string.MyStringUtil;
import com.util.vo.ServiceResult;
@Service
public class TFamilyHistoryServiceImpl extends BaseServiceImpl<TFamilyHistory, Long>  implements TFamilyHistoryService  {

	@Resource
	private TFamilyHistoryDAO familyHistoryDAO;
	
    @Resource
    public void setBaseDao(TFamilyHistoryDAO tFamilyHistoryDAO) {
        this.baseDAO = tFamilyHistoryDAO;
    }

	@Override
	public void getFamilyHistory(String serialNoStr, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		boolean isEmpty = true;
		TFamilyHistory tFamilyHistory = familyHistoryDAO.load("serialNo", MyStringUtil.genSerialNo(serialNoStr, accountId));
		if(null != tFamilyHistory){
			isEmpty = false;
		}
		if(!isEmpty){
			result.addData("familyHistoryModel", tFamilyHistory);
			result.setIsSuccess(true);
			result.setMessage("获取成功");
		}else{
			result.setIsSuccess(false);
			result.setMessage("获取失败");
		}
	}

	@Override
	public void deleteFimalyHistory(String serialNo, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		result.setIsSuccess(false);
		result.setMessage("删除失败");
		boolean isDelete = false;
		String realSerialNo = MyStringUtil.genSerialNo(serialNo, accountId);
		TFamilyHistory familyHistory = familyHistoryDAO.load("serialNo", realSerialNo);
		if(familyHistory != null){
			familyHistoryDAO.delete(familyHistory);
			isDelete = true;
		}
		if(isDelete){
			result.setIsSuccess(true);
			result.setMessage("删除成功");
		}
	}

	@Override
	public void saveFamilyHistory(FamilyHistoryReqBean bean3, String serialNo, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		this.checkMainStatuValid(accountId, serialNo);
		TFamilyHistory familyHistory = this.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null == familyHistory){
			familyHistory = new TFamilyHistory();
			familyHistory.setSerialNo(MyStringUtil.genSerialNo(serialNo, accountId));
			familyHistory.setCreateTime(DateUtil.getNowTimestamp());
		}
		familyHistory.setSimilarDisease(bean3.getSimilarDiseaseType());
		familyHistory.setHereditaryDisease(bean3.getHereditaryDisease());
		if(bean3.getSimilarDiseaseType() ==2){
			familyHistory.setSimilarDiseaseName(bean3.getSimilarDiseaseName());
		}
		if(bean3.getHereditaryDisease() == 2){
			familyHistory.setHereditaryDiseaseName(bean3.getHereditaryDiseaseName());
		}
		this.saveOrUpdate(familyHistory);
		result.setIsSuccess(true);
		result.setMessage("保存家族史成功");
	}

}
