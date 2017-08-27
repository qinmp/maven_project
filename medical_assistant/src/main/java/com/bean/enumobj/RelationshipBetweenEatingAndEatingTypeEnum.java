package com.bean.enumobj;

/**
 * 与进食的关系如何类型枚举
 * @author qinmp
 *
 */
public enum RelationshipBetweenEatingAndEatingTypeEnum {
	
	//未选择
	NotSelect(0, "未选择"),
	//腹痛进食后发生
	AbdominalPainOccursAfterEating(1, "腹痛进食后发生"),
	//腹痛进食后减轻
	AbdominalPainDecreasedAfterEating(2, "腹痛进食后减轻"),
	//腹痛与进食无关
	AbdominalPainNotRelationWithEating(3, "腹痛与进食无关");

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
    
	public static RelationshipBetweenEatingAndEatingTypeEnum convertByValue(Integer value){
        for (RelationshipBetweenEatingAndEatingTypeEnum caseStatus:RelationshipBetweenEatingAndEatingTypeEnum.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	public static boolean isNotSelect(Integer value){
		return RelationshipBetweenEatingAndEatingTypeEnum.NotSelect.getValue().equals(value);
	}
	public static boolean isAbdominalPainOccursAfterEating(Integer value){
		return RelationshipBetweenEatingAndEatingTypeEnum.AbdominalPainOccursAfterEating.getValue().equals(value);
	}
	public static boolean isAbdominalPainDecreasedAfterEating(Integer value){
		return RelationshipBetweenEatingAndEatingTypeEnum.AbdominalPainDecreasedAfterEating.getValue().equals(value);
	}
	public static boolean isAbdominalPainNotRelationWithEating(Integer value){
		return RelationshipBetweenEatingAndEatingTypeEnum.AbdominalPainNotRelationWithEating.getValue().equals(value);
	}
    private RelationshipBetweenEatingAndEatingTypeEnum(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}
}
