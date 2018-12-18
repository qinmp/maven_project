package com.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * TDiarrhea entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_diarrhea")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TDiarrhea  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = 7758512092661217097L;
	private Long id;
	private String serialNo;
	private Short diarrheaType;
	private Integer diarrheaContinusTime;
	private Timestamp diarrheaStartTime;
	private Integer eachDayTime;
	private Timestamp createTime;
	private String diarrheaFacet;

	@Transient
	public String getDiarrheaFacet() {
		if(diarrheaContinusTime <= 21){
			diarrheaFacet = "急性";
		} else if(diarrheaContinusTime > 21 && diarrheaContinusTime <= 61){
			diarrheaFacet = "亚急性";
		} else if(diarrheaContinusTime > 61){
			diarrheaFacet = "慢性";
		}else {
			diarrheaFacet = "";
		}
		return diarrheaFacet;
	}

	public void setDiarrheaFacet(String diarrheaFacet) {
		this.diarrheaFacet = diarrheaFacet;
	}

	/** default constructor */
	public TDiarrhea() {
	}

	/** minimal constructor */
	public TDiarrhea(String serialNo, Short diarrheaType,
			Timestamp diarrheaStartTime, Timestamp createTime) {
		this.serialNo = serialNo;
		this.diarrheaType = diarrheaType;
		this.diarrheaStartTime = diarrheaStartTime;
		this.createTime = createTime;
	}

	/** full constructor */
	public TDiarrhea(String serialNo, Short diarrheaType,
			Integer diarrheaContinusTime, Timestamp diarrheaStartTime,
			Integer eachDayTime, Timestamp createTime) {
		this.serialNo = serialNo;
		this.diarrheaType = diarrheaType;
		this.diarrheaContinusTime = diarrheaContinusTime;
		this.diarrheaStartTime = diarrheaStartTime;
		this.eachDayTime = eachDayTime;
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "serial_no", nullable = false, length = 32)
	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	@Column(name = "diarrhea_type", nullable = false)
	public Short getDiarrheaType() {
		return this.diarrheaType;
	}

	public void setDiarrheaType(Short diarrheaType) {
		this.diarrheaType = diarrheaType;
	}

	@Column(name = "diarrhea_continus_time")
	public Integer getDiarrheaContinusTime() {
		return this.diarrheaContinusTime;
	}

	public void setDiarrheaContinusTime(Integer diarrheaContinusTime) {
		this.diarrheaContinusTime = diarrheaContinusTime;
	}

	@Column(name = "diarrhea_start_time")
	public Timestamp getDiarrheaStartTime() {
		return this.diarrheaStartTime;
	}

	public void setDiarrheaStartTime(Timestamp diarrheaStartTime) {
		this.diarrheaStartTime = diarrheaStartTime;
	}

	@Column(name = "each_day_time")
	public Integer getEachDayTime() {
		return this.eachDayTime;
	}

	public void setEachDayTime(Integer eachDayTime) {
		this.eachDayTime = eachDayTime;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}