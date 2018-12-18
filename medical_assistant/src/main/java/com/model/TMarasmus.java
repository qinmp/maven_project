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
 * TMarasmus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_marasmus")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TMarasmus  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = 8914942461113140173L;
	private Long id;
	private String serialNo;
	private Double nowWeight;
	private Double height;
	private Double bmi;
	private Double weightDownWthinHalfYear;
	private Timestamp createTime;
	private String marasmusFacet;
	private String noticeStr;
	//体重减轻量症状定义为
	private String weightDownFacet;
	//体重减轻提示
	private String weightDownnoticeStr;
	
	@Transient
	public String getWeightDownnoticeStr() {
		if(weightDownWthinHalfYear >= 10.0){
			weightDownnoticeStr = "温馨提示:请到医院就诊";
		} else {
			weightDownnoticeStr = "";
		}
		return weightDownnoticeStr;
	}

	public void setWeightDownnoticeStr(String weightDownnoticeStr) {
		this.weightDownnoticeStr = weightDownnoticeStr;
	}

	@Transient
	public String getWeightDownFacet() {
		if(weightDownWthinHalfYear >= 10.0){
			weightDownFacet = "恶病质";
		} else {
			weightDownFacet = "正常";
		}
		return weightDownFacet;
	}

	public void setWeightDownFacet(String weightDownFacet) {
		this.weightDownFacet = weightDownFacet;
	}

	@Transient
	public String getMarasmusFacet() {
		if(bmi < 18.5){
			marasmusFacet = "消瘦";
		} else {
			marasmusFacet = "正常";
		}
		return marasmusFacet;
	}

	public void setMarasmusFacet(String marasmusFacet) {
		this.marasmusFacet = marasmusFacet;
	}
	
	@Transient
	public String getNoticeStr() {
		if(bmi < 18.5){
			noticeStr = "建议:请到医院就诊";
		} else {
			noticeStr = "";
		}
		return noticeStr;
	}

	public void setNoticeStr(String noticeStr) {
		this.noticeStr = noticeStr;
	}

	
	/** default constructor */
	public TMarasmus() {
	}

	/** full constructor */
	public TMarasmus(String serialNo, Double nowWeight, Double height,
			Double bmi, Double weightDownWthinHalfYear, Timestamp createTime) {
		this.serialNo = serialNo;
		this.nowWeight = nowWeight;
		this.height = height;
		this.bmi = bmi;
		this.weightDownWthinHalfYear = weightDownWthinHalfYear;
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

	@Column(name = "weight_down_wthin_half_year", nullable = false, precision = 22, scale = 0)
	public Double getWeightDownWthinHalfYear() {
		return this.weightDownWthinHalfYear;
	}

	public void setWeightDownWthinHalfYear(Double weightDownWthinHalfYear) {
		this.weightDownWthinHalfYear = weightDownWthinHalfYear;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}