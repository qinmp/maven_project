package com.bean;

public class BasicInfoReqBean {
	private String serialNo;
	private String name;
	private String realBirthDay;
	private String age;
	private String ageText;
	private Integer sex;
	//籍贯
	private String  nativePlace;
	//现居住地
	private String presentResidence;
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealBirthDay() {
		return realBirthDay;
	}
	public void setRealBirthDay(String realBirthDay) {
		this.realBirthDay = realBirthDay;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getPresentResidence() {
		return presentResidence;
	}
	public void setPresentResidence(String presentResidence) {
		this.presentResidence = presentResidence;
	}
	
	public String getAgeText() {
		return ageText;
	}
	public void setAgeText(String ageText) {
		this.ageText = ageText;
	}
	@Override
	public String toString() {
		return "BasicInfoReqBean [serialNo=" + serialNo + "]";
	}
	
}
