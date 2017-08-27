package com.bean.enumobj;

/**
 * 咳痰颜色枚举
 * @author qinmp
 *
 */
public enum ExpectorationEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//黄痰
	YellowColor(1, "黄痰"),
	//白痰
	WhiteColor(2, "白痰"),
	//带血痰
	Bloodysputum(3, "带血痰");
	
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
    
	public static ExpectorationEnum convertByValue(Integer value){
        for (ExpectorationEnum caseStatus:ExpectorationEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return ExpectorationEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isYellowColor(Integer value){
		return ExpectorationEnum.YellowColor.getValue().equals(value);
	}
	public static boolean isWhiteColor(Integer value){
		return ExpectorationEnum.WhiteColor.getValue().equals(value);
	}
	public static boolean isBloodysputum(Integer value){
		return ExpectorationEnum.Bloodysputum.getValue().equals(value);
	}
    private ExpectorationEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
