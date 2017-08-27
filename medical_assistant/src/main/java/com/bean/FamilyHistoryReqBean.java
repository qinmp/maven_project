package com.bean;

public class FamilyHistoryReqBean {
	
	private String serialNo;
	
	//1.有类似疾病；2.没有类似疾病；
	private Integer similarDiseaseType;
	
	//类似疾病名称
	private String similarDiseaseName;
	
	//1.有遗传性疾病；2.没有遗传性疾病；
	private Integer hereditaryDisease;
	
	////遗传性疾病名称；
	private String hereditaryDiseaseName;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getSimilarDiseaseType() {
		return similarDiseaseType;
	}

	public void setSimilarDiseaseType(Integer similarDiseaseType) {
		this.similarDiseaseType = similarDiseaseType;
	}

	public String getSimilarDiseaseName() {
		return similarDiseaseName;
	}

	public void setSimilarDiseaseName(String similarDiseaseName) {
		this.similarDiseaseName = similarDiseaseName;
	}

	public Integer getHereditaryDisease() {
		return hereditaryDisease;
	}

	public void setHereditaryDisease(Integer hereditaryDisease) {
		this.hereditaryDisease = hereditaryDisease;
	}

	public String getHereditaryDiseaseName() {
		return hereditaryDiseaseName;
	}

	public void setHereditaryDiseaseName(String hereditaryDiseaseName) {
		this.hereditaryDiseaseName = hereditaryDiseaseName;
	}
	
}
