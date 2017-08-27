package com.bean.enumobj;

/**
 * 便秘类型
 * @author qinmp
 *
 */
public enum AstrictionTypeEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//持续时间未达到半年
	ContinueTimeLessThanHalfYear(1, "持续时间未达到半年"),
	//持续时间达到半年(含)
	ContinueTimeMoreThanHalfYear(2, "持续时间达到半年(含)");

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
    
	public static AstrictionTypeEnum convertByValue(Integer value){
        for (AstrictionTypeEnum caseStatus:AstrictionTypeEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return AstrictionTypeEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isContinueTimeLessThanHalfYear(Integer value){
		return AstrictionTypeEnum.ContinueTimeLessThanHalfYear.getValue().equals(value);
	}
	public static boolean isContinueTimeMoreThanHalfYear(Integer value){
		return AstrictionTypeEnum.ContinueTimeMoreThanHalfYear.getValue().equals(value);
	}
    private AstrictionTypeEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
