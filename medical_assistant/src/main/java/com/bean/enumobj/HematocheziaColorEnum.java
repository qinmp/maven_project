package com.bean.enumobj;

/**
 * 便血颜色枚举
 * @author qinmp
 *
 */
public enum HematocheziaColorEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//持续时间未达到半年
	DullRed(1, "暗红色"),
	//持续时间达到半年(含)
	BrightRed(2, "鲜红色");

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
    
	public static HematocheziaColorEnum convertByValue(Integer value){
        for (HematocheziaColorEnum caseStatus:HematocheziaColorEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return HematocheziaColorEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isDullRed(Integer value){
		return HematocheziaColorEnum.DullRed.getValue().equals(value);
	}
	public static boolean isBrightRed(Integer value){
		return HematocheziaColorEnum.BrightRed.getValue().equals(value);
	}
    private HematocheziaColorEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
