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

import com.bean.enumobj.AbnormalSkinTypeEnum;
import com.bean.enumobj.LimbsTrunkAbnormalSkinEnum;

/**
 * TAbnormalskin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_abnormalskin")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TAbnormalskin extends BaseModel {

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = -6095721950722196194L;
	// Fields

	private Long id;
	private String serialNo;
	private Short abnormalSkin;
	private Short limbsTrunk;
	private String otherProblem;
	private Timestamp createTime;
	private String abnormalSkinFacet;
	private String limbsTrunkFacet;

	@Transient
	public String getAbnormalSkinFacet() {
		this.abnormalSkinFacet = AbnormalSkinTypeEnum.convertByValue(abnormalSkin.intValue()).getValueInFact();
		return this.abnormalSkinFacet;
	}

	public void setAbnormalSkinFacet(String abnormalSkinFacet) {
		this.abnormalSkinFacet = abnormalSkinFacet;
	}

	@Transient
	public String getLimbsTrunkFacet() {
		if(LimbsTrunkAbnormalSkinEnum.isNotSelect(limbsTrunk.intValue())){
			this.limbsTrunkFacet = "";
		} else if(LimbsTrunkAbnormalSkinEnum.isOther(limbsTrunk.intValue())){
			this.limbsTrunkFacet = otherProblem;
		} else {
			this.limbsTrunkFacet = LimbsTrunkAbnormalSkinEnum.convertByValue(limbsTrunk.intValue()).getValueInFact();
		}
		return limbsTrunkFacet;
	}

	public void setLimbsTrunkFacet(String limbsTrunkFacet) {
		this.limbsTrunkFacet = limbsTrunkFacet;
	}

	/** default constructor */
	public TAbnormalskin() {
	}

	/** minimal constructor */
	public TAbnormalskin(String serialNo, Short abnormalSkin,
			Timestamp createTime) {
		this.serialNo = serialNo;
		this.abnormalSkin = abnormalSkin;
		this.createTime = createTime;
	}

	/** full constructor */
	public TAbnormalskin(String serialNo, Short abnormalSkin, Short limbsTrunk,
			String otherProblem, Timestamp createTime) {
		this.serialNo = serialNo;
		this.abnormalSkin = abnormalSkin;
		this.limbsTrunk = limbsTrunk;
		this.otherProblem = otherProblem;
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

	@Column(name = "abnormalSkin", nullable = false)
	public Short getAbnormalSkin() {
		return this.abnormalSkin;
	}

	public void setAbnormalSkin(Short abnormalSkin) {
		this.abnormalSkin = abnormalSkin;
	}

	@Column(name = "limbsTrunk")
	public Short getLimbsTrunk() {
		return this.limbsTrunk;
	}

	public void setLimbsTrunk(Short limbsTrunk) {
		this.limbsTrunk = limbsTrunk;
	}

	@Column(name = "other_problem", length = 50)
	public String getOtherProblem() {
		return this.otherProblem;
	}

	public void setOtherProblem(String otherProblem) {
		this.otherProblem = otherProblem;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}