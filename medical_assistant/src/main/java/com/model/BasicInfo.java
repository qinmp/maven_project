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


/**
 * BasicInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_basic_info"
)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class BasicInfo implements java.io.Serializable {


     
	@Override
	public String toString() {
		return "BasicInfo [id=" + id + ", serialNo=" + serialNo + ", name=" + name + ", realBirthDay=" + realBirthDay
				+ ", age=" + age + ", sex=" + sex + ", nativePlace=" + nativePlace + ", presentResidence="
				+ presentResidence + ", createTime=" + createTime + ", updateTime=" + updateTime + ", accountId="
				+ accountId + "]";
	}

	/** serialVersionUID:TODO */   
	
	private static final long serialVersionUID = -1943462596608579215L;
	private Long id;
     private String serialNo;
     private String name;
     private Timestamp realBirthDay;
     private String age;
     private Integer sex;
     private String nativePlace;
     private String presentResidence;
     private Timestamp createTime;
     private Timestamp updateTime;
     private Long accountId;

    // Constructors

    /** default constructor */
    public BasicInfo() {
    }

    
    /** full constructor */
    public BasicInfo(String serialNo, String name, Timestamp realBirthDay, String age, Integer sex, String nativePlace, String presentResidence, Timestamp createTime, Timestamp updateTime) {
        this.serialNo = serialNo;
        this.name = name;
        this.realBirthDay = realBirthDay;
        this.age = age;
        this.sex = sex;
        this.nativePlace = nativePlace;
        this.presentResidence = presentResidence;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
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
    
    @Column(name="name", nullable=false, length=32)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="real_birth_day", nullable=false, length=19)

    public Timestamp getRealBirthDay() {
        return this.realBirthDay;
    }
    
    public void setRealBirthDay(Timestamp realBirthDay) {
        this.realBirthDay = realBirthDay;
    }
    
    @Column(name="age", nullable=false)

    public String getAge() {
        return this.age;
    }
    
    public void setAge(String age) {
        this.age = age;
    }
    
    @Column(name="sex", nullable=false)

    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    
    @Column(name="native_place", nullable=false, length=100)

    public String getNativePlace() {
        return this.nativePlace;
    }
    
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
    
    @Column(name="present_residence", nullable=false, length=100)

    public String getPresentResidence() {
        return this.presentResidence;
    }
    
    public void setPresentResidence(String presentResidence) {
        this.presentResidence = presentResidence;
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
   
	@Transient
	public String getSexContent(){
		if(this.sex == 0){
			return "男";
		} else {
			return "女";
		}
	}

}