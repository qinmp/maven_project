package com.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.util.DateUtil;

//病史回顾
@Entity
@Table(name = "t_medical_history_review", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TMedicalHistoryReview  extends BaseModel  {
	private static final long serialVersionUID = 8914942461113140173L;
	private Long id;
	private String serialNo;
	private Timestamp createTime;
	
	private Integer notYetBeenCured;//有无尚未治愈的疾病；1.有；2.没有
	private Timestamp happendTime;//有尚未治愈的疾病，发生时间；
	private String illnessName;//疾病名称，以逗号分割；
	private Integer drugsTaken;//有无正在服用的药物；1.有；2.没有
	private Timestamp drugsTakenTime;//正在服用药物开始时间；
	private String drugsName;//药物名称
	
	@Transient
	public String getNotYetBeenCuredFacet(){
		
		if(this.notYetBeenCured == 1){
			return "目前有"+ DateUtil.dateToString(this.happendTime) + "年诊断出的" + this.illnessName + "等已经诊断但尚未治愈的疾病。";
		} else if(this.notYetBeenCured == 2){
			return "否认目前有已经诊断但尚未治愈的疾病";
		}
		return "";
	}
	
	@Transient
	public String getDrugsTakenFacet(){
		
		if(this.drugsTaken == 1){
			return "目前有"+ DateUtil.dateToString(this.drugsTakenTime) + "年服用过" + this.drugsName + "等药物。";
		} else if(this.drugsTaken == 2){
			return "否认正在服用药物";
		}
		return "";
	}
	
	@Transient
	public String getFormatHappendTime(){
		if(this.happendTime != null){
			return DateUtil.dateToString(this.happendTime);
		}
		return "";
	}
	
	@Transient
	public String getFormatDrugsTakenTime(){
		if(this.drugsTakenTime != null){
			return DateUtil.dateToString(this.drugsTakenTime);
		}
		return "";
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "serial_no", nullable = false, length = 32)
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "not_yet_been_cured")
	public Integer getNotYetBeenCured() {
		return notYetBeenCured;
	}
	public void setNotYetBeenCured(Integer notYetBeenCured) {
		this.notYetBeenCured = notYetBeenCured;
	}
	
	@Column(name = "happend_time")
	public Timestamp getHappendTime() {
		return happendTime;
	}
	public void setHappendTime(Timestamp happendTime) {
		this.happendTime = happendTime;
	}
	
	@Column(name = "illness_name")
	public String getIllnessName() {
		return illnessName;
	}
	public void setIllnessName(String illnessName) {
		this.illnessName = illnessName;
	}
	
	@Column(name = "drugs_taken")
	public Integer getDrugsTaken() {
		return drugsTaken;
	}
	public void setDrugsTaken(Integer drugsTaken) {
		this.drugsTaken = drugsTaken;
	}
	
	@Column(name = "drugs_taken_time")
	public Timestamp getDrugsTakenTime() {
		return drugsTakenTime;
	}
	public void setDrugsTakenTime(Timestamp drugsTakenTime) {
		this.drugsTakenTime = drugsTakenTime;
	}
	
	@Column(name = "drugs_name")
	public String getDrugsName() {
		return drugsName;
	}
	public void setDrugsName(String drugsName) {
		this.drugsName = drugsName;
	}
	
}
