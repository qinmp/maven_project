package com.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.PastHistoryReqBean;
import com.bean.PastHistoryRespBean;
import com.exception.MyException;
import com.model.TAllergicHistory;
import com.model.TBloodTransfusion;
import com.model.TInfectionHistory;
import com.model.TMedicalHistoryReview;
import com.model.TOperationHistory;
import com.service.impl.BaseServiceImpl;
import com.util.DateUtil;
import com.util.string.MyStringUtil;
import com.util.vo.ServiceResult;

@Service
public class PastHistoryServiceImpl extends BaseServiceImpl<Object, Long> implements PastHistoryService {

	@Autowired
	private TAllergicHistoryService tAllergicHistoryService;
	
	@Autowired
	private TOperationHistoryService tOperationHistoryService;
	
	@Autowired
	private TBloodTransfusionService tBloodTransfusionService;
	
	@Autowired
	private TInfectionHistoryService tInfectionHistoryService;
	
	@Autowired
	private TMedicalHistoryReviewService tMedicalHistoryReviewService;
	
	@Override
	public void savePastHistory(PastHistoryReqBean bean, ServiceResult result, Long accountId) {
		this.checkMainStatuValid(accountId, bean.getSerialNo());
		//安全检查
		this.checkTypeIsNotZero(bean);
		//保存药物过敏史
		this.saveDrugAllergy(bean, accountId, MyStringUtil.genSerialNo(bean.getSerialNo(), accountId));
		//保存手术史
		this.saveOperationHistory(bean, accountId, MyStringUtil.genSerialNo(bean.getSerialNo(), accountId));
		//保存输血史
		this.saveTransfusionHistory(bean, accountId, MyStringUtil.genSerialNo(bean.getSerialNo(), accountId));
		//保存传染病史
		this.saveInfection_history(bean, accountId, MyStringUtil.genSerialNo(bean.getSerialNo(), accountId));
		//保存病史回顾
		this.saveMedicalHistoryReview(bean, accountId, MyStringUtil.genSerialNo(bean.getSerialNo(), accountId));
		
		result.setIsSuccess(true);
		result.setMessage("保存成功");
	}

	/**保存病史回顾
	 * @param bean
	 * @param accountId
	 */
	private void saveMedicalHistoryReview(PastHistoryReqBean bean, Long accountId, String realSerialNo) {
		// TODO Auto-generated method stub
		TMedicalHistoryReview model = tMedicalHistoryReviewService.load("serialNo", realSerialNo);
		if(model == null){
			model = new TMedicalHistoryReview();
			model.setSerialNo(realSerialNo);
			model.setCreateTime(DateUtil.getNowTimestamp());
		}
		model.setNotYetBeenCured(bean.getUntreatedDiseaseHistoryType());
		model.setDrugsTaken(bean.getHasDrugsBeingUsedType());
		if(bean.getUntreatedDiseaseHistoryType() == 1){
			if(bean.getUntreatedDiseaseTime() == null || bean.getUntreatedDiseaseName() == null){
				throw new MyException("未治愈疾病发病时间或者未治愈疾病名称不能为空");
			}
			model.setIllnessName(bean.getUntreatedDiseaseName());
			model.setHappendTime(new Timestamp(DateUtil.toDate(bean.getUntreatedDiseaseTime()).getTime()));
		} else if(bean.getUntreatedDiseaseHistoryType() == 2){
			model.setIllnessName(null);
			model.setHappendTime(null);
		}
		
		if(bean.getHasDrugsBeingUsedType() == 1){
			if(bean.getDrugsBeingUsedTime() == null || bean.getDrugsBeingUsedName() == null){
				throw new MyException("正在服用的药物开始服用时间或者药名不能为空");
			}
			model.setDrugsTakenTime(new Timestamp(DateUtil.toDate(bean.getDrugsBeingUsedTime()).getTime()));
			model.setDrugsName(bean.getDrugsBeingUsedName());
		} else if(bean.getHasDrugsBeingUsedType() == 2){
			model.setDrugsTakenTime(null);
			model.setDrugsName(null);
		}
		tMedicalHistoryReviewService.saveOrUpdate(model);
	}

	/**保存传染病史
	 * @param bean
	 * @param accountId
	 */
	private void saveInfection_history(PastHistoryReqBean bean, Long accountId, String realSerialNo) {
		// TODO Auto-generated method stub
		TInfectionHistory model = tInfectionHistoryService.load("serialNo", realSerialNo);
		if(model == null){
			model = new TInfectionHistory();
			model.setSerialNo(realSerialNo);
			model.setCreateTime(DateUtil.getNowTimestamp());
		}
		model.setHepatitisB(bean.getHepatitisBHistoryType());
		model.setTuberculosis(bean.getTuberculosisHistoryType());
		tInfectionHistoryService.saveOrUpdate(model);
	}

	/**保存输血史
	 * @param bean
	 * @param accountId
	 */
	private void saveTransfusionHistory(PastHistoryReqBean bean, Long accountId, String realSerialNo) {
		// TODO Auto-generated method stub
		TBloodTransfusion model = tBloodTransfusionService.load("serialNo", realSerialNo);
		if(model == null){
			model = new TBloodTransfusion();
			model.setSerialNo(realSerialNo);
			model.setCreateTime(DateUtil.getNowTimestamp());
		}
		model.setBloodTransfusionType(bean.getTransfusionHistoryType());
		if(bean.getTransfusionHistoryType() == 1){
			if(bean.getTransfusionTime() == null || bean.getTransfusionOperationName() == null){
				throw new MyException("输血时间或者输血手术名称不能为空");
			}
			model.setBloodTransfusionTime(new Timestamp(DateUtil.toDate(bean.getTransfusionTime()).getTime()));
			model.setOperationName(bean.getTransfusionOperationName());
		}else if(bean.getTransfusionHistoryType() == 2){
			model.setBloodTransfusionTime(null);
			model.setOperationName(null);
		}
		tBloodTransfusionService.saveOrUpdate(model);
		
	}

	/**
	 * 保存手术史
	 * @param bean
	 * @param accountId
	 */
	private void saveOperationHistory(PastHistoryReqBean bean, Long accountId, String realSerialNo) {
		// TODO Auto-generated method stub
		TOperationHistory model = tOperationHistoryService.load("serialNo", realSerialNo);
		if(model == null){
			model = new TOperationHistory();
			model.setSerialNo(realSerialNo);
			model.setCreateTime(DateUtil.getNowTimestamp());
		}
		model.setOperationType(bean.getOperationHistoryType());
		if(bean.getOperationHistoryType() == 2){
			model.setOperationName(null);
			model.setOperationTime(null);
		} else if(bean.getOperationHistoryType() == 1){
			if(bean.getOperationName() == null || bean.getOperationTime() == null){
				throw new MyException("手术名称或者手术时间不能为空");
			}
			model.setOperationName(bean.getOperationName());
			model.setOperationTime(new Timestamp(DateUtil.toDate(bean.getOperationTime()).getTime()));
		}
		tOperationHistoryService.saveOrUpdate(model);
	}

	/**
	 * 保存药物过敏史
	 * @param bean
	 * @param accountId
	 */
	private void saveDrugAllergy(PastHistoryReqBean bean, Long accountId, String realSerialNo) {
		// TODO Auto-generated method stub
		TAllergicHistory model = tAllergicHistoryService.load("serialNo", realSerialNo);
		if(model == null){
			model = new TAllergicHistory();
			model.setSerialNo(realSerialNo);
			model.setCreateTime(DateUtil.getNowTimestamp());
		}
		model.setAllergicType(bean.getDrugAllergyType());
		if(bean.getDrugAllergyType() == 2){
			model.setAllergicMedicineName(null);
		}else if(bean.getDrugAllergyType() == 1){
			model.setAllergicMedicineName(bean.getDrugName());
		}
		tAllergicHistoryService.saveOrUpdate(model);
	}

	private void checkTypeIsNotZero(PastHistoryReqBean bean) {
	    if(bean.getSerialNo() == null){
	    	throw new MyException("序列号不能为空");  
	    } else if(bean.getDrugAllergyType() == 0){
			throw new MyException("请选择是否有过敏药物");
		} else if(bean.getOperationHistoryType() == 0){
			throw new MyException("请选择是否有过手术史");
		} else if(bean.getTransfusionHistoryType() == 0){
			throw new MyException("请选择是否有过输血史");
		} else if(bean.getHepatitisBHistoryType() == 0){
			throw new MyException("请选择是否是乙肝感染者");
		} else if(bean.getTuberculosisHistoryType() == 0){
			throw new MyException("请选择是否是结核感染患者");
		} else if(bean.getUntreatedDiseaseHistoryType() == 0){
			throw new MyException("请选择有尚未治愈的疾病");
		} else if(bean.getHasDrugsBeingUsedType() == 0){
			throw new MyException("请选择有正在服用的药物");
		}
		
	}

	@Override
	public void getPastHistory(String serialNo, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		PastHistoryRespBean bean = new PastHistoryRespBean();
		bean.setSerialNo(serialNo);
		final String realSerialNo = MyStringUtil.genSerialNo(serialNo, accountId); 
		boolean isEmpty = true;
		TAllergicHistory tAllergicHistory = tAllergicHistoryService.load("serialNo", realSerialNo);
		if(null != tAllergicHistory){
			bean.settAllergicHistory(tAllergicHistory);
			isEmpty = false;
		}
		TOperationHistory tOperationHistory = tOperationHistoryService.load("serialNo", realSerialNo);
		if(null != tOperationHistory){
			bean.settOperationHistory(tOperationHistory);
			isEmpty = false;
		}
		TBloodTransfusion tBloodTransfusion = tBloodTransfusionService.load("serialNo", realSerialNo);
		if(null != tBloodTransfusion){
			bean.settBloodTransfusion(tBloodTransfusion);
			isEmpty = false;
		}
		TInfectionHistory tInfectionHistory = tInfectionHistoryService.load("serialNo", realSerialNo);
		if(null != tInfectionHistory){
			bean.settInfectionHistory(tInfectionHistory);
			isEmpty = false;
		}
		TMedicalHistoryReview tMedicalHistoryReview = tMedicalHistoryReviewService.load("serialNo", realSerialNo);
		if(null != tMedicalHistoryReview){
			bean.settMedicalHistoryReview(tMedicalHistoryReview);
			isEmpty = false;
		}
		
		if(!isEmpty){
			result.addData("pastHistoryModel", bean);
			result.setIsSuccess(true);
			result.setMessage("获取成功");
		}else{
			result.setIsSuccess(false);
			result.setMessage("获取失败");
		}
		
	}

	@Override
	public void deletePastHistory(String serialNo, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		result.setIsSuccess(false);
		result.setMessage("删除失败");
		boolean isDelete = false;
		String realSerialNo = MyStringUtil.genSerialNo(serialNo, accountId);
		TAllergicHistory tAllergicHistory = tAllergicHistoryService.load("serialNo", realSerialNo);
		if(tAllergicHistory != null){
			tAllergicHistoryService.delete(tAllergicHistory);
			isDelete = true;
		}
		TOperationHistory tOperationHistory = tOperationHistoryService.load("serialNo", realSerialNo);
		if(tOperationHistory != null){
			tOperationHistoryService.delete(tOperationHistory);
			isDelete = true;
		}
		TBloodTransfusion tBloodTransfusion = tBloodTransfusionService.load("serialNo", realSerialNo);
		if(tBloodTransfusion != null){
			tBloodTransfusionService.delete(tBloodTransfusion);
			isDelete = true;
		}
		TInfectionHistory tInfectionHistory = tInfectionHistoryService.load("serialNo", realSerialNo);
		if(tInfectionHistory != null){
			tInfectionHistoryService.delete(tInfectionHistory);
			isDelete = true;
		}
		TMedicalHistoryReview tMedicalHistoryReview = tMedicalHistoryReviewService.load("serialNo", realSerialNo);
		if(tMedicalHistoryReview != null){
			tMedicalHistoryReviewService.delete(tMedicalHistoryReview);
			isDelete = true;
		}
		if(isDelete){
			result.setIsSuccess(true);
			result.setMessage("删除成功");
		}
	}

}
