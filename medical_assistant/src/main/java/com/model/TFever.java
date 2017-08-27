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
 * TFever entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_fever", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TFever  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = -6295292763053332743L;
	private Long id;
	private String serialNo;
	private Double highestDegree;
	private Double lowestDegree;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public TFever() {
	}

	/** full constructor */
	public TFever(String serialNo, Double highestDegree, Double lowestDegree,
			Timestamp createTime) {
		this.serialNo = serialNo;
		this.highestDegree = highestDegree;
		this.lowestDegree = lowestDegree;
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

	@Column(name = "highest_degree", nullable = false, precision = 22, scale = 0)
	public Double getHighestDegree() {
		return this.highestDegree;
	}

	public void setHighestDegree(Double highestDegree) {
		this.highestDegree = highestDegree;
	}

	@Column(name = "lowest_degree", nullable = false, precision = 22, scale = 0)
	public Double getLowestDegree() {
		return this.lowestDegree;
	}

	public void setLowestDegree(Double lowestDegree) {
		this.lowestDegree = lowestDegree;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}