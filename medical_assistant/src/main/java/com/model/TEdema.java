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
 * TEdema entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_edema", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TEdema  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = 1817028798092821854L;
	private Long id;
	private String serialNo;
	private String name;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public TEdema() {
	}

	/** full constructor */
	public TEdema(String serialNo, String name, Timestamp createTime) {
		this.serialNo = serialNo;
		this.name = name;
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

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}