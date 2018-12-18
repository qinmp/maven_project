package com.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.util.DateUtil;

/**
 * TCough entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_cough")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TCough  extends BaseModel {

	// Fields

	
	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = 537153916623143144L;
	private Long id;
	private String serialNo;
	private Timestamp coughStartTime;
	private Timestamp createTime;
	//急性，亚急性，慢性
	private String presentToUserStr;
	//天数
	private Integer days;

	@Transient
	public Integer getDays() {
		Integer dis =  DateUtil.daysOfTwo(this.coughStartTime, new Date());
		days = dis;
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	@Transient
	public String getPresentToUserStr() {
		Integer dis =  DateUtil.daysOfTwo(this.coughStartTime, new Date());
		if(dis <= 14 && dis >= 0){
			presentToUserStr = "急性";
		}else if(dis > 14 && dis <= (365 * 2)){
			presentToUserStr = "亚急性";
		} else if(dis > (365 * 2)){
			presentToUserStr = "慢性性";
		} else {
			presentToUserStr = "";
		}
		return presentToUserStr;
	}

	public void setPresentToUserStr(String presentToUserStr) {
		this.presentToUserStr = presentToUserStr;
	}

	/** default constructor */
	public TCough() {
	}

	/** full constructor */
	public TCough(String serialNo, Timestamp coughStartTime,
			Timestamp createTime) {
		this.serialNo = serialNo;
		this.coughStartTime = coughStartTime;
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

	@Column(name = "cough_start_time", nullable = false, length = 19)
	public Timestamp getCoughStartTime() {
		return this.coughStartTime;
	}

	public void setCoughStartTime(Timestamp coughStartTime) {
		this.coughStartTime = coughStartTime;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}