package com.bean.enumobj;


public enum SmokingTypeEnum {

	/** 未选择 */
	NOTSELECT(0,"未选择 "),
	
	/** 从来不吸烟 */
	NEVERSMOKING(1,"从来不吸烟"),
   	/** 已经戒烟 */
	HASNOTSMOKING(2,"已经戒烟"),
	/** 仍然在吸烟 */
	STILLSMOKING(3,"仍然在吸烟");
	
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

	/**
	 * <b>概要：</b>
	 * 	根据属性值匹配属性
	 * <b>作者：</b>SUXH </br>
	 * <b>日期：</b>2015-3-17 </br>
	 * @param value 需要匹配的属性值
	 * @return
	 */
	public static SmokingTypeEnum convertByValue(Integer value){
        for (SmokingTypeEnum caseStatus:SmokingTypeEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	private SmokingTypeEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}

	public static boolean isNotSelect(Integer value){
		return SmokingTypeEnum.NOTSELECT.getValue().equals(value);
	}
	public static boolean isHasNotSmoking(Integer value){
		return SmokingTypeEnum.HASNOTSMOKING.getValue().equals(value);
	}
	public static boolean isStillSmoking(Integer value){
		return SmokingTypeEnum.STILLSMOKING.getValue().equals(value);
	}
	public static boolean isNeverSmoking(Integer value){
		return SmokingTypeEnum.NEVERSMOKING.getValue().equals(value);
	}
}

