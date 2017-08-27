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

import com.bean.enumobj.HematocheziaColorEnum;

/**
 * THematochezia entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_hematochezia", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class THematochezia  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = -6236613999919688432L;
	private Long id;
	private String serialNo;
	private Short hematocheziaColor;
	private Timestamp createTime;
	private String hematocheziaFacet;
	private String noticeStr;

	@Transient
	public String getNoticeStr() {
		if(HematocheziaColorEnum.isDullRed(hematocheziaColor.intValue())){
			noticeStr = "";
		} else if(HematocheziaColorEnum.isBrightRed(hematocheziaColor.intValue())){
			noticeStr = "温馨提示: 请到医院肛肠外科就诊";
		} else {
			noticeStr = "";
		}
		return noticeStr;
	}

	public void setNoticeStr(String noticeStr) {
		this.noticeStr = noticeStr;
	}

	@Transient
	public String getHematocheziaFacet() {
		if(HematocheziaColorEnum.isDullRed(hematocheziaColor.intValue())){
			hematocheziaFacet = "暗红色";
		} else if(HematocheziaColorEnum.isBrightRed(hematocheziaColor.intValue())){
			hematocheziaFacet = "鲜红色";
		} else {
			hematocheziaFacet = "";
		}
		return hematocheziaFacet;
	}

	public void setHematocheziaFacet(String hematocheziaFacet) {
		this.hematocheziaFacet = hematocheziaFacet;
	}

	/** default constructor */
	public THematochezia() {
	}

	/** full constructor */
	public THematochezia(String serialNo, Short hematocheziaColor,
			Timestamp createTime) {
		this.serialNo = serialNo;
		this.hematocheziaColor = hematocheziaColor;
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

	@Column(name = "hematochezia_color", nullable = false)
	public Short getHematocheziaColor() {
		return this.hematocheziaColor;
	}

	public void setHematocheziaColor(Short hematocheziaColor) {
		this.hematocheziaColor = hematocheziaColor;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}