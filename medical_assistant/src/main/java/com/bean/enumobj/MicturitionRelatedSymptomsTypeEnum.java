package com.bean.enumobj;

/**
 * 排尿相关症状
 * @author qinmp
 *
 */
public enum MicturitionRelatedSymptomsTypeEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//尿失禁
	UrinaryIncontinence(1, "尿失禁"),
	//尿失禁
	Dysuria(2, "尿失禁");

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
    
	public static MicturitionRelatedSymptomsTypeEnum convertByValue(Integer value){
        for (MicturitionRelatedSymptomsTypeEnum caseStatus:MicturitionRelatedSymptomsTypeEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return MicturitionRelatedSymptomsTypeEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isUrinaryIncontinence(Integer value){
		return MicturitionRelatedSymptomsTypeEnum.UrinaryIncontinence.getValue().equals(value);
	}
	public static boolean isDysuria(Integer value){
		return MicturitionRelatedSymptomsTypeEnum.Dysuria.getValue().equals(value);
	}
    private MicturitionRelatedSymptomsTypeEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
