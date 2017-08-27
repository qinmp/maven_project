package com.bean;

public class MenstrualHistoryReqBean {
	
	private String serialNo;
	
	//上次来月经日期
	private String lastMenstrualPeriod;
	//第一次月经年龄;1-30岁
	private Integer firstMenstrualAge;
	//月经多少天;1-30天
	private Integer howManyDayMenstrual;
	//两次月经间隔(1-30天)
	private Integer twoMenstrualIntervals;
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getLastMenstrualPeriod() {
		return lastMenstrualPeriod;
	}
	public void setLastMenstrualPeriod(String lastMenstrualPeriod) {
		this.lastMenstrualPeriod = lastMenstrualPeriod;
	}
	public Integer getFirstMenstrualAge() {
		return firstMenstrualAge;
	}
	public void setFirstMenstrualAge(Integer firstMenstrualAge) {
		this.firstMenstrualAge = firstMenstrualAge;
	}
	public Integer getHowManyDayMenstrual() {
		return howManyDayMenstrual;
	}
	public void setHowManyDayMenstrual(Integer howManyDayMenstrual) {
		this.howManyDayMenstrual = howManyDayMenstrual;
	}
	public Integer getTwoMenstrualIntervals() {
		return twoMenstrualIntervals;
	}
	public void setTwoMenstrualIntervals(Integer twoMenstrualIntervals) {
		this.twoMenstrualIntervals = twoMenstrualIntervals;
	}
}
