package com.bean;

public class BirthHistoryReqBean {
	
	private String serialNo;
	//怀孕过几次；
	private Integer howManyTimesPregnant;
	//分娩过几次
	private Integer howManyTimesDelivered;
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public Integer getHowManyTimesPregnant() {
		return howManyTimesPregnant;
	}
	public void setHowManyTimesPregnant(Integer howManyTimesPregnant) {
		this.howManyTimesPregnant = howManyTimesPregnant;
	}
	public Integer getHowManyTimesDelivered() {
		return howManyTimesDelivered;
	}
	public void setHowManyTimesDelivered(Integer howManyTimesDelivered) {
		this.howManyTimesDelivered = howManyTimesDelivered;
	}

}
