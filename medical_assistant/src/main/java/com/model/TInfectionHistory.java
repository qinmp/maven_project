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

@Entity
@Table(name = "t_infection_history")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TInfectionHistory  extends BaseModel  {
	private static final long serialVersionUID = -4113037209152318112L;
	private Long id;
	private String serialNo;
	private Timestamp createTime;
	private Integer infectionType;//传染病类型;
	private Integer hepatitisB;//是否有乙肝；
	private Integer tuberculosis;//是否有结核病；
	
	@Transient
	public String getHepatitisBFacet(){
		
		if(this.hepatitisB == 1){
			return "有乙肝病史";
		} else if(this.hepatitisB == 2){
			return "否认乙肝病史";
		}
		return "";
	}
	
	@Transient
	public String getTuberculosisFacet(){
		
		if(this.tuberculosis == 1){
			return "有结核病史";
		} else if(this.tuberculosis == 2){
			return "否认结核病史";
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
	
	@Column(name = "create_time")
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "infection_type")
	public Integer getInfectionType() {
		return infectionType;
	}
	public void setInfectionType(Integer infectionType) {
		this.infectionType = infectionType;
	}
	
	@Column(name = "hepatitis_B")
	public Integer getHepatitisB() {
		return hepatitisB;
	}
	public void setHepatitisB(Integer hepatitisB) {
		this.hepatitisB = hepatitisB;
	}
	
	@Column(name = "tuberculosis")
	public Integer getTuberculosis() {
		return tuberculosis;
	}
	public void setTuberculosis(Integer tuberculosis) {
		this.tuberculosis = tuberculosis;
	}
	
}
