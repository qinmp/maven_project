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
 * TOliguresis entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_oliguresis")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TOliguresis  extends BaseModel {

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = -6773945432898884853L;
	// Fields

	private Long id;
	private String serialNo;
	private Integer updSymptom;
	private Timestamp createTime;
	

	// Constructors

	/** default constructor */
	public TOliguresis() {
	}

	/** full constructor */
	public TOliguresis(String serialNo, Integer updSymptom, Timestamp createTime) {
		this.serialNo = serialNo;
		this.updSymptom = updSymptom;
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
	public Integer getUpdSymptom() {
		return this.updSymptom;
	}

	public void setUpdSymptom(Integer updSymptom) {
		this.updSymptom = updSymptom;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}