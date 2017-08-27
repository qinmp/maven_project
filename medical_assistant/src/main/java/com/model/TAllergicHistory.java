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
@Table(name = "t_allergic_history", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TAllergicHistory  extends BaseModel  {

	private static final long serialVersionUID = -7016170992795821751L;
	private Long id;
	private String serialNo;
	private Timestamp createTime;
	//是否有过药物过敏；
	private Integer allergicType;
	//过敏药物名称
	private String allergicMedicineName;
	
	@Transient
	public String getAllergicHistoryFacet(){
		if(allergicType == 1){
			return this.allergicMedicineName + "过敏";
		}else if(allergicType == 2){
			return "否认";
		}
		return "";
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
	@Column(name = "serial_no", nullable = false, length = 32)
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Column(name = "allergic_type")
	public Integer getAllergicType() {
		return allergicType;
	}
	public void setAllergicType(Integer allergicType) {
		this.allergicType = allergicType;
	}
	@Column(name = "allergic_medicine_name")
	public String getAllergicMedicineName() {
		return allergicMedicineName;
	}
	public void setAllergicMedicineName(String allergicMedicineName) {
		this.allergicMedicineName = allergicMedicineName;
	}
}
