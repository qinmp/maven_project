package com.bean.enumobj;

/**
 * 其他尿量相关症状类型
 * @author qinmp
 *
 */
public enum OtherUDPSymtomTypeEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//尿频尿急尿痛
	FrequentMicturition(1, "尿频尿急尿痛"),
	//多尿
	Diuresis(2, "多尿"),
	//无尿
	NoUrine(3, "无尿");
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
    
	public static OtherUDPSymtomTypeEnum convertByValue(Integer value){
        for (OtherUDPSymtomTypeEnum caseStatus:OtherUDPSymtomTypeEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return OtherUDPSymtomTypeEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isFrequentMicturition(Integer value){
		return OtherUDPSymtomTypeEnum.FrequentMicturition.getValue().equals(value);
	}
	public static boolean isDiuresis(Integer value){
		return OtherUDPSymtomTypeEnum.Diuresis.getValue().equals(value);
	}
	public static boolean isNoUrine(Integer value){
		return OtherUDPSymtomTypeEnum.NoUrine.getValue().equals(value);
	}
    private OtherUDPSymtomTypeEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
