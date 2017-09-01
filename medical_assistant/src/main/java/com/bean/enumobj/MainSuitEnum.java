package com.bean.enumobj;

public enum MainSuitEnum {
	
	FERVER(0, "发热"),
	COUGH(1,"咳嗽"),
	EXPECTORATION(3, "咳痰"),
	VOMIT(4, "呕吐"),
	DIARRHEA(5,"腹泻"),
	ASTRICTION(6, "便秘"),
	HEMATOCHEZIA(7, "便血"),
	FAT(8,"肥胖"),
	EMACIATION(9, "消瘦"),
	SWIRL(10, "头晕"),
	SKIN_ABNORMAL(11,"皮肤出现异常"),
	OLIGURIA(12, "少尿"),
	OTHER_SYMPTOMS_OF_URINE(13, "其他尿量相关症状"),
	VOIDING_SYMPTOMS(14,"排尿相关症状"),
	ACHE(15, "疼痛"),
	HAEMATEMESIS(16, "呕血"),
	HEMOPTYSIS(17,"咯血"),
	DYSPNEA(18, "呼吸困难"),
	PALPITATION(19, "心悸"),
	EDEMA(20,"水肿"),
	TICAND_CONVULSIONS(21, "抽搐与惊厥"),
	DISTURBANCE_OF_CONSCIOUSNESS(22, "意识障碍"),
	EMOTIONAL_SYMPTOMS(23,"情感症状"),
	NONE_OF_THE_ABOVE(24, "以上都不是");
	
	private Integer value;
	private String content;
	
	private MainSuitEnum(Integer _value, String _content){
		this.value = _value;
		this.content = _content;
	}
	
	public Integer getValue(){
		return this.value;
	}
	
	public String getContent(){
		return this.content;
	}
	
	/**
	 * <b>概要：</b>
	 * 	根据属性值匹配属性
	 * <b>作者：</b>SUXH </br>
	 * <b>日期：</b>2015-3-17 </br>
	 * @param value 需要匹配的属性值
	 * @return
	 */
	public static MainSuitEnum convertByValue(Integer value){
        for (MainSuitEnum mainSuit:MainSuitEnum.values()) {  
            if (mainSuit.getValue() == value) {  
                return mainSuit;  
            }  
        }  
        return null;  
	}
	
	boolean isFever(Integer value){
		return FERVER.getValue().equals(value);
	}
	boolean isCough(Integer value){
		return COUGH.getValue().equals(value);
	}
	boolean isExpectoration(Integer value){
		return EXPECTORATION.getValue().equals(value);
	}
	boolean isVomit(Integer value){
		return VOMIT.getValue().equals(value);
	}
	boolean isDiarrhea(Integer value){
		return DIARRHEA.getValue().equals(value);
	}
	boolean isAstriction(Integer value){
		return ASTRICTION.getValue().equals(value);
	}
	boolean isHematochezia(Integer value){
		return HEMATOCHEZIA.getValue().equals(value);
	}
	boolean isFat(Integer value){
		return FAT.getValue().equals(value);
	}
	boolean isEmaciation(Integer value){
		return EMACIATION.getValue().equals(value);
	}
	boolean isSwirl(Integer value){
		return SWIRL.getValue().equals(value);
	}
	boolean isSkin_abnormal(Integer value){
		return SKIN_ABNORMAL.getValue().equals(value);
	}
	boolean isOliguria(Integer value){
		return OLIGURIA.getValue().equals(value);
	}
	boolean isOther_symptoms_of_urine(Integer value){
		return OTHER_SYMPTOMS_OF_URINE.getValue().equals(value);
	}
	boolean isVoiding_symptoms(Integer value){
		return VOIDING_SYMPTOMS.getValue().equals(value);
	}
	boolean isAche(Integer value){
		return ACHE.getValue().equals(value);
	}
	boolean isHaematemesis(Integer value){
		return HAEMATEMESIS.getValue().equals(value);
	}
	boolean isHemoptysis(Integer value){
		return HEMOPTYSIS.getValue().equals(value);
	}
	boolean isDyspnea(Integer value){
		return DYSPNEA.getValue().equals(value);
	}
	boolean isPalpitation(Integer value){
		return PALPITATION.getValue().equals(value);
	}
	boolean isEdema(Integer value){
		return EDEMA.getValue().equals(value);
	}
	boolean isTicand_convulsions(Integer value){
		return TICAND_CONVULSIONS.getValue().equals(value);
	}
	boolean isDisturbance_of_consciousness(Integer value){
		return DISTURBANCE_OF_CONSCIOUSNESS.getValue().equals(value);
	}
	boolean isEmotional_symptoms(Integer value){
		return EMOTIONAL_SYMPTOMS.getValue().equals(value);
	}
	boolean isNone_of_the_above(Integer value){
		return NONE_OF_THE_ABOVE.getValue().equals(value);
	}
	
}
