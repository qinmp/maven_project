package com.bean.enumobj;

/**
 * 皮肤异常类型枚举
 * @author qinmp
 *
 */
public enum AbnormalSkinTypeEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//面部
	Face(1, "面部"),
	//颈部、腋下
	NeckOrArmpit(2, "颈部、腋下"),
	//会阴部
	Perineum(3, "会阴部"),
	//头皮
	Scalp(4, "头皮"), 
	//手足部
	HandAndFoot(5, "手足部"),
	//四肢躯干
	LimbsTrunk(6, "四肢躯干");

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
    
	public static AbnormalSkinTypeEnum convertByValue(Integer value){
        for (AbnormalSkinTypeEnum caseStatus:AbnormalSkinTypeEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return AbnormalSkinTypeEnum.NotSelect.getValue().equals(value);
	}
	public static boolean Face(Integer value){
		return AbnormalSkinTypeEnum.Face.getValue().equals(value);
	}
	public static boolean isNeckOrArmpit(Integer value){
		return AbnormalSkinTypeEnum.NeckOrArmpit.getValue().equals(value);
	}
	public static boolean isPerineum(Integer value){
		return AbnormalSkinTypeEnum.Perineum.getValue().equals(value);
	}
	public static boolean isScalp(Integer value){
		return AbnormalSkinTypeEnum.Scalp.getValue().equals(value);
	}
	public static boolean isHandAndFoot(Integer value){
		return AbnormalSkinTypeEnum.HandAndFoot.getValue().equals(value);
	}
	public static boolean isLimbsTrunk(Integer value){
		return AbnormalSkinTypeEnum.LimbsTrunk.getValue().equals(value);
	}
    private AbnormalSkinTypeEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
