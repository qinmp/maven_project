package com.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "t_family_history", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TFamilyHistory  extends BaseModel  {
	private static final long serialVersionUID = -6773945432898884853L;
	private Long id;
	private String serialNo;
	private Timestamp createTime;
	//是否有类似疾病
	private Integer similarDisease;
	private String similarDiseaseName;
	//是否有遗传疾病；
	private Integer hereditaryDisease;
	private String hereditaryDiseaseName;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "serial_no")
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	@Column(name = "create_time")
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Column(name = "a_similar_disease")
	public Integer getSimilarDisease() {
		return similarDisease;
	}
	public void setSimilarDisease(Integer similarDisease) {
		this.similarDisease = similarDisease;
	}
	@Column(name = "similar_disease_name")
	public String getSimilarDiseaseName() {
		return similarDiseaseName;
	}
	public void setSimilarDiseaseName(String similarDiseaseName) {
		this.similarDiseaseName = similarDiseaseName;
	}
	@Column(name = "hereditary_disease")
	public Integer getHereditaryDisease() {
		return hereditaryDisease;
	}
	public void setHereditaryDisease(Integer hereditaryDisease) {
		this.hereditaryDisease = hereditaryDisease;
	}
	@Column(name = "hereditary_disease_name")
	public String getHereditaryDiseaseName() {
		return hereditaryDiseaseName;
	}
	public void setHereditaryDiseaseName(String hereditaryDiseaseName) {
		this.hereditaryDiseaseName = hereditaryDiseaseName;
	}
}
