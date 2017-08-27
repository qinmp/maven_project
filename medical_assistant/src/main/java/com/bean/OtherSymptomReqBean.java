package com.bean;

public class OtherSymptomReqBean {
	//序列号
	private String serialNo;
	//精神如何
	private Integer howTheMind;
	//食欲如何
	private Integer howTheAppetite;
	//睡眠如何
	private Integer howTheSleep;
	//最近半年来体重变化
	private Integer leastHalfYearWeightChangeType;
	//减轻多少千克的体重
	private Double weightDown;
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public Integer getHowTheMind() {
		return howTheMind;
	}
	public void setHowTheMind(Integer howTheMind) {
		this.howTheMind = howTheMind;
	}
	public Integer getHowTheAppetite() {
		return howTheAppetite;
	}
	public void setHowTheAppetite(Integer howTheAppetite) {
		this.howTheAppetite = howTheAppetite;
	}
	public Integer getHowTheSleep() {
		return howTheSleep;
	}
	public void setHowTheSleep(Integer howTheSleep) {
		this.howTheSleep = howTheSleep;
	}
	public Integer getLeastHalfYearWeightChangeType() {
		return leastHalfYearWeightChangeType;
	}
	public void setLeastHalfYearWeightChangeType(Integer leastHalfYearWeightChangeType) {
		this.leastHalfYearWeightChangeType = leastHalfYearWeightChangeType;
	}
	public Double getWeightDown() {
		return weightDown;
	}
	public void setWeightDown(Double weightDown) {
		this.weightDown = weightDown;
	}
	
}
