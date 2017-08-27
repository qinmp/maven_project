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

import com.bean.enumobj.VomitEnum;

/**
 * TVomit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_vomit", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TVomit  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = -2765689191469931735L;
	private Long id;
	private String serialNo;
	private Short vomitType;
	private Timestamp createTime;
	private String vomitFacet;
	
	@Transient
	public String getVomitFacet() {
		if(VomitEnum.isAfterCarsickOrSeasickVomit(vomitType.intValue())){
			vomitFacet = VomitEnum.AfterCarsickOrSeasickVomit.getValueInFact();
		} else if(VomitEnum.isOtherTypeVomit(vomitType.intValue())){
			vomitFacet = VomitEnum.OtherTypeVomit.getValueInFact();
		}else{
			vomitFacet = "";
		}
		return vomitFacet;
	}

	public void setVomitFacet(String vomitFacet) {
		this.vomitFacet = vomitFacet;
	}

	/** default constructor */
	public TVomit() {
	}

	/** full constructor */
	public TVomit(String serialNo, Short vomitType, Timestamp createTime) {
		this.serialNo = serialNo;
		this.vomitType = vomitType;
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

	@Column(name = "vomit_type", nullable = false)
	public Short getVomitType() {
		return this.vomitType;
	}

	public void setVomitType(Short vomitType) {
		this.vomitType = vomitType;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}