package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bean.OtherSymptomReqBean;
import com.dao.BasicInfoDao;
import com.dao.MainSuitDao;
import com.dao.TOtherSymptomsDAO;
import com.model.TOtherSymptoms;
import com.service.TOtherSymptomsService;
import com.util.DateUtil;
import com.util.string.MyStringUtil;
import com.util.vo.ServiceResult;
@Service
public class TOtherSymptomsServiceImpl extends BaseServiceImpl<TOtherSymptoms, Long>  implements TOtherSymptomsService  {

	@Resource
	private BasicInfoDao basicInfoDao;
	@Resource
	private MainSuitDao mainSuitDao;
	
    @Resource
    public void setBaseDao(TOtherSymptomsDAO tOtherSymptomsDao) {
        this.baseDAO = tOtherSymptomsDao;
    }

	@Override
	public void saveOtherSymptom(OtherSymptomReqBean bean, ServiceResult result, Long accountId) {
		this.checkMainStatuValid(accountId, bean.getSerialNo());
		TOtherSymptoms model = this.load("serialNo", MyStringUtil.genSerialNo(bean.getSerialNo(), accountId));
		if(model == null){
			model = new TOtherSymptoms();
			model.setCreateTime(DateUtil.getNowTimestamp());
			model.setSerialNo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId));
		}
		model.setHowTheAppetite(bean.getHowTheAppetite());
		model.setHowTheMind(bean.getHowTheMind());
		model.setHowTheSleep(bean.getHowTheSleep());
		model.setLeastHalfYearWeightChangeType(bean.getLeastHalfYearWeightChangeType());
		if(bean.getLeastHalfYearWeightChangeType() == 1){
			model.setLeastHalfYearWeightDown(null);
		}else if(bean.getLeastHalfYearWeightChangeType() == 2){
			model.setLeastHalfYearWeightDown(bean.getWeightDown());
		}
		this.saveOrUpdate(model);
		result.setIsSuccess(true);
		result.setMessage("保存成功");
	}

	@Override
	public void getOtherSymptom(String serialNo, ServiceResult result, Long accountId) {
		TOtherSymptoms model = this.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != model){
			result.addData("otherSymptomModel", model);
			result.setIsSuccess(true);
			result.setMessage("获取成功");
		}else{
			result.setIsSuccess(false);
			result.setMessage("获取失败");
		}
		
	}

	@Override
	public void deleteOtherSymptom(String serialNo, ServiceResult result, Long accountId) {
		TOtherSymptoms model = this.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != model){
			this.delete(model);
			result.setIsSuccess(true);
			result.setMessage("删除成功");
		}else{
			result.setIsSuccess(false);
			result.setMessage("删除失败");
		}
	}
}
