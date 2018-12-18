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

import com.bean.enumobj.OtherUDPSymtomTypeEnum;

/**
 * TOtherUpdSymptom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_other_upd_symptom")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TOtherUpdSymptom  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = -4744439122208974983L;
	private Long id;
	private String serialNo;
	private Short updSymptom;
	private Integer diuresisUpd;
	private Integer anuriaUpd;
	private Timestamp createTime;
	private String updSymptomFacet;

	@Transient
	public String getUpdSymptomFacet() {
		this.updSymptomFacet = OtherUDPSymtomTypeEnum.convertByValue(updSymptom.intValue()).getValueInFact();
		return updSymptomFacet;
	}

	public void setUpdSymptomFacet(String updSymptomFacet) {
		this.updSymptomFacet = updSymptomFacet;
	}

	/** default constructor */
	public TOtherUpdSymptom() {
	}

	/** minimal constructor */
	public TOtherUpdSymptom(String serialNo, Short updSymptom,
			Timestamp createTime) {
		this.serialNo = serialNo;
		this.updSymptom = updSymptom;
		this.createTime = createTime;
	}

	/** full constructor */
	public TOtherUpdSymptom(String serialNo, Short updSymptom,
			Integer diuresisUpd, Integer anuriaUpd, Timestamp createTime) {
		this.serialNo = serialNo;
		this.updSymptom = updSymptom;
		this.diuresisUpd = diuresisUpd;
		this.anuriaUpd = anuriaUpd;
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

	@Column(name = "UPD_symptom", nullable = false)
	public Short getUpdSymptom() {
		return this.updSymptom;
	}

	public void setUpdSymptom(Short updSymptom) {
		this.updSymptom = updSymptom;
	}

	@Column(name = "diuresis_UPD")
	public Integer getDiuresisUpd() {
		return this.diuresisUpd;
	}

	public void setDiuresisUpd(Integer diuresisUpd) {
		this.diuresisUpd = diuresisUpd;
	}

	@Column(name = "anuria_UPD")
	public Integer getAnuriaUpd() {
		return this.anuriaUpd;
	}

	public void setAnuriaUpd(Integer anuriaUpd) {
		this.anuriaUpd = anuriaUpd;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}