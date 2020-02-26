package com.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.bean.BasicInfoReqBean;
import com.bean.PresentIllnessRespBean;
import com.dao.BasicInfoDao;
import com.dao.MainSuitDao;
import com.exception.BusinessException;
import com.model.Account;
import com.model.BasicInfo;
import com.model.MainSuit;
import com.service.BasicInfoService;
import com.service.PastHistoryService;
import com.service.PresentIllnessService;
import com.service.SerialNoService;
import com.service.TBirthHistoryService;
import com.service.TFamilyHistoryService;
import com.service.TMarryHistoryService;
import com.service.TMenstrualHistoryService;
import com.service.TOtherSymptomsService;
import com.service.TPersonHistoryService;
import com.util.DateUtil;
import com.util.FtlUtils;
import com.util.session.SessionUtil;
import com.util.vo.ServiceResult;

@Service
public class BasicInfoServiceImpl  extends BaseServiceImpl<BasicInfo, Long> implements BasicInfoService {
	private Logger logger=Logger.getLogger(BasicInfoServiceImpl.class);
	@Autowired
	private BasicInfoDao basicInfoDao;
	
	@Autowired
	private MainSuitDao mainSuitDao;
	
	@Autowired
	private SerialNoService serialNoService;
	
	@Autowired
	private PresentIllnessService presentIllnessService;
	
	@Autowired
	private TOtherSymptomsService tOtherSymptomsService;
	
	@Autowired
	private PastHistoryService pastHistoryService;
	
	@Autowired
	private TPersonHistoryService personHistoryService;
	
	@Autowired
	private TMarryHistoryService marryHistoryService;
	
	@Autowired
	private TFamilyHistoryService familyHistoryService;
	
	@Autowired
	private TMenstrualHistoryService menstrualHistoryService;
	
	@Autowired
	private TBirthHistoryService birthHistoryService;

	@Resource
	public void setBaseDao(BasicInfoDao basicInfoDao){
		this.baseDAO = basicInfoDao;
	}
	
	@Override
	public void saveBasicInfo(BasicInfoReqBean bean, ServiceResult result, Long accountId) {
		BasicInfo basicInfo = null;
		if(null == accountId){
			throw new BusinessException("请先登录");
		} else if(StringUtils.isBlank(bean.getSerialNo())){
			throw new BusinessException("序列号不能为空");
		} else if(StringUtils.isBlank(bean.getName())){
			throw new BusinessException("姓名不能为空");
		} else if(StringUtils.isBlank(bean.getRealBirthDay())){
			throw new BusinessException("出生日期不能为空");
		} else if(StringUtils.isBlank(bean.getAge())){
			throw new BusinessException("年龄不能为空");
		} else if(StringUtils.isBlank(String.valueOf(bean.getSex()))){
			throw new BusinessException("性别不能为空");
		} else if(nativePlaceIsUnright(bean.getNativePlace())){
			throw new BusinessException("请填写完整籍贯");
		} else if(presentResidenceIsUnright(bean.getPresentResidence())){
			throw new BusinessException("请填写完整现居住地");
		}
		basicInfo = basicInfoDao.load("serialNo", bean.getSerialNo());
		if(null == basicInfo){
			basicInfo = new BasicInfo();
		}
		basicInfo.setAccountId(accountId);
		basicInfo.setAge(bean.getAge() + bean.getAgeText());
		basicInfo.setCreateTime(DateUtil.getNowTimestamp());
		basicInfo.setName(bean.getName());
		basicInfo.setNativePlace(bean.getNativePlace());
		basicInfo.setPresentResidence(bean.getPresentResidence());
		basicInfo.setRealBirthDay(new Timestamp(DateUtil.toDate(bean.getRealBirthDay()).getTime()));
		basicInfo.setSerialNo(bean.getSerialNo());
		basicInfo.setSex(bean.getSex());
		basicInfo.setUpdateTime(DateUtil.getNowTimestamp());
		basicInfoDao.saveOrUpdate(basicInfo);
		result.setIsSuccess(true);
		result.setMessage("保存成功");
		logger.info("-----------基本信息保存成功-----------");
	}

	private boolean presentResidenceIsUnright(String presentResidence) {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(presentResidence)){
			return true;
		} else if(presentResidence.contains("省份")){
			return true;
		} else if(presentResidence.contains("地级市")){
			return true;
		} else if(presentResidence.contains("县级市")){
			return true;
		} else {
			return false;
		}
			
	}

	private boolean nativePlaceIsUnright(String nativePlace) {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(nativePlace)){
			return true;
		} else if(nativePlace.contains("省份")){
			return true;
		} else if(nativePlace.contains("地级市")){
			return true;
		} else if(nativePlace.contains("县级市")){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getNewestSerialNoByAccountId(Long accountId) {
		
		return basicInfoDao.getNewestSerialNoByAccountId(accountId);
	}

	@Override
	public void accInfo(HttpServletRequest request, ModelMap modelMap) {

		Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
		String serialNoStr = (String)SessionUtil.getSession(request, Account.CURRENT_SERIALNO);
		serialNoStr = putSerialNoToSession(request, modelMap, accountId, serialNoStr);
		putBasicInfoToModelMap(request, modelMap, accountId, serialNoStr);
		putMainSuitToModelMap(request, modelMap, accountId, serialNoStr);
		putPresentIllnessModelMap(request, modelMap, accountId, serialNoStr);
		putOtherSymptomToModelMap(request, modelMap, accountId, serialNoStr);
		putPastHistoryToModelMap(request, modelMap, accountId, serialNoStr);
		putPersonHistoryToModelMap(request, modelMap, accountId, serialNoStr);
		putMarryHistoryToModelMap(request, modelMap, accountId, serialNoStr);
		putFamilyHistoryToModelMap(request, modelMap, accountId, serialNoStr);
		putMenstrualHistoryToModelMap(request, modelMap, accountId, serialNoStr);
		putBirthHistoryToModelMap(request, modelMap, accountId, serialNoStr);
		
	}

	private void putBirthHistoryToModelMap(HttpServletRequest request, ModelMap modelMap, Long accountId,
			String serialNoStr) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult(false, "获取失败");
		birthHistoryService.getBirthHistory(serialNoStr, result, accountId);
		if(result.getIsSuccess()){
			modelMap.put("birthHistoryModel", result.getData("birthHistoryModel"));
		}
	}

	private void putMenstrualHistoryToModelMap(HttpServletRequest request, ModelMap modelMap, Long accountId,
			String serialNoStr) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult(false, "获取失败");
		menstrualHistoryService.getMenstrualHistory(serialNoStr, result, accountId);
		if(result.getIsSuccess()){
			modelMap.put("menstrualHistoryModel", result.getData("menstrualHistoryModel"));
		}
	}

	private void putFamilyHistoryToModelMap(HttpServletRequest request, ModelMap modelMap, Long accountId,
			String serialNoStr) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult(false, "获取失败");
		familyHistoryService.getFamilyHistory(serialNoStr, result, accountId);
		if(result.getIsSuccess()){
			modelMap.put("familyHistoryModel", result.getData("familyHistoryModel"));
		}
	}

	private void putMarryHistoryToModelMap(HttpServletRequest request, ModelMap modelMap, Long accountId,
			String serialNoStr) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult(false, "获取失败");
		marryHistoryService.getMarryHistory(serialNoStr, result, accountId);
		if(result.getIsSuccess()){
			modelMap.put("marryHistoryModel", result.getData("marryHistoryModel"));
		}
	}

	private void putPersonHistoryToModelMap(HttpServletRequest request, ModelMap modelMap, Long accountId,
			String serialNoStr) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult(false, "获取失败");
		personHistoryService.getPersonHistory(serialNoStr, result, accountId);
		if(result.getIsSuccess()){
			modelMap.put("personHistoryModel", result.getData("personHistoryModel"));
		}
	}

	private void putPastHistoryToModelMap(HttpServletRequest request, ModelMap modelMap, Long accountId,
			String serialNoStr) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult(false, "获取失败");
		pastHistoryService.getPastHistory(serialNoStr, result, accountId);
		if(result.getIsSuccess()){
			modelMap.put("pastHistoryModel", result.getData("pastHistoryModel"));
		}
	}

	private void putOtherSymptomToModelMap(HttpServletRequest request, ModelMap modelMap, Long accountId,
			String serialNoStr) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult(false, "获取失败");
		tOtherSymptomsService.getOtherSymptom(serialNoStr, result, accountId);
		if(result.getIsSuccess()){
			modelMap.put("otherSymptomModel", result.getData("otherSymptomModel"));
		}
	}

	private void putPresentIllnessModelMap(HttpServletRequest request, ModelMap modelMap, Long accountId,
			String serialNoStr) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult(false, "获取失败");
		presentIllnessService.getPresentIllness(serialNoStr, result, accountId);
		if(result.getIsSuccess()){
			modelMap.put("presentIllnessModel", result.getData("presentIllnessModel"));
		}
	}

	private void putMainSuitToModelMap(HttpServletRequest request, ModelMap modelMap, Long accountId,
			String serialNoStr) {
		List<MainSuit> mainSuits = mainSuitDao.getMainSuitBySerialNo(serialNoStr);
		if(mainSuits.isEmpty()){
			modelMap.put("mainSuits", null);
		}else{
			modelMap.put("mainSuits", mainSuits);
		}
	}

	private void putBasicInfoToModelMap(HttpServletRequest request, ModelMap modelMap, Long accountId,
			String serialNoStr) {
		BasicInfo basicInfo = basicInfoDao.getBasicInfoBySerialNo(serialNoStr);
		modelMap.put("basicInfo", basicInfo);
	}

	private String putSerialNoToSession(HttpServletRequest request, ModelMap modelMap, Long accountId,
			String serialNoStr) {
		if(null != serialNoStr){
			modelMap.put("serialNo", serialNoStr);
		} else {
			String newestSerialNo = this.getNewestSerialNoByAccountId(accountId);
			String nowTimeStr = DateUtil.dateToString(new Date()).replaceAll("-", "");
			//如果是同一天，同一个人的编号，则不生成新的编号
			if(null != newestSerialNo && newestSerialNo.substring(0, 8).equals(nowTimeStr)){
				modelMap.put("serialNo", newestSerialNo);
				SessionUtil.setSession(request, Account.CURRENT_SERIALNO, newestSerialNo);
			} else {
				Long serialNum = serialNoService.updateAndGetNextSerialNo();
				nowTimeStr += getSerialNumStr(serialNum);
				modelMap.put("serialNo", nowTimeStr);
				SessionUtil.setSession(request, Account.CURRENT_SERIALNO, nowTimeStr);
			}
		}
		return (String)modelMap.get("serialNo");
	}

	private String getSerialNumStr(Long serialNum) {
		String returnStr = "";
		if(serialNum.toString().length() < 3){
			if(serialNum.toString().length() == 1){
				returnStr = "00";
				returnStr += serialNum.toString();
			} else if(serialNum.toString().length() == 2){
				returnStr = "0";
				returnStr += serialNum.toString();
			} else if(serialNum.toString().length() == 0){
				returnStr = "000";
			}
			return returnStr;
		} else {
			return serialNum.toString();
		}
	}

	@Override
	public void deleteBasicInfo(BasicInfoReqBean bean, ServiceResult result, Long accountId) {
		if(StringUtils.isBlank(bean.getSerialNo())){
			throw new BusinessException("合同编码不能为空");
		}
		List<BasicInfo> basicInfos = basicInfoDao.query(new String[]{"serialNo","accountId"}, new Object[]{bean.getSerialNo(), accountId});
		if(basicInfos.isEmpty()){
			throw new BusinessException("删除失败");
		}
		BasicInfo basicInfo = basicInfos.get(0);
		basicInfoDao.delete(basicInfo);
		
		//主诉一起删除
		List<MainSuit> mainSuits = mainSuitDao.query(new String[]{"serialNo","accountId"}, new Object[]{bean.getSerialNo(), accountId});
		if(!mainSuits.isEmpty()){
			for(MainSuit mainSuit:mainSuits){
				mainSuitDao.delete(mainSuit);
			}
		}
		presentIllnessService.deletePresentIllnessBySerialNo(bean.getSerialNo(), result, accountId);
		result.setMessage("删除成功");
		result.setIsSuccess(true);
	}

	@Override
	public void downloadReport(HttpServletRequest request, ModelMap modelMap, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<String> notIncludePresents = getnotIncludePresentList(modelMap);
		String tempStr = notIncludePresents.toString();
		modelMap.put("notIncludePresents", tempStr.subSequence(1, tempStr.length() - 1));
		String docFilePath = FtlUtils.ftlToHtmlToWord(modelMap);
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=" + "report.doc");
		FileInputStream input = new FileInputStream(docFilePath);
		byte[] bytes = new byte[1024*5];
		OutputStream out = response.getOutputStream();
		while(-1 != input.read(bytes)){
			out.write(bytes);
		}
		input.close();
		out.flush();
		out.close();
		File docFile = new File(docFilePath);
		if(docFile.exists()){
			docFile.delete();
		}
	}
	
	private List<String> getnotIncludePresentList(ModelMap modelMap) {
		List<String> list = new ArrayList<String>();
		PresentIllnessRespBean bean = (PresentIllnessRespBean)modelMap.get("presentIllnessModel");
		if(bean == null){
			return list;
		}
		if(bean.getFever() == null){
			list.add("发热");
		}
		if(bean.getCough() == null){
			list.add("咳嗽");
		}
		if(bean.gettExpectoration() == null){
			list.add("呕吐");
		}
		if(bean.gettDiarrhea() == null){
			list.add("腹泻");
		}
		if(bean.gettAstriction() == null){
			list.add("便秘");
		}
		if(bean.gettHematochezia() == null){
			list.add("便血");
		}
		if(bean.gettFat() == null){
			list.add("肥胖");
		}
		if(bean.gettMarasmus() == null){
			list.add("消瘦");
		}
		if(bean.gettDizzy() == null){
			list.add("头晕");
		}
		if(bean.gettAbnormalskin() == null){
			list.add("皮肤出现异常");
		}
		if(bean.gettOliguresis() == null){
			list.add("少尿");
		}
		if(bean.gettOtherUpdSymptom() == null){
			list.add("其他尿量相关症状");
		}
		if(bean.gettMicturition() == null){
			list.add("排尿相关症状");
		}
		if(bean.gettPain() == null){
			list.add("疼痛");
		}
		if(bean.gettHaematemesis() == null){
			list.add("呕血");
		}
		if(bean.gettHemoptysis() == null){
			list.add("咯血");
		}
		if(bean.gettDyspnea() == null){
			list.add("呼吸困难");
		}
		if(bean.gettPalpitation() == null){
			list.add("心悸");
		}
		if(bean.gettEdema() == null){
			list.add("水肿");
		}
		if(bean.getTicAndConvulsion() == null){
			list.add("抽搐与惊厥");
		}
		if(bean.gettConsciousnessDisorder() == null){
			list.add("意识障碍");
		}
		if(bean.gettAffectiveSymptoms() == null){
			list.add("情感症状");
		}
		return list;
	}
	
}
