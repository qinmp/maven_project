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

import com.bean.enumobj.AstrictionTimesOfWeekTypeEnum;
import com.bean.enumobj.AstrictionTypeEnum;

/**
 * TAstriction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_astriction")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TAstriction  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = -7016170992795821751L;
	private Long id;
	private String serialNo;
	private Short continueTimeIsMoreThanHalfYear;
	private Short isMoreThanThreeTime;
	private Timestamp createTime;
	private String astrictionFacet;

	@Transient
	public String getAstrictionFacet() {
		if(AstrictionTimesOfWeekTypeEnum.isAstrictionTimesOfWeekMoreThanThreeTimes(isMoreThanThreeTime.intValue()) || 
				AstrictionTypeEnum.isContinueTimeLessThanHalfYear(this.continueTimeIsMoreThanHalfYear.intValue())){
			astrictionFacet = "正常";
		} else if(AstrictionTimesOfWeekTypeEnum.isAstrictionTimesOfWeekLessThanThreeTimes(isMoreThanThreeTime.intValue())){
			astrictionFacet = "大便习惯改变-便秘";
		} else {
			astrictionFacet = "";
		}
		return astrictionFacet;
	}

	public void setAstrictionFacet(String astrictionFacet) {
		this.astrictionFacet = astrictionFacet;
	}

	/** default constructor */
	public TAstriction() {
	}

	/** minimal constructor */
	public TAstriction(String serialNo, Short continueTimeIsMoreThanHalfYear,
			Timestamp createTime) {
		this.serialNo = serialNo;
		this.continueTimeIsMoreThanHalfYear = continueTimeIsMoreThanHalfYear;
		this.createTime = createTime;
	}

	/** full constructor */
	public TAstriction(String serialNo, Short continueTimeIsMoreThanHalfYear,
			Short isMoreThanThreeTime, Timestamp createTime) {
		this.serialNo = serialNo;
		this.continueTimeIsMoreThanHalfYear = continueTimeIsMoreThanHalfYear;
		this.isMoreThanThreeTime = isMoreThanThreeTime;
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

	@Column(name = "continue_time_is_more_than_half_year", nullable = false)
	public Short getContinueTimeIsMoreThanHalfYear() {
		return this.continueTimeIsMoreThanHalfYear;
	}

	public void setContinueTimeIsMoreThanHalfYear(
			Short continueTimeIsMoreThanHalfYear) {
		this.continueTimeIsMoreThanHalfYear = continueTimeIsMoreThanHalfYear;
	}

	@Column(name = "is_more_than_three_time")
	public Short getIsMoreThanThreeTime() {
		return this.isMoreThanThreeTime;
	}

	public void setIsMoreThanThreeTime(Short isMoreThanThreeTime) {
		this.isMoreThanThreeTime = isMoreThanThreeTime;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}