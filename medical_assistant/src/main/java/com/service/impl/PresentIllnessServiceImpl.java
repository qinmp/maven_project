package com.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.PresentIllnessReqBean;
import com.bean.PresentIllnessRespBean;
import com.bean.enumobj.AbnormalSkinTypeEnum;
import com.bean.enumobj.AstrictionTimesOfWeekTypeEnum;
import com.bean.enumobj.AstrictionTypeEnum;
import com.bean.enumobj.ContinuousOrIntermittentTypeEnum;
import com.bean.enumobj.DiarrheaTypeEnum;
import com.bean.enumobj.LimbsTrunkAbnormalSkinEnum;
import com.bean.enumobj.OtherUDPSymtomTypeEnum;
import com.bean.enumobj.PainPropertyTypeEnum;
import com.bean.enumobj.PainTypeEnum;
import com.bean.enumobj.RelationshipBetweenEatingAndEatingTypeEnum;
import com.exception.BusinessException;
import com.model.TAbnormalskin;
import com.model.TAffectiveSymptoms;
import com.model.TAstriction;
import com.model.TConsciousnessDisorder;
import com.model.TCough;
import com.model.TDiarrhea;
import com.model.TDizzy;
import com.model.TDyspnea;
import com.model.TEdema;
import com.model.TExpectoration;
import com.model.TFat;
import com.model.TFever;
import com.model.THaematemesis;
import com.model.THematochezia;
import com.model.THemoptysis;
import com.model.TMarasmus;
import com.model.TMicturition;
import com.model.TNotAllAbove;
import com.model.TOliguresis;
import com.model.TOtherUpdSymptom;
import com.model.TPain;
import com.model.TPalpitation;
import com.model.TTicAndConvulsion;
import com.model.TVomit;
import com.service.PresentIllnessService;
import com.service.TAbnormalskinService;
import com.service.TAffectiveSymptomsService;
import com.service.TAstrictionService;
import com.service.TConsciousnessDisorderService;
import com.service.TCoughService;
import com.service.TDiarrheaService;
import com.service.TDizzyService;
import com.service.TDyspneaService;
import com.service.TEdemaService;
import com.service.TExpectorationService;
import com.service.TFatService;
import com.service.TFeverService;
import com.service.THaematemesisService;
import com.service.THematocheziaService;
import com.service.THemoptysisService;
import com.service.TMarasmusService;
import com.service.TMicturitionService;
import com.service.TNotAllAboveService;
import com.service.TOliguresisService;
import com.service.TOtherUpdSymptomService;
import com.service.TPainService;
import com.service.TPalpitationService;
import com.service.TTicAndConvulsionService;
import com.service.TVomitService;
import com.util.DateUtil;
import com.util.string.MyStringUtil;
import com.util.vo.ServiceResult;

@Service
public class PresentIllnessServiceImpl extends BaseServiceImpl<Object, Long> implements PresentIllnessService {
	private Logger logger=Logger.getLogger(PresentIllnessServiceImpl.class);
	//保存发烧体温；
	@Autowired
	private TFeverService feverService;
	//保存咳嗽信息
	@Autowired
	private TCoughService coughService;
	//保存咳痰信息
	@Autowired
	private TExpectorationService expectorationService;
	//保存呕吐信息
	@Autowired
	private TVomitService  vomitService;
	//保存腹泻信息
	@Autowired
	private TDiarrheaService diarrheaService;
	//保存便秘信息
	@Autowired
	private TAstrictionService astrictionService;
	//保存便血信息
	@Autowired
	private THematocheziaService hematocheziaService;
	//保存肥胖信息
	@Autowired
	private TFatService fatService;
	//保存消瘦信息
	@Autowired
	private TMarasmusService marasmusService;
	//保存头晕信息
	@Autowired
	private TDizzyService dizzyService;
	//保存皮肤出现异常信息
	@Autowired
	private TAbnormalskinService abnormalSkinService;
	//保存少尿信息
	@Autowired
	private TOliguresisService oliguresisService;
	//其他尿量相关症状
	@Autowired
	private TOtherUpdSymptomService otherUPDSymptomService;
	//排尿相关症状
	@Autowired
	private TMicturitionService micturitionService;
	//疼痛
	@Autowired
	private TPainService painService;
	//呕血
	@Autowired
	private THaematemesisService tHaematemesisService;
	//咯血
	@Autowired
	private THemoptysisService tHemoptysisService;
	//呼吸困难
	@Autowired
	private TDyspneaService tDyspneaService;
	//心悸
	@Autowired
	private TPalpitationService tPalpitationService;
	//水肿
	@Autowired
	private TEdemaService tEdemaService;
	//抽搐与惊厥
	@Autowired
	private TTicAndConvulsionService tTicAndConvulsionService;
	//意识障碍
	@Autowired
	private TConsciousnessDisorderService tConsciousnessDisorderService;
	//情感症状
	@Autowired
	private TAffectiveSymptomsService tAffectiveSymptomsService;
	//以上都不是
	@Autowired
	private TNotAllAboveService tNotAllAboveService;
	
	
	@Override
	public void savePresentIllness(PresentIllnessReqBean bean, ServiceResult result, Long accountId) {
		this.checkMainStatuValid(accountId, bean.getSerialNo());
		//检查参数合法性
		this.checkPresentIllnessReqBeanIsright(bean);
		this.innerSavePresentIllness(bean, accountId, result);
		result.setIsSuccess(true);
		result.setMessage("保存现状成功");
	}

	private void innerSavePresentIllness(PresentIllnessReqBean bean, Long accountId, ServiceResult result) {
		//保存发烧体温；
		if(bean.getHightDegree() != 0 && bean.getLowDegree() != 0){
			saveFeverDegree(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getHightDegree(), bean.getLowDegree());
		}
		//保存咳嗽信息
		if(StringUtils.isNoneBlank(bean.getCoughStartTime())){
			saveCoughStartTime(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getCoughStartTime());
		}
		//保存咳痰信息
		if(bean.getExpectoration() != 0){
			saveExpectorationInfo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getExpectoration());
		}
		//保存呕吐信息
		if(bean.getVomit() != 0){
			saveVomitInfo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getVomit());
		}
		//保存腹泻信息
		if(bean.getDiarrheaType() != 0){
			saveDiarrheaInfo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getDiarrheaType(), bean.getDiarrheaContinueTime(), bean.getTimes());
		}
		//保存便秘信息
		if(bean.getAstrictionType() != 0){
			saveAstrictionInfo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getAstrictionType(), bean.getAstrictionTimesOfWeekType());
		}
		//保存便血信息
		if(bean.getHematocheziaType() != 0){
			saveHematocheziaInfo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getHematocheziaType());
		}
		//保存肥胖信息
		if(bean.getFatCurrentWeight() != 0 && bean.getFatHight() != 0 && bean.getFatWeightBMI() != 0){
			saveFatInfo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getFatCurrentWeight(), bean.getFatHight(), bean.getFatWeightBMI());
		}
		//保存消瘦信息
		if(bean.getMarasmusCurrentWeight() != 0 && bean.getMarasmusHight() != 0 && 
				bean.getMarasmusWeightBMI() != 0 && bean.getMarasmusWeightDown() != 0){
			saveMarasmusInfo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getMarasmusCurrentWeight(), bean.getMarasmusHight(), 
					bean.getMarasmusWeightBMI(), bean.getMarasmusWeightDown());
		}
		//保存头晕信息
		if(bean.getDizzyType() != 0){
			saveDizzyInfo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getDizzyType());
		}
		//保存皮肤出现异常信息
		if(bean.getAbnormalSkinType() != 0){
			saveAbnormalSkinInfo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getAbnormalSkinType(), bean.getLimbsTrunkAbnormalSkinType(), bean.getOtherAbnormalSkin());
		}
		//保存少尿信息
		if(bean.getOliguresis() != 0){
			saveOliguresisInfo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getOliguresis());
		}
		//保存其他尿量相关信息
		if(bean.getOtherUPDSymptomType() != 0){
			saveOtherUPDSymptomInfo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getOtherUPDSymptomType(), bean.getOtherUPDDiuresis(), bean.getOtherUPDAnuria());
		}
		//保存排尿相关症状
		if(bean.getMicturitionRelatedSymptomsType() != 0){
			saveMicturitionRelatedSymptomsInfo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getMicturitionRelatedSymptomsType());
		}
		//保存疼痛相关信息
		if(bean.getPainType() != 0){
			savePainInfo(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getPainType(), bean.getPainContinueTime(), bean.getContinuousOrIntermittentType(),
					bean.getRelationshipBetweenEatingAndEatingType(), bean.getPainPropertyType());
		}
		
		//保存呕血
		if(bean.getHaematemesis() != 0){
			saveHaematemesis(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getHaematemesis());
		}
		//保存咯血
		if(bean.getHemoptysis() != 0){
			saveHemoptysis(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getHemoptysis());
		}
		//保存呼吸困难
		if(bean.getDyspnea() != 0){
			saveDyspnea(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getDyspnea());
		}
		//保存心悸
		if(bean.getPalpitation() != 0){
			savePalpitation(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getPalpitation());
		}
		//保存水肿
		if(bean.getEdema() != 0){
			saveEdema(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getEdema());
		}
		//保存抽搐与惊厥
		if(bean.getTicAndConvulsion() != 0){
			saveTicAndConvulsion(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getTicAndConvulsion());
		}
		//保存意识障碍
		if(bean.getConsciousnessDisorder() != 0){
			saveConsciousnessDisorder(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getConsciousnessDisorder());
		}
		//保存情感症状
		if(bean.getAffectiveSymptoms() != 0){
			saveAffectiveSymptoms(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getAffectiveSymptoms());
		}
		//保存以上都不是
		if(bean.getNotAllAbove() != 0){
			saveNotAllAbove(MyStringUtil.genSerialNo(bean.getSerialNo(), accountId), bean.getNotAllAbove(), bean.getOther_problem());
		}
	}

	private void saveHaematemesis(String genSerialNo, Integer haematemesis) {
		
		THaematemesis tHaematemesis = tHaematemesisService.load("serialNo", genSerialNo);
		if(tHaematemesis == null){
			tHaematemesis = new THaematemesis();
			tHaematemesis.setSerialNo(genSerialNo);
			tHaematemesis.setCreateTime(DateUtil.getNowTimestamp());
		}
		if(haematemesis == 1){
			tHaematemesis.setName("呕血");
		}
		logger.info(String.format("THaematemesis:[%d] ", haematemesis));
		tHaematemesisService.saveOrUpdate(tHaematemesis);
	}

	private void saveHemoptysis(String genSerialNo, Integer hemoptysis) {
		THemoptysis tHemoptysis = tHemoptysisService.load("serialNo", genSerialNo);
		if(tHemoptysis == null){
			tHemoptysis = new THemoptysis();
			tHemoptysis.setSerialNo(genSerialNo);
			tHemoptysis.setCreateTime(DateUtil.getNowTimestamp());
		}
		if(hemoptysis == 1){
			tHemoptysis.setName("咳血");
		}
		logger.info(String.format("THemoptysis:[%d] ", hemoptysis));
		tHemoptysisService.saveOrUpdate(tHemoptysis);
	}

	private void saveDyspnea(String genSerialNo, Integer dyspnea) {
		TDyspnea tDyspnea = tDyspneaService.load("serialNo", genSerialNo);
		if(tDyspnea == null){
			tDyspnea = new TDyspnea();
			tDyspnea.setSerialNo(genSerialNo);
			tDyspnea.setCreateTime(DateUtil.getNowTimestamp());
		}
		if(dyspnea == 1){
			tDyspnea.setName("呼吸困难");
		}
		logger.info(String.format("TDyspnea:[%d] ", dyspnea));
		tDyspneaService.saveOrUpdate(tDyspnea);
	}

	private void savePalpitation(String genSerialNo, Integer palpitation) {
		TPalpitation tPalpitation = tPalpitationService.load("serialNo", genSerialNo);
		if(tPalpitation == null){
			tPalpitation = new TPalpitation();
			tPalpitation.setSerialNo(genSerialNo);
			tPalpitation.setCreateTime(DateUtil.getNowTimestamp());
		}
		if(palpitation == 1){
			tPalpitation.setName("心悸");
		}
		logger.info(String.format("TPalpitation:[%d] ", palpitation));
		tPalpitationService.saveOrUpdate(tPalpitation);
	}

	private void saveEdema(String genSerialNo, Integer edema) {
		TEdema tEdema = tEdemaService.load("serialNo", genSerialNo);
		if(tEdema == null){
			tEdema = new TEdema();
			tEdema.setSerialNo(genSerialNo);
			tEdema.setCreateTime(DateUtil.getNowTimestamp());
		}
		if(edema == 1){
			tEdema.setName("水肿");
		}
		logger.info(String.format("TEdema:[%d] ", edema));
		tEdemaService.saveOrUpdate(tEdema);
		
	}

	private void saveTicAndConvulsion(String serialNo, Integer ticAndConvulsion) {
		TTicAndConvulsion tTicAndConvulsion = tTicAndConvulsionService.load("serialNo", serialNo);
		if(tTicAndConvulsion == null){
			tTicAndConvulsion = new TTicAndConvulsion();
			tTicAndConvulsion.setSerialNo(serialNo);
			tTicAndConvulsion.setCreateTime(DateUtil.getNowTimestamp());
		}
		if(ticAndConvulsion == 1){
			tTicAndConvulsion.setName("抽搐与惊厥");
		}
		logger.info(String.format("TTicAndConvulsion:[%d] ", ticAndConvulsion));
		tTicAndConvulsionService.saveOrUpdate(tTicAndConvulsion);
		
	}

	private void saveConsciousnessDisorder(String serialNo, Integer consciousnessDisorder) {
		TConsciousnessDisorder tConsciousnessDisorder = tConsciousnessDisorderService.load("serialNo", serialNo);
		if(tConsciousnessDisorder == null){
			tConsciousnessDisorder = new TConsciousnessDisorder();
			tConsciousnessDisorder.setSerialNo(serialNo);
			tConsciousnessDisorder.setCreateTime(DateUtil.getNowTimestamp());
		}
		if(consciousnessDisorder == 1){
			tConsciousnessDisorder.setName("意识障碍");
		}
		logger.info(String.format("TConsciousnessDisorder:[%d] ", consciousnessDisorder));
		tConsciousnessDisorderService.saveOrUpdate(tConsciousnessDisorder);
		
	}

	private void saveAffectiveSymptoms(String serialNo, Integer affectiveSymptoms) {
		TAffectiveSymptoms tAffectiveSymptoms = tAffectiveSymptomsService.load("serialNo", serialNo);
		if(tAffectiveSymptoms == null){
			tAffectiveSymptoms = new TAffectiveSymptoms();
			tAffectiveSymptoms.setSerialNo(serialNo);
			tAffectiveSymptoms.setCreateTime(DateUtil.getNowTimestamp());
		}
		if(affectiveSymptoms == 1){
			tAffectiveSymptoms.setName("情感症状");
		}
		logger.info(String.format("TAffectiveSymptoms:[%d] ", affectiveSymptoms));
		tAffectiveSymptomsService.saveOrUpdate(tAffectiveSymptoms);
		
	}

	private void saveNotAllAbove(String serialNo, Integer notAllAbove, String other_problem) {
		TNotAllAbove tNotAllAbove = tNotAllAboveService.load("serialNo", serialNo);
		if(tNotAllAbove == null){
			tNotAllAbove = new TNotAllAbove();
			tNotAllAbove.setSerialNo(serialNo);
			tNotAllAbove.setCreateTime(DateUtil.getNowTimestamp());
		}
		if(notAllAbove == 1){
			tNotAllAbove.setName("以上都不是");
			tNotAllAbove.setOtherStr(other_problem);
		}
		logger.info(String.format("TNotAllAbove:[%d] ", notAllAbove));
		tNotAllAboveService.saveOrUpdate(tNotAllAbove);
		
	}
	
	private void savePainInfo(String serialNo, Integer painType, String painStartTime, Integer continuousOrIntermittentType, 
			Integer relationshipBetweenEatingAndEatingType, Integer painPropertyType) {
		// TODO Auto-generated method stub
		TPain tPain = painService.load("serialNo", serialNo);
		if(tPain == null){
			tPain = new TPain();
			tPain.setSerialNo(serialNo);
			tPain.setCreateTime(DateUtil.getNowTimestamp());
		}
		tPain.setPainType(painType.shortValue());
		//腹疼
		if(PainTypeEnum.isAbdominalPain(painType)){
			tPain.setPainStartTime(new Timestamp(DateUtil.toDate(painStartTime).getTime()));
			tPain.setPainContinuousOrIntermittentType(continuousOrIntermittentType.shortValue());
			//间歇性疼痛
			if(ContinuousOrIntermittentTypeEnum.isIntermittent(continuousOrIntermittentType)){
				tPain.setRelationshipBetweenEatingAndEatingType(relationshipBetweenEatingAndEatingType.shortValue());
				tPain.setPainPropertyType(painPropertyType.shortValue());
			} else{
				tPain.setRelationshipBetweenEatingAndEatingType(RelationshipBetweenEatingAndEatingTypeEnum.NotSelect.getValue().shortValue());
				tPain.setPainPropertyType(PainPropertyTypeEnum.NotSelect.getValue().shortValue());
			}
		}else{
			tPain.setPainStartTime(null);
			tPain.setPainContinuousOrIntermittentType(ContinuousOrIntermittentTypeEnum.NotSelect.getValue().shortValue());
			tPain.setRelationshipBetweenEatingAndEatingType(RelationshipBetweenEatingAndEatingTypeEnum.NotSelect.getValue().shortValue());
			tPain.setPainPropertyType(PainPropertyTypeEnum.NotSelect.getValue().shortValue());
		}
		logger.info(String.format("Pain info :[painType:%d, painStartTime:%s, continuousOrIntermittentType:%d, "
				+ "relationshipBetweenEatingAndEatingType:%d, painPropertyType:%d] ",
				painType, painStartTime, continuousOrIntermittentType, relationshipBetweenEatingAndEatingType, painPropertyType));
		painService.saveOrUpdate(tPain);
	}

	private void saveMicturitionRelatedSymptomsInfo(String serialNo, Integer micturitionRelatedSymptomsType) {
		// TODO Auto-generated method stub
		TMicturition tMicturition = micturitionService.load("serialNo", serialNo);
		if(tMicturition == null){
			tMicturition = new TMicturition();
			tMicturition.setSerialNo(serialNo);
			tMicturition.setCreateTime(DateUtil.getNowTimestamp());
		}
		tMicturition.setMicturitionSymptom(micturitionRelatedSymptomsType.shortValue());
		logger.info(String.format("MicturitionType:[%d] ", micturitionRelatedSymptomsType));
		micturitionService.saveOrUpdate(tMicturition);
	}

	private void saveOtherUPDSymptomInfo(String serialNo, Integer otherUPDSymptomType, Integer otherUPDDiuresis,
			Integer otherUPDAnuria) {
		// TODO Auto-generated method stub
		TOtherUpdSymptom tOtherUpdSymptom = otherUPDSymptomService.load("serialNo", serialNo);
		if(tOtherUpdSymptom == null){
			tOtherUpdSymptom = new TOtherUpdSymptom();
			tOtherUpdSymptom.setSerialNo(serialNo);
			tOtherUpdSymptom.setCreateTime(DateUtil.getNowTimestamp());
		}
		tOtherUpdSymptom.setUpdSymptom(otherUPDSymptomType.shortValue());
		//多尿
		if(OtherUDPSymtomTypeEnum.isDiuresis(otherUPDSymptomType)){
			tOtherUpdSymptom.setDiuresisUpd(otherUPDDiuresis);
			tOtherUpdSymptom.setAnuriaUpd(null);
		//少尿
		} else if(OtherUDPSymtomTypeEnum.isNoUrine(otherUPDSymptomType)){
			tOtherUpdSymptom.setDiuresisUpd(null);
			tOtherUpdSymptom.setAnuriaUpd(otherUPDAnuria);
		}
		logger.info(String.format("OtherUPDSymptom info :[otherUPDSymptomType:%d, otherUPDDiuresis:%d, otherUPDAnuria:%d] ", 
				otherUPDSymptomType, otherUPDDiuresis, otherUPDAnuria));
		otherUPDSymptomService.saveOrUpdate(tOtherUpdSymptom);
	}

	private void saveOliguresisInfo(String serialNo, Integer oliguresis) {
		// TODO Auto-generated method stub
		TOliguresis tOliguresis = oliguresisService.load("serialNo", serialNo);
		if(tOliguresis == null){
			tOliguresis = new TOliguresis();
			tOliguresis.setSerialNo(serialNo);
			tOliguresis.setCreateTime(DateUtil.getNowTimestamp());
		}
		tOliguresis.setUpdSymptom(oliguresis);
		logger.info(String.format("Oliguresis UPD:%d ", oliguresis));
		oliguresisService.saveOrUpdate(tOliguresis);
	}

	private void saveAbnormalSkinInfo(String serialNo, Integer abnormalSkinType, Integer limbsTrunkAbnormalSkinType,
			String otherAbnormalSkin) {
		// TODO Auto-generated method stub
		TAbnormalskin tAbnormalskin = abnormalSkinService.load("serialNo", serialNo);
		if(tAbnormalskin == null){
			tAbnormalskin = new TAbnormalskin();
			tAbnormalskin.setSerialNo(serialNo);
			tAbnormalskin.setCreateTime(DateUtil.getNowTimestamp());
		}
		tAbnormalskin.setAbnormalSkin(abnormalSkinType.shortValue());
		if(AbnormalSkinTypeEnum.isLimbsTrunk(abnormalSkinType)){
			tAbnormalskin.setLimbsTrunk(limbsTrunkAbnormalSkinType.shortValue());
			if(LimbsTrunkAbnormalSkinEnum.isOther(limbsTrunkAbnormalSkinType)){
				tAbnormalskin.setOtherProblem(otherAbnormalSkin);
			} else {
				tAbnormalskin.setOtherProblem(null);
			}
		}else{
			tAbnormalskin.setLimbsTrunk(LimbsTrunkAbnormalSkinEnum.NotSelect.getValue().shortValue());
			tAbnormalskin.setOtherProblem(null);
		}
		logger.info(String.format("AbnormalSkinInfo :[abnormalSkinType:%d,limbsTrunkAbnormalSkinType:%d,otherAbnormalSkin:%s]", 
				abnormalSkinType, limbsTrunkAbnormalSkinType, otherAbnormalSkin));
		abnormalSkinService.saveOrUpdate(tAbnormalskin);
	}

	private void saveDizzyInfo(String serialNo, Integer dizzyType) {
		// TODO Auto-generated method stub
		TDizzy tDizzy = dizzyService.load("serialNo", serialNo);
		if(tDizzy == null){
			tDizzy = new TDizzy();
			tDizzy.setSerialNo(serialNo);
			tDizzy.setCreateTime(DateUtil.getNowTimestamp());
		}
		tDizzy.setDizzy(dizzyType.shortValue());
		logger.info(String.format("dizzyType type:%d", dizzyType));
		dizzyService.saveOrUpdate(tDizzy);
	}

	private void saveMarasmusInfo(String serialNo, Double marasmusCurrentWeight, Double marasmusHight, Double marasmusWeightBMI, Double marasmusWeightDown) {
		// TODO Auto-generated method stub
		TMarasmus tMarasmus = marasmusService.load("serialNo", serialNo);
		if(tMarasmus == null){
			tMarasmus = new TMarasmus();
			tMarasmus.setSerialNo(serialNo);
			tMarasmus.setCreateTime(DateUtil.getNowTimestamp());
		}
		tMarasmus.setNowWeight(marasmusCurrentWeight);
		tMarasmus.setHeight(marasmusHight);
		tMarasmus.setBmi(marasmusWeightBMI);
		tMarasmus.setWeightDownWthinHalfYear(marasmusWeightDown);
		logger.info(String.format("Marasmus info:[%f,%f,%f,%f]", marasmusCurrentWeight, marasmusHight, marasmusWeightBMI, marasmusWeightDown));
		marasmusService.saveOrUpdate(tMarasmus);
	}

	private void saveFatInfo(String serialNo, Double fatCurrentWeight, Double fatHight, Double fatWeightBMI) {
		// TODO Auto-generated method stub
		TFat tFat = fatService.load("serialNo", serialNo);
		if(tFat == null){
			tFat = new TFat();
			tFat.setSerialNo(serialNo);
			tFat.setCreateTime(DateUtil.getNowTimestamp());
		}
		tFat.setNowWeight(fatCurrentWeight);
		tFat.setHeight(fatHight);
		tFat.setBmi(fatWeightBMI);
		logger.info(String.format("Fat info:[%f,%f,%f]", fatCurrentWeight, fatHight, fatWeightBMI));
		fatService.saveOrUpdate(tFat);
	}

	private void saveHematocheziaInfo(String serialNo, Integer hematocheziaType) {
		// TODO Auto-generated method stub
		THematochezia tHematochezia = hematocheziaService.load("serialNo", serialNo);
		if(tHematochezia == null){
			tHematochezia = new THematochezia();
			tHematochezia.setSerialNo(serialNo);
			tHematochezia.setCreateTime(DateUtil.getNowTimestamp());
		}
		tHematochezia.setHematocheziaColor(hematocheziaType.shortValue());
		logger.info(String.format("hematochezia Color:%d", hematocheziaType));
		hematocheziaService.saveOrUpdate(tHematochezia);
	}

	private void saveAstrictionInfo(String serialNo, Integer astrictionType, Integer astrictionTimesOfWeekType) {
		// TODO Auto-generated method stub
		TAstriction tAstriction = astrictionService.load("serialNo", serialNo);
		if(tAstriction == null){
			tAstriction = new TAstriction();
			tAstriction.setSerialNo(serialNo);
			tAstriction.setCreateTime(DateUtil.getNowTimestamp());
		}
		tAstriction.setContinueTimeIsMoreThanHalfYear(astrictionType.shortValue());
		if(AstrictionTypeEnum.isContinueTimeMoreThanHalfYear(astrictionType)){
			tAstriction.setIsMoreThanThreeTime(astrictionTimesOfWeekType.shortValue());
		} else if(AstrictionTypeEnum.isContinueTimeLessThanHalfYear(astrictionType)){
			tAstriction.setIsMoreThanThreeTime(AstrictionTimesOfWeekTypeEnum.NotSelect.getValue().shortValue());
		}
		logger.info(String.format("astriction type:%d", astrictionType));
		logger.info(String.format("astrictionIsMoreThanThreeTime type:%d", astrictionTimesOfWeekType));
		astrictionService.saveOrUpdate(tAstriction);
	}

	private void saveDiarrheaInfo(String serialNo, Integer diarrheaType, String diarrheaContinueTime, Integer times) {
		// TODO Auto-generated method stub
		TDiarrhea tDiarrhea = diarrheaService.load("serialNo", serialNo);
		if(tDiarrhea == null){
			tDiarrhea = new TDiarrhea();
			tDiarrhea.setSerialNo(serialNo);
			tDiarrhea.setCreateTime(DateUtil.getNowTimestamp());
		}
		tDiarrhea.setDiarrheaType(diarrheaType.shortValue());
		//每日三次以上
		if(DiarrheaTypeEnum.isMoreThan3Times(diarrheaType)){
			tDiarrhea.setDiarrheaStartTime(new Timestamp(DateUtil.toDate(diarrheaContinueTime).getTime()));
			tDiarrhea.setDiarrheaContinusTime(DateUtil.daysOfTwo(DateUtil.toDate(diarrheaContinueTime), new Date()));
			logger.info(String.format("tDiarrhea start Time:%s", DateUtil.dateToString(tDiarrhea.getDiarrheaStartTime())));
			logger.info(String.format("tDiarrhea continues Time:%d", tDiarrhea.getDiarrheaContinusTime()));
			tDiarrhea.setEachDayTime(null);
		}else if(DiarrheaTypeEnum.isNotMoreThanTimes(diarrheaType)){
			tDiarrhea.setEachDayTime(times);
			logger.info(String.format("tDiarrhea times:%d", tDiarrhea.getEachDayTime()));
			tDiarrhea.setDiarrheaStartTime(null);
			tDiarrhea.setDiarrheaContinusTime(null);
		}
		logger.info(String.format("tDiarrhea type:%d", tDiarrhea.getDiarrheaType()));
		diarrheaService.saveOrUpdate(tDiarrhea);
	}

	private void saveVomitInfo(String serialNo, Integer vomit) {
		// TODO Auto-generated method stub
		TVomit tVomit = vomitService.load("serialNo", serialNo);
		if(tVomit == null){
			tVomit = new TVomit();
			tVomit.setSerialNo(serialNo);
			tVomit.setCreateTime(DateUtil.getNowTimestamp());
		}
		tVomit.setVomitType(vomit.shortValue());
		logger.info(String.format("vomit type:%s", tVomit.getVomitType().toString()));
		vomitService.saveOrUpdate(tVomit);
	}

	private void saveExpectorationInfo(String serialNo, Integer expectoration) {
		// TODO Auto-generated method stub
		TExpectoration tExpectoration = expectorationService.load("serialNo", serialNo);
		if(tExpectoration == null){
			tExpectoration = new TExpectoration();
			tExpectoration.setSerialNo(serialNo);
			tExpectoration.setCreateTime(DateUtil.getNowTimestamp());
		}
		tExpectoration.setExpectorationColor(expectoration.shortValue());
		logger.info(String.format("expectoration color:%s", tExpectoration.getExpectorationColor().toString()));
		expectorationService.saveOrUpdate(tExpectoration);
	}

	private void saveCoughStartTime(String serialNo, String coughStartTime) {
		// TODO Auto-generated method stub
		TCough cough = coughService.load("serialNo", serialNo);
		if(cough == null){
			cough = new TCough();
			cough.setSerialNo(serialNo);
			cough.setCreateTime(DateUtil.getNowTimestamp());
		}
		cough.setCoughStartTime(new Timestamp(DateUtil.toDate(coughStartTime).getTime()));
		logger.info(String.format("cough startTime:%s", DateUtil.dateToString(cough.getCoughStartTime())));
		coughService.saveOrUpdate(cough);
	}

	private void saveFeverDegree(String serialNo, Double hightDegree, Double lowDegree) {
		// TODO Auto-generated method stub
		TFever fever = feverService.load("serialNo", serialNo);
		if(fever == null){
			fever = new TFever();
			fever.setSerialNo(serialNo);
			fever.setCreateTime(DateUtil.getNowTimestamp());
		}
		fever.setHighestDegree(hightDegree);
		fever.setLowestDegree(lowDegree);
		logger.info(String.format("fever degree:[%f,%f]", lowDegree, hightDegree));
		feverService.saveOrUpdate(fever);
	}

	private void checkPresentIllnessReqBeanIsright(PresentIllnessReqBean bean) {
		// TODO Auto-generated method stub
		//检查体温是否合法
		feverDegreeCheck(bean.getHightDegree(), bean.getLowDegree());
		
		//检查腹泻次数
		diarrheaTimesCheck(bean.getTimes());
		
		//体重检查
		weightCheck(bean.getFatCurrentWeight(), "肥胖体重不能是负数");
		//身高检查
		heightCheck(bean.getFatHight(), "肥胖身高不能是负数");
		//检查BMI
		BMICheck(bean.getFatWeightBMI(), "肥胖BMI不能是负数");
		
		//体重检查
		weightCheck(bean.getMarasmusCurrentWeight(), "消瘦体重不能是负数");
		//身高检查
		heightCheck(bean.getMarasmusHight(), "消瘦身高不能是负数");
		//检查BMI
		BMICheck(bean.getMarasmusWeightBMI(), "消瘦BMI不能是负数");
		//检查减轻体重
		weightCheck(bean.getMarasmusWeightDown(), "减轻体重不能是负数");
		
		//尿量检查
		oliguresisUDPCheck(bean.getOliguresis(), "尿量不能是负数");
		//多尿尿量
		oliguresisUDPCheck(bean.getOtherUPDDiuresis(), "多尿尿量不能是负数");
		//少尿尿量
		oliguresisUDPCheck(bean.getOtherUPDAnuria(), "少尿尿量不能是负数");
	}

	private void oliguresisUDPCheck(Integer oliguresis,String noticeStr) {
		// TODO Auto-generated method stub
		if(oliguresis < 0){
			throw new BusinessException(noticeStr);
		}
	}

	private void BMICheck(Double weightBMI,String noticeStr) {
		// TODO Auto-generated method stub
		if(weightBMI < 0){
			throw new BusinessException(noticeStr);
		}
	}

	private void heightCheck(Double hight, String noticeStr) {
		// TODO Auto-generated method stub
		if(hight < 0){
			throw new BusinessException(noticeStr);
		}
	}

	private void weightCheck(Double weight, String noticeStr) {
		// TODO Auto-generated method stub
		if(weight < 0){
			throw new BusinessException(noticeStr);
		}
	}

	private void diarrheaTimesCheck(Integer times) {
		// TODO Auto-generated method stub
		if(times < 0){
			throw new BusinessException("腹泻次数不能少于零次");
		}
	}

	private void feverDegreeCheck(Double hightDegree, Double lowDegree) {
		// TODO Auto-generated method stub
		if(hightDegree == null){
			throw new BusinessException("最高体温请输入数字");
		}
		if(hightDegree != 0){
			if(hightDegree < 35 || hightDegree > 45){
				throw new BusinessException("体温不能小于35℃或大于45℃");
			}
		}
		
		if(lowDegree == null){
			throw new BusinessException("最低体温请输入数字");
		}
		if(lowDegree != 0){
			if(lowDegree < 35 || lowDegree > 45){
				throw new BusinessException("体温不能小于35℃或大于45℃");
			}
		}
	}

	@Override
	public void getPresentIllness(String serialNo, ServiceResult result, Long accountId) {
		PresentIllnessRespBean bean = new PresentIllnessRespBean();
		bean.setSerialNo(serialNo);
		boolean isEmpty = true;
		//保存发烧体温；
		TFever fever = feverService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != fever){
			bean.setFever(fever);
			isEmpty = false;
		}
		//保存咳嗽信息
		TCough cough = coughService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != cough){
			bean.setCough(cough);
			isEmpty = false;
		}
		//保存咳痰信息
		TExpectoration tExpectoration = expectorationService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tExpectoration){
			bean.settExpectoration(tExpectoration);
			isEmpty = false;
		}
		//保存呕吐信息
		TVomit tVomit = vomitService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tVomit){
			bean.settVomit(tVomit);
			isEmpty = false;
		}
		//保存腹泻信息
		TDiarrhea tDiarrhea = diarrheaService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tDiarrhea){
			bean.settDiarrhea(tDiarrhea);
			isEmpty = false;
		}
		//保存便秘信息
		TAstriction tAstriction = astrictionService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tAstriction){
			bean.settAstriction(tAstriction);
			isEmpty = false;
		}
		//保存便血信息
		THematochezia tHematochezia = hematocheziaService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tHematochezia){
			bean.settHematochezia(tHematochezia);
			isEmpty = false;
		}
		//保存肥胖信息
		TFat tFat = fatService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tFat){
			bean.settFat(tFat);
			isEmpty = false;
		}
		//保存消瘦信息
		TMarasmus tMarasmus = marasmusService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tMarasmus){
			bean.settMarasmus(tMarasmus);
			isEmpty = false;
		}
		//保存头晕信息
		TDizzy tDizzy = dizzyService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tDizzy){
			bean.settDizzy(tDizzy);
			isEmpty = false;
		}
		//保存皮肤出现异常信息
		TAbnormalskin tAbnormalskin = abnormalSkinService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tAbnormalskin){
			bean.settAbnormalskin(tAbnormalskin);
			isEmpty = false;
		}
		//保存少尿信息
		TOliguresis tOliguresis = oliguresisService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tOliguresis){
			bean.settOliguresis(tOliguresis);
			isEmpty = false;
		}
		//其他尿量相关症状
		TOtherUpdSymptom tOtherUpdSymptom = otherUPDSymptomService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tOtherUpdSymptom){
			bean.settOtherUpdSymptom(tOtherUpdSymptom);
			isEmpty = false;
		}
		//排尿相关症状
		TMicturition tMicturition = micturitionService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tMicturition){
			bean.settMicturition(tMicturition);
			isEmpty = false;
		}
		//疼痛
		TPain tPain = painService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tPain){
			bean.settPain(tPain);
			isEmpty = false;
		}
		//呕血
		THaematemesis tHaematemesis = tHaematemesisService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tHaematemesis){
			bean.settHaematemesis(tHaematemesis);
			isEmpty = false;
		}
		//咯血
		THemoptysis  tHemoptysis = tHemoptysisService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tHemoptysis){
			bean.settHemoptysis(tHemoptysis);
			isEmpty = false;
		}
		//呼吸困难
		TDyspnea  tDyspnea = tDyspneaService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tDyspnea){
			bean.settDyspnea(tDyspnea);
			isEmpty = false;
		}
		//心悸
		TPalpitation  tPalpitation = tPalpitationService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tPalpitation){
			bean.settPalpitation(tPalpitation);
			isEmpty = false;
		}
		//水肿
		TEdema  tEdema  = tEdemaService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tEdema){
			bean.settEdema(tEdema);
			isEmpty = false;
		}
		//抽搐与惊厥
		TTicAndConvulsion tTicAndConvulsion = tTicAndConvulsionService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tTicAndConvulsion){
			bean.setTicAndConvulsion(tTicAndConvulsion);
			isEmpty = false;
		}
		//意识障碍
		TConsciousnessDisorder tConsciousnessDisorder = tConsciousnessDisorderService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tConsciousnessDisorder){
			bean.settConsciousnessDisorder(tConsciousnessDisorder);
			isEmpty = false;
		}
		//情感症状
		TAffectiveSymptoms  tAffectiveSymptoms = tAffectiveSymptomsService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tAffectiveSymptoms){
			bean.settAffectiveSymptoms(tAffectiveSymptoms);
			isEmpty = false;
		}
		//以上都不是
		TNotAllAbove  tNotAllAbove = tNotAllAboveService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tNotAllAbove){
			bean.settNotAllAbove(tNotAllAbove);
			isEmpty = false;
		}
	
		if(!isEmpty){
			result.addData("presentIllnessModel", bean);
			result.setIsSuccess(true);
			result.setMessage("获取成功");
		}else{
			result.setIsSuccess(false);
			result.setMessage("获取失败");
		}
	}

	@Override
	public void deletePresentIllnessBySerialNo(String serialNo, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		//删除发烧体温；
		TFever fever = feverService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		boolean isDelete = false;
		if(null != fever){
			feverService.delete(fever);
			isDelete = true;
		}
		//删除咳嗽信息
		TCough cough = coughService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != cough){
			coughService.delete(cough);
			isDelete = true;
		}
		//删除咳痰信息
		TExpectoration tExpectoration = expectorationService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tExpectoration){
			expectorationService.delete(tExpectoration);
			isDelete = true;
		}
		//删除呕吐信息
		TVomit tVomit = vomitService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tVomit){
			vomitService.delete(tVomit);
			isDelete = true;
		}
		//删除腹泻信息
		TDiarrhea tDiarrhea = diarrheaService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tDiarrhea){
			diarrheaService.delete(tDiarrhea);
			isDelete = true;
		}
		//删除便秘信息
		TAstriction tAstriction = astrictionService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tAstriction){
			astrictionService.delete(tAstriction);
			isDelete = true;
		}
		//删除便血信息
		THematochezia tHematochezia = hematocheziaService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tHematochezia){
			hematocheziaService.delete(tHematochezia);
			isDelete = true;
		}
		//删除肥胖信息
		TFat tFat = fatService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tFat){
			fatService.delete(tFat);
			isDelete = true;
		}
		//删除消瘦信息
		TMarasmus tMarasmus = marasmusService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tMarasmus){
			marasmusService.delete(tMarasmus);
			isDelete = true;
		}
		//删除头晕信息
		TDizzy tDizzy = dizzyService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tDizzy){
			dizzyService.delete(tDizzy);
			isDelete = true;
		}
		//删除皮肤出现异常信息
		TAbnormalskin tAbnormalskin = abnormalSkinService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tAbnormalskin){
			abnormalSkinService.delete(tAbnormalskin);
			isDelete = true;
		}
		//删除少尿信息
		TOliguresis tOliguresis = oliguresisService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tOliguresis){
			oliguresisService.delete(tOliguresis);
			isDelete = true;
		}
		//其他尿量相关症状
		TOtherUpdSymptom tOtherUpdSymptom = otherUPDSymptomService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tOtherUpdSymptom){
			otherUPDSymptomService.delete(tOtherUpdSymptom);
			isDelete = true;
		}
		//排尿相关症状
		TMicturition tMicturition = micturitionService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tMicturition){
			micturitionService.delete(tMicturition);
			isDelete = true;
		}
		//疼痛
		TPain tPain = painService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tPain){
			painService.delete(tPain);
			isDelete = true;
		}
		//呕血
		THaematemesis tHaematemesis = tHaematemesisService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tHaematemesis){
			tHaematemesisService.delete(tHaematemesis);
			isDelete = true;
		}
		//咯血
		THemoptysis  tHemoptysis = tHemoptysisService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tHemoptysis){
			tHemoptysisService.delete(tHemoptysis);
			isDelete = true;
		}
		//呼吸困难
		TDyspnea  tDyspnea = tDyspneaService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tDyspnea){
			tDyspneaService.delete(tDyspnea);
			isDelete = true;
		}
		//心悸
		TPalpitation  tPalpitation = tPalpitationService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tPalpitation){
			tPalpitationService.delete(tPalpitation);
			isDelete = true;
		}
		//水肿
		TEdema  tEdema  = tEdemaService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tEdema){
			tEdemaService.delete(tEdema);
			isDelete = true;
		}
		//抽搐与惊厥
		TTicAndConvulsion tTicAndConvulsion = tTicAndConvulsionService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tTicAndConvulsion){
			tTicAndConvulsionService.delete(tTicAndConvulsion);
			isDelete = true;
		}
		//意识障碍
		TConsciousnessDisorder tConsciousnessDisorder = tConsciousnessDisorderService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tConsciousnessDisorder){
			tConsciousnessDisorderService.delete(tConsciousnessDisorder);
			isDelete = true;
		}
		//情感症状
		TAffectiveSymptoms  tAffectiveSymptoms = tAffectiveSymptomsService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tAffectiveSymptoms){
			tAffectiveSymptomsService.delete(tAffectiveSymptoms);
			isDelete = true;
		}
		//以上都不是
		TNotAllAbove  tNotAllAbove = tNotAllAboveService.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null != tNotAllAbove){
			tNotAllAboveService.delete(tNotAllAbove);
			isDelete = true;
		}
		
		if(isDelete){
			result.setIsSuccess(true);
			result.setMessage("删除成功");
		}
	}

}
