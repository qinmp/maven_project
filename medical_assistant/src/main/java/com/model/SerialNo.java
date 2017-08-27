package com.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_serialno")
public class SerialNo  implements Serializable {

	@Override
	public String toString() {
		return "SerialNo [id=" + id + ", serialNo=" + serialNo + ", creatTime=" + creatTime + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 5228046410953157123L;
	
	private Long id;
	/** 序列号 */
	private Long serialNo;
	/** 创建时间 */
	private Timestamp creatTime ;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "serial_no")
	public Long getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}
	
	@Column(name = "create_time")
	public Timestamp getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}
	
}
