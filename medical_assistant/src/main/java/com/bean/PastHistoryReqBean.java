package com.bean;

public class PastHistoryReqBean {
	//序列号
	private String serialNo;
	//过敏药物
	private Integer drugAllergyType;
	private String drugName;
	
	//手术历史
	private Integer operationHistoryType;
	private String operationTime;
	private String operationName;
	
	//输血历史
	private Integer transfusionHistoryType;
	private String transfusionTime;
	private String transfusionOperationName;
	

	//乙肝病史
	private Integer hepatitisBHistoryType;
	//结核病史
	private Integer tuberculosisHistoryType;
	
	//尚未治愈的疾病
	private Integer untreatedDiseaseHistoryType;
	private String untreatedDiseaseTime;
	private String untreatedDiseaseName;
	
	//正在服用药物
	private Integer hasDrugsBeingUsedType;
	private String drugsBeingUsedTime;
	private String drugsBeingUsedName;
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public Integer getDrugAllergyType() {
		return drugAllergyType;
	}
	public void setDrugAllergyType(Integer drugAllergyType) {
		this.drugAllergyType = drugAllergyType;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public Integer getOperationHistoryType() {
		return operationHistoryType;
	}
	public void setOperationHistoryType(Integer operationHistoryType) {
		this.operationHistoryType = operationHistoryType;
	}
	public String getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public Integer getTransfusionHistoryType() {
		return transfusionHistoryType;
	}
	public void setTransfusionHistoryType(Integer transfusionHistoryType) {
		this.transfusionHistoryType = transfusionHistoryType;
	}
	public String getTransfusionTime() {
		return transfusionTime;
	}
	public void setTransfusionTime(String transfusionTime) {
		this.transfusionTime = transfusionTime;
	}
	public String getTransfusionOperationName() {
		return transfusionOperationName;
	}
	public void setTransfusionOperationName(String transfusionOperationName) {
		this.transfusionOperationName = transfusionOperationName;
	}
	public Integer getHepatitisBHistoryType() {
		return hepatitisBHistoryType;
	}
	public void setHepatitisBHistoryType(Integer hepatitisBHistoryType) {
		this.hepatitisBHistoryType = hepatitisBHistoryType;
	}
	public Integer getTuberculosisHistoryType() {
		return tuberculosisHistoryType;
	}
	public void setTuberculosisHistoryType(Integer tuberculosisHistoryType) {
		this.tuberculosisHistoryType = tuberculosisHistoryType;
	}
	public Integer getUntreatedDiseaseHistoryType() {
		return untreatedDiseaseHistoryType;
	}
	public void setUntreatedDiseaseHistoryType(Integer untreatedDiseaseHistoryType) {
		this.untreatedDiseaseHistoryType = untreatedDiseaseHistoryType;
	}
	public String getUntreatedDiseaseTime() {
		return untreatedDiseaseTime;
	}
	public void setUntreatedDiseaseTime(String untreatedDiseaseTime) {
		this.untreatedDiseaseTime = untreatedDiseaseTime;
	}
	public String getUntreatedDiseaseName() {
		return untreatedDiseaseName;
	}
	public void setUntreatedDiseaseName(String untreatedDiseaseName) {
		this.untreatedDiseaseName = untreatedDiseaseName;
	}
	public Integer getHasDrugsBeingUsedType() {
		return hasDrugsBeingUsedType;
	}
	public void setHasDrugsBeingUsedType(Integer hasDrugsBeingUsedType) {
		this.hasDrugsBeingUsedType = hasDrugsBeingUsedType;
	}
	public String getDrugsBeingUsedTime() {
		return drugsBeingUsedTime;
	}
	public void setDrugsBeingUsedTime(String drugsBeingUsedTime) {
		this.drugsBeingUsedTime = drugsBeingUsedTime;
	}
	public String getDrugsBeingUsedName() {
		return drugsBeingUsedName;
	}
	public void setDrugsBeingUsedName(String drugsBeingUsedName) {
		this.drugsBeingUsedName = drugsBeingUsedName;
	}
	
}
