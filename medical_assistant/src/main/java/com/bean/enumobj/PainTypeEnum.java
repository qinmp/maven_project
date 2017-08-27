package com.bean.enumobj;

/**
 * 呕吐类型枚举
 * @author qinmp
 *
 */
public enum PainTypeEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//头疼
	HeadAche(1, "头疼"),
	//牙疼
	Toothache(2, "牙疼"),
	//腰背疼
	BackPain(3, "腰背痛"),
	//关节痛
	Arthralgia(4,"关节痛"),
	//痛经
	Dysmenorrhea(5, "痛经"),
	//腹痛
	AbdominalPain(6, "腹痛");
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
    
	public static PainTypeEnum convertByValue(Integer value){
        for (PainTypeEnum caseStatus:PainTypeEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return PainTypeEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isHeadAche(Integer value){
		return PainTypeEnum.HeadAche.getValue().equals(value);
	}
	public static boolean isToothache(Integer value){
		return PainTypeEnum.Toothache.getValue().equals(value);
	}
	public static boolean isBackPain(Integer value){
		return PainTypeEnum.BackPain.getValue().equals(value);
	}
	public static boolean isArthralgia(Integer value){
		return PainTypeEnum.Arthralgia.getValue().equals(value);
	}
	public static boolean isDysmenorrhea(Integer value){
		return PainTypeEnum.Dysmenorrhea.getValue().equals(value);
	}
	public static boolean isAbdominalPain(Integer value){
		return PainTypeEnum.AbdominalPain.getValue().equals(value);
	}
    private PainTypeEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
