package com.bean.enumobj;

/**
 * 呕吐类型枚举
 * @author qinmp
 *
 */
public enum VomitEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//晕车/船后呕吐
	AfterCarsickOrSeasickVomit(1, "晕车/船后呕吐"),
	//其他类型呕吐
	OtherTypeVomit(2, "其他类型呕吐");

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
    
	public static VomitEnum convertByValue(Integer value){
        for (VomitEnum caseStatus:VomitEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return VomitEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isAfterCarsickOrSeasickVomit(Integer value){
		return VomitEnum.AfterCarsickOrSeasickVomit.getValue().equals(value);
	}
	public static boolean isOtherTypeVomit(Integer value){
		return VomitEnum.OtherTypeVomit.getValue().equals(value);
	}
    private VomitEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
