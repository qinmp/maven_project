package com.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * BasicInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_main_suit"
    ,catalog="medical_assistant_db"
)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class MainSuit extends BaseModel  {

     
	@Override
	public String toString() {
		return "MainSuit [id=" + id + ", serialNo=" + serialNo + ", mainSuitContent=" + mainSuitContent
				+ ", mainSuitValue=" + mainSuitValue + ", attackTime=" + attackTime + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", accountId=" + accountId + "]";
	}


	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = -1943462596608579215L;
	private Long id;
     private String serialNo;
     private String mainSuitContent;
     private Integer mainSuitValue;
     private Timestamp attackTime;
     private Timestamp createTime;
     private Timestamp updateTime;
     private Long accountId;

    // Constructors

    /** default constructor */
    public MainSuit() {
    }

    
    // Property accessors
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="serial_no", nullable=false, length=32)

    public String getSerialNo() {
        return this.serialNo;
    }
    
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
    
    @Column(name="main_suit_content", nullable=false, length=32)
    public String getMainSuitContent() {
		return mainSuitContent;
	}


	public void setMainSuitContent(String mainSuitContent) {
		this.mainSuitContent = mainSuitContent;
	}

    
    @Column(name="attack_time", nullable=false, length=19)
    public Timestamp getAttackTime() {
		return attackTime;
	}


	public void setAttackTime(Timestamp attackTime) {
		this.attackTime = attackTime;
	}
    
    @Column(name="main_suit_value", nullable=false)
    public Integer getMainSuitValue() {
		return mainSuitValue;
	}


	public void setMainSuitValue(Integer mainSuitValue) {
		this.mainSuitValue = mainSuitValue;
	}
	
    @Column(name="create_time", nullable=false, length=19)
    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
	public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="update_time", nullable=false, length=19)
    public Timestamp getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name="account_id")
	public Long getAccountId() {
		return accountId;
	}


	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

}