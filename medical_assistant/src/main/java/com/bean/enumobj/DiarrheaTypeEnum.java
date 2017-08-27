package com.bean.enumobj;

/**
 * 腹泻
 * @author qinmp
 *
 */
public enum DiarrheaTypeEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//每日三次以上
	MoreThan3Times(1, "每日三次以上"),
	//每日3次（含）以下
	NotMoreThanTimes(2, "每日3次（含）以下");

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
    
	public static DiarrheaTypeEnum convertByValue(Integer value){
        for (DiarrheaTypeEnum caseStatus:DiarrheaTypeEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return DiarrheaTypeEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isMoreThan3Times(Integer value){
		return DiarrheaTypeEnum.MoreThan3Times.getValue().equals(value);
	}
	public static boolean isNotMoreThanTimes(Integer value){
		return DiarrheaTypeEnum.NotMoreThanTimes.getValue().equals(value);
	}
    private DiarrheaTypeEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
