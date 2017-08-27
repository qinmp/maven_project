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

import com.bean.enumobj.ExpectorationEnum;

/**
 * TExpectoration entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_expectoration", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TExpectoration  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = 5090437577804089880L;
	private Long id;
	private String serialNo;
	private Short expectorationColor;
	private Timestamp createTime;
	private String colorFacet;
	
	@Transient
	public String getColorFacet() {
		if(ExpectorationEnum.isBloodysputum(this.expectorationColor.intValue())){
			colorFacet = ExpectorationEnum.Bloodysputum.getValueInFact();
		} else if(ExpectorationEnum.isWhiteColor(this.expectorationColor.intValue())){
			colorFacet = ExpectorationEnum.WhiteColor.getValueInFact();
		} else if(ExpectorationEnum.isYellowColor(this.expectorationColor.intValue())){
			colorFacet = ExpectorationEnum.YellowColor.getValueInFact();
		}else{
			colorFacet = "";
		}
		return colorFacet;
	}

	public void setColorFacet(String colorFacet) {
		this.colorFacet = colorFacet;
	}

	/** default constructor */
	public TExpectoration() {
	}

	/** full constructor */
	public TExpectoration(String serialNo, Short expectorationColor,
			Timestamp createTime) {
		this.serialNo = serialNo;
		this.expectorationColor = expectorationColor;
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

	@Column(name = "expectoration_color", nullable = false)
	public Short getExpectorationColor() {
		return this.expectorationColor;
	}

	public void setExpectorationColor(Short expectorationColor) {
		this.expectorationColor = expectorationColor;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}