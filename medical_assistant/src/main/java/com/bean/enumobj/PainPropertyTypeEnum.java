package com.bean.enumobj;

/**
 * 疼痛性质类型枚举
 * @author qinmp
 *
 */
public enum PainPropertyTypeEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//痉挛性疼痛
	Spasmodicain(1, "痉挛性疼痛"),
	//可以忍受的隐痛
	CanEndurePain(2, "可以忍受的隐痛");

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
    
	public static PainPropertyTypeEnum convertByValue(Integer value){
        for (PainPropertyTypeEnum caseStatus:PainPropertyTypeEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return PainPropertyTypeEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isSpasmodicain(Integer value){
		return PainPropertyTypeEnum.Spasmodicain.getValue().equals(value);
	}
	public static boolean isCanEndurePain(Integer value){
		return PainPropertyTypeEnum.CanEndurePain.getValue().equals(value);
	}
    private PainPropertyTypeEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
