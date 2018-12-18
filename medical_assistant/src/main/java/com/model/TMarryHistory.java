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

@Entity
@Table(name = "t_marry_history")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TMarryHistory  extends BaseModel  {
	private static final long serialVersionUID = -6773945432898884853L;
	private Long id;
	private String serialNo;
	private Timestamp createTime;
	private Integer marry_type;
	
	@Transient
	public String getMarryTypeFacet(){
		if(null != marry_type){
			if(marry_type == 1){
				return "已婚";
			} else if(marry_type == 2){
				return "未婚";
			}else{
				return "";
			}
		}else{
			return "";
		}
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
	@Column(name = "marry_type")
	public Integer getMarry_type() {
		return marry_type;
	}
	public void setMarry_type(Integer marry_type) {
		this.marry_type = marry_type;
	}
	
}
