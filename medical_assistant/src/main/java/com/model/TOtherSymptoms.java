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
 * TPalpitation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_other_symptoms")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TOtherSymptoms  extends BaseModel {

	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = 8071702065989940167L;
	private Long id;
	private String serialNo;
	private Integer howTheMind;
	private Timestamp createTime;
	private Integer howTheAppetite;
	private Integer howTheSleep;
	private Integer leastHalfYearWeightChangeType;
	private Double leastHalfYearWeightDown;

	// Constructors

	/** default constructor */
	public TOtherSymptoms() {
		
	}
	
	@Transient
	public String getMindFacet(){
		if(this.howTheMind == 1){
			return "一般";
		} else if(this.howTheMind == 2){
			return "差";
		}
		return "";
	}
	
	@Transient
	public String getAppetiteFacet(){
		if(this.howTheAppetite == 1){
			return "一般";
		} else if(this.howTheAppetite == 2){
			return "差";
		}
		return "";
	}
	
	@Transient
	public String getSleepFacet(){
		if(this.howTheSleep == 1){
			return "一般";
		} else if(this.howTheSleep == 2){
			return "差";
		}
		return "";
	}
	
	@Transient
	public String getWeightChangeFacet(){
		if(this.leastHalfYearWeightChangeType == 1){
			return "无明显变化";
		} else if(this.leastHalfYearWeightChangeType == 2){
			return "半年内减轻" + this.getLeastHalfYearWeightDown();
		}
		return "";
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

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "how_the_mind")
	public Integer getHowTheMind() {
		return howTheMind;
	}

	public void setHowTheMind(Integer howTheMind) {
		this.howTheMind = howTheMind;
	}

	@Column(name = "how_the_appetite")
	public Integer getHowTheAppetite() {
		return howTheAppetite;
	}

	public void setHowTheAppetite(Integer howTheAppetite) {
		this.howTheAppetite = howTheAppetite;
	}

	@Column(name = "how_the_sleep")
	public Integer getHowTheSleep() {
		return howTheSleep;
	}

	public void setHowTheSleep(Integer howTheSleep) {
		this.howTheSleep = howTheSleep;
	}

	@Column(name = "least_half_year_weight_change_type")
	public Integer getLeastHalfYearWeightChangeType() {
		return leastHalfYearWeightChangeType;
	}

	public void setLeastHalfYearWeightChangeType(Integer leastHalfYearWeightChangeType) {
		this.leastHalfYearWeightChangeType = leastHalfYearWeightChangeType;
	}

	@Column(name = "least_half_year_weight_down")
	public Double getLeastHalfYearWeightDown() {
		return leastHalfYearWeightDown;
	}

	public void setLeastHalfYearWeightDown(Double leastHalfYearWeightDown) {
		this.leastHalfYearWeightDown = leastHalfYearWeightDown;
	}
	
}