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

import com.bean.enumobj.MicturitionRelatedSymptomsTypeEnum;

/**
 * TMicturition entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_micturition", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TMicturition  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = 8665385141429488266L;
	private Long id;
	private String serialNo;
	private Short micturitionSymptom;
	private Timestamp createTime;
	private String micturitionSymptomFacet;

	@Transient
	public String getMicturitionSymptomFacet() {
		micturitionSymptomFacet = MicturitionRelatedSymptomsTypeEnum.convertByValue(micturitionSymptom.intValue()).getValueInFact();
		return micturitionSymptomFacet;
	}

	public void setMicturitionSymptomFacet(String micturitionSymptomFacet) {
		this.micturitionSymptomFacet = micturitionSymptomFacet;
	}

	/** default constructor */
	public TMicturition() {
	}

	/** full constructor */
	public TMicturition(String serialNo, Short micturitionSymptom,
			Timestamp createTime) {
		this.serialNo = serialNo;
		this.micturitionSymptom = micturitionSymptom;
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

	@Column(name = "micturition_symptom", nullable = false)
	public Short getMicturitionSymptom() {
		return this.micturitionSymptom;
	}

	public void setMicturitionSymptom(Short micturitionSymptom) {
		this.micturitionSymptom = micturitionSymptom;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}