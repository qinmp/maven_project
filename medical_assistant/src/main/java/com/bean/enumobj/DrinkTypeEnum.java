package com.bean.enumobj;


public enum DrinkTypeEnum {

	/** 未选择 */
	NOTSELECT(0,"未选择 "),
	
	/** 从来不吸烟 */
	NEVERDRINK(1,"从来不喝酒"),
   	/** 已经戒烟 */
	HASNOTDRINK(2,"已经戒酒"),
	/** 仍然在吸烟 */
	STILLDRINK(3,"仍然在喝酒");
	
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
	public static DrinkTypeEnum convertByValue(Integer value){
        for (DrinkTypeEnum caseStatus:DrinkTypeEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	private DrinkTypeEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}

	public static boolean isNotSelect(Integer value){
		return DrinkTypeEnum.NOTSELECT.getValue().equals(value);
	}
	public static boolean isHasNotDrink(Integer value){
		return DrinkTypeEnum.HASNOTDRINK.getValue().equals(value);
	}
	public static boolean isStillDrink(Integer value){
		return DrinkTypeEnum.STILLDRINK.getValue().equals(value);
	}
	public static boolean isNeverDrink(Integer value){
		return DrinkTypeEnum.NEVERDRINK.getValue().equals(value);
	}
}

