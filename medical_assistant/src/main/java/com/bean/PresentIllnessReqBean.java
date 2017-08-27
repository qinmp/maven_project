package com.bean;

public class PresentIllnessReqBean {
	
	//序列号
	private String serialNo;
	
	//发烧最高/低温度
	private Double hightDegree;
	private Double lowDegree;
	
	//咳嗽开始时间
	private String coughStartTime;
	
	//咳痰
	private Integer expectoration;
	
	//呕吐
	private Integer vomit;
	
	//腹泻 类型
	private Integer diarrheaType;
	//腹泻持续时间
	private String diarrheaContinueTime;
	//每天三次以下，一天几次
	private Integer times;
	
	//便秘类型
	private Integer astrictionType;
	//便秘每周次数类型
	private Integer astrictionTimesOfWeekType;
	
	//便血颜色
	private Integer hematocheziaType;
	
	//体重，当前体重
	private Double fatCurrentWeight;
	//身高
	private Double fatHight;
	//体重BMI
	private Double fatWeightBMI;
	
	//消瘦，当前体重
	private Double marasmusCurrentWeight;
	//身高
	private Double marasmusHight;
	//体重BMI
	private Double marasmusWeightBMI;
	//半年内体重减轻多少千克
	private Double marasmusWeightDown;
	
	//头晕
	private Integer dizzyType;
	
	//皮肤出现异常类型
	private Integer abnormalSkinType;
	//皮肤出现异常, 四肢躯干皮肤异常类型
	private Integer limbsTrunkAbnormalSkinType;
	//其他皮肤异常
	private String otherAbnormalSkin;
	
	//少尿
	private Integer oliguresis;
	
	//其他尿量症状类型
	private Integer otherUPDSymptomType;
	//多尿尿量
	private Integer otherUPDDiuresis;
	//少尿尿量
	private Integer otherUPDAnuria;
	
	//排尿相关症状类型
	private Integer micturitionRelatedSymptomsType;
	
	//疼痛类型
	private Integer painType;
	//腹痛开始时间
	private String painContinueTime;
	//持续性还是间歇性类型
	private Integer continuousOrIntermittentType;
	//与进食关系如何类型
	private Integer relationshipBetweenEatingAndEatingType;
	//疼痛性质类型
	private Integer painPropertyType;
	
	//呕血
	private Integer haematemesis = 0;
	//咯血
	private Integer hemoptysis = 0;
	//呼吸困难
	private Integer dyspnea = 0;
	//心悸
	private Integer palpitation = 0;
	//水肿
	private Integer edema = 0;
	//抽搐与惊厥
	private Integer ticAndConvulsion = 0;
	//意识障碍
	private Integer consciousnessDisorder = 0;
	//情感症状
	private Integer affectiveSymptoms = 0;
	//以上都不是
	private Integer notAllAbove = 0;
	private String other_problem;
	
	public Integer getHaematemesis() {
		return haematemesis;
	}
	public void setHaematemesis(Integer haematemesis) {
		this.haematemesis = haematemesis;
	}
	public Integer getHemoptysis() {
		return hemoptysis;
	}
	public void setHemoptysis(Integer hemoptysis) {
		this.hemoptysis = hemoptysis;
	}
	public Integer getDyspnea() {
		return dyspnea;
	}
	public void setDyspnea(Integer dyspnea) {
		this.dyspnea = dyspnea;
	}
	public Integer getPalpitation() {
		return palpitation;
	}
	public void setPalpitation(Integer palpitation) {
		this.palpitation = palpitation;
	}
	public Integer getEdema() {
		return edema;
	}
	public void setEdema(Integer edema) {
		this.edema = edema;
	}
	public Integer getTicAndConvulsion() {
		return ticAndConvulsion;
	}
	public void setTicAndConvulsion(Integer ticAndConvulsion) {
		this.ticAndConvulsion = ticAndConvulsion;
	}
	public Integer getConsciousnessDisorder() {
		return consciousnessDisorder;
	}
	public void setConsciousnessDisorder(Integer consciousnessDisorder) {
		this.consciousnessDisorder = consciousnessDisorder;
	}
	public Integer getAffectiveSymptoms() {
		return affectiveSymptoms;
	}
	public void setAffectiveSymptoms(Integer affectiveSymptoms) {
		this.affectiveSymptoms = affectiveSymptoms;
	}
	public Integer getNotAllAbove() {
		return notAllAbove;
	}
	public void setNotAllAbove(Integer notAllAbove) {
		this.notAllAbove = notAllAbove;
	}
	public String getOther_problem() {
		return other_problem;
	}
	public void setOther_problem(String other_problem) {
		this.other_problem = other_problem;
	}
	public Double getHightDegree() {
		return hightDegree;
	}
	public void setHightDegree(Double hightDegree) {
		this.hightDegree = hightDegree;
	}
	
	public Double getLowDegree() {
		return lowDegree;
	}
	public void setLowDegree(Double lowDegree) {
		this.lowDegree = lowDegree;
	}
	public String getCoughStartTime() {
		return coughStartTime;
	}
	public void setCoughStartTime(String coughStartTime) {
		this.coughStartTime = coughStartTime;
	}
	public Integer getExpectoration() {
		return expectoration;
	}
	public void setExpectoration(Integer expectoration) {
		this.expectoration = expectoration;
	}
	public Integer getVomit() {
		return vomit;
	}
	public void setVomit(Integer vomit) {
		this.vomit = vomit;
	}
	public Integer getDiarrheaType() {
		return diarrheaType;
	}
	public void setDiarrheaType(Integer diarrheaType) {
		this.diarrheaType = diarrheaType;
	}
	public String getDiarrheaContinueTime() {
		return diarrheaContinueTime;
	}
	public void setDiarrheaContinueTime(String diarrheaContinueTime) {
		this.diarrheaContinueTime = diarrheaContinueTime;
	}
	public Integer getTimes() {
		return times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	public Integer getAstrictionType() {
		return astrictionType;
	}
	public void setAstrictionType(Integer astrictionType) {
		this.astrictionType = astrictionType;
	}
	public Integer getAstrictionTimesOfWeekType() {
		return astrictionTimesOfWeekType;
	}
	public void setAstrictionTimesOfWeekType(Integer astrictionTimesOfWeekType) {
		this.astrictionTimesOfWeekType = astrictionTimesOfWeekType;
	}
	public Integer getHematocheziaType() {
		return hematocheziaType;
	}
	public void setHematocheziaType(Integer hematocheziaType) {
		this.hematocheziaType = hematocheziaType;
	}
	public Double getFatCurrentWeight() {
		return fatCurrentWeight;
	}
	public void setFatCurrentWeight(Double fatCurrentWeight) {
		this.fatCurrentWeight = fatCurrentWeight;
	}
	public Double getFatHight() {
		return fatHight;
	}
	public void setFatHight(Double fatHight) {
		this.fatHight = fatHight;
	}
	public Double getFatWeightBMI() {
		return fatWeightBMI;
	}
	public void setFatWeightBMI(Double fatWeightBMI) {
		this.fatWeightBMI = fatWeightBMI;
	}
	public Double getMarasmusCurrentWeight() {
		return marasmusCurrentWeight;
	}
	public void setMarasmusCurrentWeight(Double marasmusCurrentWeight) {
		this.marasmusCurrentWeight = marasmusCurrentWeight;
	}
	public Double getMarasmusHight() {
		return marasmusHight;
	}
	public void setMarasmusHight(Double marasmusHight) {
		this.marasmusHight = marasmusHight;
	}
	public Double getMarasmusWeightBMI() {
		return marasmusWeightBMI;
	}
	public void setMarasmusWeightBMI(Double marasmusWeightBMI) {
		this.marasmusWeightBMI = marasmusWeightBMI;
	}
	public Double getMarasmusWeightDown() {
		return marasmusWeightDown;
	}
	public void setMarasmusWeightDown(Double marasmusWeightDown) {
		this.marasmusWeightDown = marasmusWeightDown;
	}
	public Integer getDizzyType() {
		return dizzyType;
	}
	public void setDizzyType(Integer dizzyType) {
		this.dizzyType = dizzyType;
	}
	public Integer getAbnormalSkinType() {
		return abnormalSkinType;
	}
	public void setAbnormalSkinType(Integer abnormalSkinType) {
		this.abnormalSkinType = abnormalSkinType;
	}
	public Integer getLimbsTrunkAbnormalSkinType() {
		return limbsTrunkAbnormalSkinType;
	}
	public void setLimbsTrunkAbnormalSkinType(Integer limbsTrunkAbnormalSkinType) {
		this.limbsTrunkAbnormalSkinType = limbsTrunkAbnormalSkinType;
	}
	public String getOtherAbnormalSkin() {
		return otherAbnormalSkin;
	}
	public void setOtherAbnormalSkin(String otherAbnormalSkin) {
		this.otherAbnormalSkin = otherAbnormalSkin;
	}
	public Integer getOliguresis() {
		return oliguresis;
	}
	public void setOliguresis(Integer oliguresis) {
		this.oliguresis = oliguresis;
	}
	public Integer getOtherUPDSymptomType() {
		return otherUPDSymptomType;
	}
	public void setOtherUPDSymptomType(Integer otherUPDSymptomType) {
		this.otherUPDSymptomType = otherUPDSymptomType;
	}
	public Integer getOtherUPDDiuresis() {
		return otherUPDDiuresis;
	}
	public void setOtherUPDDiuresis(Integer otherUPDDiuresis) {
		this.otherUPDDiuresis = otherUPDDiuresis;
	}
	public Integer getOtherUPDAnuria() {
		return otherUPDAnuria;
	}
	public void setOtherUPDAnuria(Integer otherUPDAnuria) {
		this.otherUPDAnuria = otherUPDAnuria;
	}
	public Integer getMicturitionRelatedSymptomsType() {
		return micturitionRelatedSymptomsType;
	}
	public void setMicturitionRelatedSymptomsType(Integer micturitionRelatedSymptomsType) {
		this.micturitionRelatedSymptomsType = micturitionRelatedSymptomsType;
	}
	public Integer getPainType() {
		return painType;
	}
	public void setPainType(Integer painType) {
		this.painType = painType;
	}
	public String getPainContinueTime() {
		return painContinueTime;
	}
	public void setPainContinueTime(String painContinueTime) {
		this.painContinueTime = painContinueTime;
	}
	public Integer getContinuousOrIntermittentType() {
		return continuousOrIntermittentType;
	}
	public void setContinuousOrIntermittentType(Integer continuousOrIntermittentType) {
		this.continuousOrIntermittentType = continuousOrIntermittentType;
	}
	public Integer getRelationshipBetweenEatingAndEatingType() {
		return relationshipBetweenEatingAndEatingType;
	}
	public void setRelationshipBetweenEatingAndEatingType(Integer relationshipBetweenEatingAndEatingType) {
		this.relationshipBetweenEatingAndEatingType = relationshipBetweenEatingAndEatingType;
	}
	public Integer getPainPropertyType() {
		return painPropertyType;
	}
	public void setPainPropertyType(Integer painPropertyType) {
		this.painPropertyType = painPropertyType;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
}
