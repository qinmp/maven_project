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
@Table(name = "t_operation_history", catalog = "medical_assistant_db")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TOperationHistory  extends BaseModel  {
	private static final long serialVersionUID = -6773945432898884853L;
	private Long id;
	private String serialNo;
	private Timestamp createTime;
	private Integer operationType;
	private Timestamp operationTime;
	private String operationName;
	
	@Transient
	public String getOperationHistoryFacet(){
		
		if(this.operationType == 1){
			return DateUtil.dateToString(this.operationTime) + "做过" + this.operationName + "手术。";
		} else if(this.operationType == 2){
			return "否认";
		}
		return "";
	}
	
	@Transient
	public String getFormatOperationTime(){
		if(this.operationTime != null){
			return DateUtil.dateToString(this.operationTime);
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
	@Column(name = "operation_type")
	public Integer getOperationType() {
		return operationType;
	}
	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}
	@Column(name = "operation_time")
	public Timestamp getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(Timestamp operationTime) {
		this.operationTime = operationTime;
	}
	@Column(name = "operation_name")
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	
}
