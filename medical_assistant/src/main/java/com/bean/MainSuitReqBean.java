package com.bean;

public class MainSuitReqBean {
	private String serialNo;
	private String mainSuitContent;
	private Integer mainSuitValue;
	private String attackTime;
	
	private String mainSuitContent2;
	private Integer mainSuitValue2;
	private String attackTime2;
	
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	public String getMainSuitCotent() {
		return mainSuitContent;
	}
	public void setMainSuitCotent(String mainSuitContent) {
		this.mainSuitContent = mainSuitContent;
	}
	public Integer getMainSuitValue() {
		return mainSuitValue;
	}
	public void setMainSuitValue(Integer mainSuitValue) {
		this.mainSuitValue = mainSuitValue;
	}
	public String getAttackTime() {
		return attackTime;
	}
	public void setAttackTime(String attackTime) {
		this.attackTime = attackTime;
	}
	
	public String getMainSuitContent() {
		return mainSuitContent;
	}
	public void setMainSuitContent(String mainSuitContent) {
		this.mainSuitContent = mainSuitContent;
	}
	public String getMainSuitContent2() {
		return mainSuitContent2;
	}
	public void setMainSuitContent2(String mainSuitContent2) {
		this.mainSuitContent2 = mainSuitContent2;
	}
	public Integer getMainSuitValue2() {
		return mainSuitValue2;
	}
	public void setMainSuitValue2(Integer mainSuitValue2) {
		this.mainSuitValue2 = mainSuitValue2;
	}
	public String getAttackTime2() {
		return attackTime2;
	}
	public void setAttackTime2(String attackTime2) {
		this.attackTime2 = attackTime2;
	}
	@Override
	public String toString() {
		return "BasicInfoReqBean [serialNo=" + serialNo + "]";
	}
	
}
