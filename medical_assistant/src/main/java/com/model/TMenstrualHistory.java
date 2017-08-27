package com.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.util.DateUtil;

@Entity
@Table(name = "t_menstrual_history", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TMenstrualHistory  extends BaseModel  {
	private static final long serialVersionUID = -6773945432898884853L;
	private Long id;
	private String serialNo;
	private Timestamp createTime;
	//上次来月经日期
	private Timestamp lastMenstrualPeriod;
	//第一次月经年龄;1-30岁
	private Integer firstMenstrualAge;
	//月经多少天;1-30天
	private Integer howManyDayMenstrual;
	//两次月经间隔(1-30天)
	private Integer twoMenstrualIntervals;
	
	@Transient
	public String getLastMenstrualPeriodFormat(){
		return DateUtil.dateToString(lastMenstrualPeriod);
	}
	
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
	@Column(name = "last_menstrual_period")
	public Timestamp getLastMenstrualPeriod() {
		return lastMenstrualPeriod;
	}
	public void setLastMenstrualPeriod(Timestamp lastMenstrualPeriod) {
		this.lastMenstrualPeriod = lastMenstrualPeriod;
	}
	@Column(name = "first_menstrual_age")
	public Integer getFirstMenstrualAge() {
		return firstMenstrualAge;
	}
	public void setFirstMenstrualAge(Integer firstMenstrualAge) {
		this.firstMenstrualAge = firstMenstrualAge;
	}
	@Column(name = "how_many_day_menstrual")
	public Integer getHowManyDayMenstrual() {
		return howManyDayMenstrual;
	}
	public void setHowManyDayMenstrual(Integer howManyDayMenstrual) {
		this.howManyDayMenstrual = howManyDayMenstrual;
	}
	@Column(name = "two_menstrual_intervals")
	public Integer getTwoMenstrualIntervals() {
		return twoMenstrualIntervals;
	}
	public void setTwoMenstrualIntervals(Integer twoMenstrualIntervals) {
		this.twoMenstrualIntervals = twoMenstrualIntervals;
	}
}
