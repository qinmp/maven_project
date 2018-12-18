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
@Table(name = "t_blood_transfusion")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TBloodTransfusion  extends BaseModel  {
	private static final long serialVersionUID = 2414649277486843711L;
	private Long id;
	private String serialNo;
	private Timestamp createTime;
	private Integer bloodTransfusionType;//有无输过血
	private Timestamp bloodTransfusionTime;//输血的时间
	private String operationName;//手术名称；
	
	@Transient
	public String getBloodTransfusionFacet(){
		if(this.bloodTransfusionType == 1){
			return DateUtil.dateToString(this.bloodTransfusionTime) + "年输血史";
		} else if(this.bloodTransfusionType == 2){
			return "否认";
		}
		return "";
	}
	
	@Transient
	public String getFormatBloodTransfusionTime(){
		if(this.bloodTransfusionTime != null){
			return DateUtil.dateToString(this.bloodTransfusionTime);
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
	@Column(name = "blood_transfusion_type")
	public Integer getBloodTransfusionType() {
		return bloodTransfusionType;
	}
	public void setBloodTransfusionType(Integer bloodTransfusionType) {
		this.bloodTransfusionType = bloodTransfusionType;
	}
	@Column(name = "blood_transfusion_time")
	public Timestamp getBloodTransfusionTime() {
		return bloodTransfusionTime;
	}
	public void setBloodTransfusionTime(Timestamp bloodTransfusionTime) {
		this.bloodTransfusionTime = bloodTransfusionTime;
	}
	@Column(name = "operation_name")
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	
}
