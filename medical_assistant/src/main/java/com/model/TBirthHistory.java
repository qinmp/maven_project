package com.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "t_birth_history", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TBirthHistory  extends BaseModel  {
	private static final long serialVersionUID = -6773945432898884853L;
	private Long id;
	private String serialNo;
	private Timestamp createTime;
	//怀孕过几次；
	private Integer howManyTimesPregnant;
	//分娩过几次
	private Integer howManyTimesDelivered;
	
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
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	@Column(name = "create_time")
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Column(name = "how_many_times_pregnant")
	public Integer getHowManyTimesPregnant() {
		return howManyTimesPregnant;
	}
	public void setHowManyTimesPregnant(Integer howManyTimesPregnant) {
		this.howManyTimesPregnant = howManyTimesPregnant;
	}
	@Column(name = "how_many_times_delivered")
	public Integer getHowManyTimesDelivered() {
		return howManyTimesDelivered;
	}
	public void setHowManyTimesDelivered(Integer howManyTimesDelivered) {
		this.howManyTimesDelivered = howManyTimesDelivered;
	}
	
}
