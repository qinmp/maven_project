package com.bean.enumobj;

/**
 * 便秘每周次数类型
 * @author qinmp
 *
 */
public enum AstrictionTimesOfWeekTypeEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//排便次数每周少于3次
	AstrictionTimesOfWeekLessThanThreeTimes(1, "排便次数每周少于3次"),
	//排便次数每周达到3次
	AstrictionTimesOfWeekMoreThanThreeTimes(2, "排便次数每周达到3次");

	/** 字段值 */
    private Integer value;
    
    /** 字段值的实际意义 */
    private String valueInFact;
    
	public Integer getValue(){
		return this.value;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public String getValueInFact() {
		return valueInFact;
	}

	public void setValueInFact(String valueInFact) {
		this.valueInFact = valueInFact;
	}
    
	public static AstrictionTimesOfWeekTypeEnum convertByValue(Integer value){
        for (AstrictionTimesOfWeekTypeEnum caseStatus:AstrictionTimesOfWeekTypeEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return AstrictionTimesOfWeekTypeEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isAstrictionTimesOfWeekLessThanThreeTimes(Integer value){
		return AstrictionTimesOfWeekTypeEnum.AstrictionTimesOfWeekLessThanThreeTimes.getValue().equals(value);
	}
	public static boolean isAstrictionTimesOfWeekMoreThanThreeTimes(Integer value){
		return AstrictionTimesOfWeekTypeEnum.AstrictionTimesOfWeekMoreThanThreeTimes.getValue().equals(value);
	}
    private AstrictionTimesOfWeekTypeEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
