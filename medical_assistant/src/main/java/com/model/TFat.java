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
 * TFat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_fat")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TFat  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = -2111710373730676531L;
	private Long id;
	private String serialNo;
	private Double nowWeight;
	private Double height;
	private Double bmi;
	private Timestamp createTime;
	private String fatFacet;
	private String noticeStr;

	@Transient
	public String getFatFacet() {
		if(bmi >= 24.0 && bmi <= 30.0){
			fatFacet = "超重";
		} else if(bmi > 30.0 ){
			fatFacet = "肥胖";
		} else {
			fatFacet = "正常";
		}
		return fatFacet;
	}

	public void setFatFacet(String fatFacet) {
		this.fatFacet = fatFacet;
	}
	@Transient
	public String getNoticeStr() {
		if(bmi >= 24.0 && bmi <= 30.0){
			noticeStr = "建议:推荐使用药物“奥利司他”";
		} else if(bmi > 30.0 ){
			noticeStr = "";
		} else {
			noticeStr = "";
		}
		return noticeStr;
	}

	public void setNoticeStr(String noticeStr) {
		this.noticeStr = noticeStr;
	}

	/** default constructor */
	public TFat() {
	}

	/** full constructor */
	public TFat(String serialNo, Double nowWeight, Double height, Double bmi,
			Timestamp createTime) {
		this.serialNo = serialNo;
		this.nowWeight = nowWeight;
		this.height = height;
		this.bmi = bmi;
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

	@Column(name = "now_weight", nullable = false, precision = 22, scale = 0)
	public Double getNowWeight() {
		return this.nowWeight;
	}

	public void setNowWeight(Double nowWeight) {
		this.nowWeight = nowWeight;
	}

	@Column(name = "height", nullable = false, precision = 22, scale = 0)
	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Column(name = "BMI", nullable = false, precision = 22, scale = 0)
	public Double getBmi() {
		return this.bmi;
	}

	public void setBmi(Double bmi) {
		this.bmi = bmi;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}