package com.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * TBellyache entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_bellyache")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TBellyache  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = 2414649277486843711L;
	private Long id;
	private String serialNo;
	private Long painId;
	private String bellyacheContinueTime;
	private Short continuousOrIndirectnessType;
	private Short relationshipWithEatType;
	private Short painNatureType;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public TBellyache() {
	}

	/** minimal constructor */
	public TBellyache(String serialNo, Long painId,
			String bellyacheContinueTime, Short continuousOrIndirectnessType,
			Short painNatureType, Timestamp createTime) {
		this.serialNo = serialNo;
		this.painId = painId;
		this.bellyacheContinueTime = bellyacheContinueTime;
		this.continuousOrIndirectnessType = continuousOrIndirectnessType;
		this.painNatureType = painNatureType;
		this.createTime = createTime;
	}

	/** full constructor */
	public TBellyache(String serialNo, Long painId,
			String bellyacheContinueTime, Short continuousOrIndirectnessType,
			Short relationshipWithEatType, Short painNatureType,
			Timestamp createTime) {
		this.serialNo = serialNo;
		this.painId = painId;
		this.bellyacheContinueTime = bellyacheContinueTime;
		this.continuousOrIndirectnessType = continuousOrIndirectnessType;
		this.relationshipWithEatType = relationshipWithEatType;
		this.painNatureType = painNatureType;
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

	@Column(name = "pain_id", nullable = false)
	public Long getPainId() {
		return this.painId;
	}

	public void setPainId(Long painId) {
		this.painId = painId;
	}

	@Column(name = "bellyache_continue_time", nullable = false, length = 32)
	public String getBellyacheContinueTime() {
		return this.bellyacheContinueTime;
	}

	public void setBellyacheContinueTime(String bellyacheContinueTime) {
		this.bellyacheContinueTime = bellyacheContinueTime;
	}

	@Column(name = "continuous_or_indirectness_type", nullable = false)
	public Short getContinuousOrIndirectnessType() {
		return this.continuousOrIndirectnessType;
	}

	public void setContinuousOrIndirectnessType(
			Short continuousOrIndirectnessType) {
		this.continuousOrIndirectnessType = continuousOrIndirectnessType;
	}

	@Column(name = "relationship_with_eat_type")
	public Short getRelationshipWithEatType() {
		return this.relationshipWithEatType;
	}

	public void setRelationshipWithEatType(Short relationshipWithEatType) {
		this.relationshipWithEatType = relationshipWithEatType;
	}

	@Column(name = "pain_nature_type", nullable = false)
	public Short getPainNatureType() {
		return this.painNatureType;
	}

	public void setPainNatureType(Short painNatureType) {
		this.painNatureType = painNatureType;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}