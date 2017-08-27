package com.bean.enumobj;

/**
 * 头晕类型枚举
 * @author qinmp
 *
 */
public enum DizzyTypeEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//晕车/船后呕吐
	CarsicknessOrShipsickness(1, "晕车/船后"),
	//晕厥
	Syncope(2, "晕厥"),
	//眩晕
	Vertigo(3, "眩晕");

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
    
	public static DizzyTypeEnum convertByValue(Integer value){
        for (DizzyTypeEnum caseStatus:DizzyTypeEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return DizzyTypeEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isCarsicknessOrShipsickness(Integer value){
		return DizzyTypeEnum.CarsicknessOrShipsickness.getValue().equals(value);
	}
	public static boolean isSyncope(Integer value){
		return DizzyTypeEnum.Syncope.getValue().equals(value);
	}
	public static boolean isVertigo(Integer value){
		return DizzyTypeEnum.Vertigo.getValue().equals(value);
	}
    private DizzyTypeEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
