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

import com.bean.enumobj.DizzyTypeEnum;

/**
 * TDizzy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_dizzy", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TDizzy  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = 8776855119463777485L;
	private Long id;
	private String serialNo;
	private Short dizzy;
	private Timestamp createTime;
	private String dizzyFacet;
	
	@Transient
	public String getDizzyFacet() {
		if(DizzyTypeEnum.isCarsicknessOrShipsickness(dizzy.intValue())){
			dizzyFacet = "晕车/船后";
		} else if(DizzyTypeEnum.isSyncope(dizzy.intValue())){
			dizzyFacet = "晕厥";
		} else if(DizzyTypeEnum.isVertigo(dizzy.intValue())){
			dizzyFacet = "眩晕";
		}else{
			dizzyFacet = "";
		}
		return dizzyFacet;
	}

	public void setDizzyFacet(String dizzyFacet) {
		this.dizzyFacet = dizzyFacet;
	}

	/** default constructor */
	public TDizzy() {
	}

	/** full constructor */
	public TDizzy(String serialNo, Short dizzy, Timestamp createTime) {
		this.serialNo = serialNo;
		this.dizzy = dizzy;
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

	@Column(name = "dizzy", nullable = false)
	public Short getDizzy() {
		return this.dizzy;
	}

	public void setDizzy(Short dizzy) {
		this.dizzy = dizzy;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}