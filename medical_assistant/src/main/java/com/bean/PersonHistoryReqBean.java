package com.bean;

public class PersonHistoryReqBean {
	//序列号
	private String serialNo;
	//是否吸烟
	private Integer smokingType;
	//已经戒烟多少年
	private Integer notSmokingYear;
	//曾经吸烟多少年
	private Integer hasSmokingYear;
	//平均一天多少支
	private Integer howManyCigaretteEachDay;
	//1.从来不喝；2.现在已经戒酒；3.目前尚未戒酒；
	private Integer drinkType;
	//已经戒酒多少年
	private Integer notDrinkYear;
	//1.啤酒；2.黄酒；3.白酒；
	private Integer alcoholType;
	//已经喝酒的年限；
	private Integer hasDrinkYear;
	//平均一天多少两
	private Integer howManyDrinkEachDay;
	//是否在疫区生活过；1.有；2.没有；
	private Integer hasLifeEpidemicArea;
	//到过哪里生活
	private String epidemicAreaPlace;
	
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public Integer getSmokingType() {
		return smokingType;
	}
	public void setSmokingType(Integer smokingType) {
		this.smokingType = smokingType;
	}
	public Integer getNotSmokingYear() {
		return notSmokingYear;
	}
	public void setNotSmokingYear(Integer notSmokingYear) {
		this.notSmokingYear = notSmokingYear;
	}
	public Integer getHasSmokingYear() {
		return hasSmokingYear;
	}
	public void setHasSmokingYear(Integer hasSmokingYear) {
		this.hasSmokingYear = hasSmokingYear;
	}
	public Integer getHowManyCigaretteEachDay() {
		return howManyCigaretteEachDay;
	}
	public void setHowManyCigaretteEachDay(Integer howManyCigaretteEachDay) {
		this.howManyCigaretteEachDay = howManyCigaretteEachDay;
	}
	public Integer getDrinkType() {
		return drinkType;
	}
	public void setDrinkType(Integer drinkType) {
		this.drinkType = drinkType;
	}
	public Integer getNotDrinkYear() {
		return notDrinkYear;
	}
	public void setNotDrinkYear(Integer notDrinkYear) {
		this.notDrinkYear = notDrinkYear;
	}
	public Integer getAlcoholType() {
		return alcoholType;
	}
	public void setAlcoholType(Integer alcoholType) {
		this.alcoholType = alcoholType;
	}
	public Integer getHasDrinkYear() {
		return hasDrinkYear;
	}
	public void setHasDrinkYear(Integer hasDrinkYear) {
		this.hasDrinkYear = hasDrinkYear;
	}
	public Integer getHowManyDrinkEachDay() {
		return howManyDrinkEachDay;
	}
	public void setHowManyDrinkEachDay(Integer howManyDrinkEachDay) {
		this.howManyDrinkEachDay = howManyDrinkEachDay;
	}
	public Integer getHasLifeEpidemicArea() {
		return hasLifeEpidemicArea;
	}
	public void setHasLifeEpidemicArea(Integer hasLifeEpidemicArea) {
		this.hasLifeEpidemicArea = hasLifeEpidemicArea;
	}
	public String getEpidemicAreaPlace() {
		return epidemicAreaPlace;
	}
	public void setEpidemicAreaPlace(String epidemicAreaPlace) {
		this.epidemicAreaPlace = epidemicAreaPlace;
	}
}
