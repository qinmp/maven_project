package com.bean.enumobj;

/**
 * 持续性还是间歇性类型枚举
 * @author qinmp
 *
 */
public enum ContinuousOrIntermittentTypeEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//持续性
	Continuous(1, "持续性"),
	//间歇性
	Intermittent(2, "间歇性");

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
    
	public static ContinuousOrIntermittentTypeEnum convertByValue(Integer value){
        for (ContinuousOrIntermittentTypeEnum caseStatus:ContinuousOrIntermittentTypeEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return ContinuousOrIntermittentTypeEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isContinuous(Integer value){
		return ContinuousOrIntermittentTypeEnum.Continuous.getValue().equals(value);
	}
	public static boolean isIntermittent(Integer value){
		return ContinuousOrIntermittentTypeEnum.Intermittent.getValue().equals(value);
	}
    private ContinuousOrIntermittentTypeEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
