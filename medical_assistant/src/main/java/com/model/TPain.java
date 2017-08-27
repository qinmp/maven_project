package com.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.bean.enumobj.ContinuousOrIntermittentTypeEnum;
import com.bean.enumobj.PainPropertyTypeEnum;
import com.bean.enumobj.PainTypeEnum;
import com.bean.enumobj.RelationshipBetweenEatingAndEatingTypeEnum;
import com.util.DateUtil;

/**
 * TPain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_pain", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TPain  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = -5351681181987860204L;
	private Long id;
	private String serialNo;
	private Short painType;
	private Timestamp painStartTime;
	private Short painContinuousOrIntermittentType;
	private Short relationshipBetweenEatingAndEatingType;
	private Short painPropertyType;
	private Timestamp createTime;
	//持续时间，天
	private Integer painContinueTime;
	//持续性还是间歇性描述；
	private String painContinuousOrIntermittentTypeFacet;
	//疼痛类型描述
	private String painTypeFacet;
	//与进食关系如何描述
	private String relationshipBetweenEatingAndEatingTypeFacet;
	//疼痛性质描述、
	private String painPropertyTypeFacet;
	
	@Transient
	public String getPainPropertyTypeFacet() {
		painPropertyTypeFacet = PainPropertyTypeEnum.convertByValue(painPropertyType.intValue()).getValueInFact();
		return painPropertyTypeFacet;
	}

	public void setPainPropertyTypeFacet(String painPropertyTypeFacet) {
		this.painPropertyTypeFacet = painPropertyTypeFacet;
	}

	@Transient
	public String getRelationshipBetweenEatingAndEatingTypeFacet() {
		relationshipBetweenEatingAndEatingTypeFacet = RelationshipBetweenEatingAndEatingTypeEnum.
				convertByValue(relationshipBetweenEatingAndEatingType.intValue()).getValueInFact();
		return relationshipBetweenEatingAndEatingTypeFacet;
	}

	public void setRelationshipBetweenEatingAndEatingTypeFacet(String relationshipBetweenEatingAndEatingTypeFacet) {
		this.relationshipBetweenEatingAndEatingTypeFacet = relationshipBetweenEatingAndEatingTypeFacet;
	}

	@Transient
	public String getPainTypeFacet() {
		painTypeFacet = PainTypeEnum.convertByValue(painType.intValue()).getValueInFact();
		return painTypeFacet;
	}

	public void setPainTypeFacet(String painTypeFacet) {
		this.painTypeFacet = painTypeFacet;
	}

	@Transient
	public String getPainContinuousOrIntermittentTypeFacet() {
		painContinuousOrIntermittentTypeFacet =  ContinuousOrIntermittentTypeEnum.convertByValue(painContinuousOrIntermittentType.intValue()).getValueInFact();
		return painContinuousOrIntermittentTypeFacet;
	}

	public void setPainContinuousOrIntermittentTypeFacet(String painContinuousOrIntermittentTypeFacet) {
		this.painContinuousOrIntermittentTypeFacet = painContinuousOrIntermittentTypeFacet;
	}

	@Transient
	public Integer getPainContinueTime() {
		if(null != painStartTime){
			painContinueTime = DateUtil.daysOfTwo(painStartTime, new Date()); 
			return painContinueTime;
		}
		return null;
	}

	public void setPainContinueTime(Integer painContinueTime) {
		this.painContinueTime = painContinueTime;
	}

	/** default constructor */
	public TPain() {
	}

	@Column(name = "pain_start_time")
	public Timestamp getPainStartTime() {
		return painStartTime;
	}

	public void setPainStartTime(Timestamp painStartTime) {
		this.painStartTime = painStartTime;
	}

	@Column(name = "pain_continuous_or_Intermittent")
	public Short getPainContinuousOrIntermittentType() {
		return painContinuousOrIntermittentType;
	}

	public void setPainContinuousOrIntermittentType(Short painContinuousOrIntermittentType) {
		this.painContinuousOrIntermittentType = painContinuousOrIntermittentType;
	}

	@Column(name = "relationship_between_eating_and_eating")
	public Short getRelationshipBetweenEatingAndEatingType() {
		return relationshipBetweenEatingAndEatingType;
	}

	public void setRelationshipBetweenEatingAndEatingType(Short relationshipBetweenEatingAndEatingType) {
		this.relationshipBetweenEatingAndEatingType = relationshipBetweenEatingAndEatingType;
	}

	@Column(name = "pain_property")
	public Short getPainPropertyType() {
		return painPropertyType;
	}

	public void setPainPropertyType(Short painPropertyType) {
		this.painPropertyType = painPropertyType;
	}

	/** full constructor */
	public TPain(String serialNo, Short painType, Timestamp createTime) {
		this.serialNo = serialNo;
		this.painType = painType;
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

	@Column(name = "pain_type", nullable = false)
	public Short getPainType() {
		return this.painType;
	}

	public void setPainType(Short painType) {
		this.painType = painType;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}