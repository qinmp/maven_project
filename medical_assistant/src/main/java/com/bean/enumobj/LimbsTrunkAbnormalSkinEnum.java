package com.bean.enumobj;

/**
 * 四肢躯干皮肤 异常 类型枚举
 * @author qinmp
 *
 */
public enum LimbsTrunkAbnormalSkinEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//湿疹
	Czema(1, "湿疹"),
	//过敏
	Allergy(2, "过敏"),
	//其他
	Other(3, "其他");

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
    
	public static LimbsTrunkAbnormalSkinEnum convertByValue(Integer value){
        for (LimbsTrunkAbnormalSkinEnum caseStatus:LimbsTrunkAbnormalSkinEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return LimbsTrunkAbnormalSkinEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isCzema(Integer value){
		return LimbsTrunkAbnormalSkinEnum.Czema.getValue().equals(value);
	}
	public static boolean isAllergy(Integer value){
		return LimbsTrunkAbnormalSkinEnum.Allergy.getValue().equals(value);
	}
	public static boolean isOther(Integer value){
		return LimbsTrunkAbnormalSkinEnum.Other.getValue().equals(value);
	}
    private LimbsTrunkAbnormalSkinEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
