package com.bean.enumobj;

/**
* 版权所有：深圳法大大网络科技有限公司 
*====================================================
* 文件名称: EnumCacheContainer.java
* 修订记录：
* No    日期				作者(操作:具体内容)
* 1.    2015-3-17			苏晓慧(创建:创建文件)
*====================================================
* 类描述：(说明未实现或其它不应生成javadoc的内容)
* 
*/

/**
 * <h3>概要:</h3> 
 *   渠道类型，对应canals_id表字段----- 类型  1-活动套餐展示，2-首页套餐展示
 * <br>
 * <h3>功能:</h3>
 * <ol>
 * 		<li>TODO(这里用一句话描述功能点)</li>
 * </ol>
 * <h3>履历:</h3>
 * <ol>
 * 		<li>2015-3-17[zxj] 新建</li>
 * </ol>
 */
public enum IsDeleteType {

	
	/** 未删除 */
	NOTDELETE(0,"未删除"),
   	/** 逻辑删除 */
	DELETED(1,"删除");
	
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

	/**
	 * <b>概要：</b>
	 * 	根据属性值匹配属性
	 * <b>作者：</b>SUXH </br>
	 * <b>日期：</b>2015-3-17 </br>
	 * @param value 需要匹配的属性值
	 * @return
	 */
	public static IsDeleteType convertByValue(Integer value){
        for (IsDeleteType caseStatus:IsDeleteType.values()) {  
            if (caseStatus.getValue() == value) {  
                return caseStatus;  
            }  
        }  
        return null;  
	}
	
	private IsDeleteType(Integer value,String valueInFact){
		this.value=value;
		this.valueInFact=valueInFact;
	}

	public static boolean isNot_Delete(Integer value){
		return IsDeleteType.NOTDELETE.getValue().equals(value);
	}
	public static boolean isDelete(Integer value){
		return IsDeleteType.DELETED.getValue().equals(value);
	}
}

