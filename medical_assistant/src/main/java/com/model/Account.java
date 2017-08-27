package com.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "t_account", uniqueConstraints =  {@UniqueConstraint(columnNames = "account")})
public class Account  implements Serializable {

	private final static Set<String> ADMIN_ACCOUNTS = new HashSet<String>();
	static {
		ADMIN_ACCOUNTS.add("18818212341");
		ADMIN_ACCOUNTS.add("OO");
	}
	public static boolean isContainAdminAccount(String account){
		return ADMIN_ACCOUNTS.contains(account);
	}
	/**
	 * 用户登录Id
	 */
	public static final String LOGIN_ACCOUNT_ID = "loginAccountId";
	public static final String LOGIN_ACCOUNT_ACCOUNT = "loginAccountAccount";
	public static final String CURRENT_SERIALNO = "currentSerialNo";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5228046410953157123L;
	
	private Long id;
	/** 账户 */
	private String account;
	/** 用户名 */
	private String name;
	/** 电话号码 */
	private String tel;
	/** 密码 */
	private String password;
	/** 邮箱 */
	private String email;
	/** 创建时间 */
	private Timestamp createTime;
	/** 是否启用 */
	private Integer isDelete;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "account", unique = true, nullable = false, length = 100)
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "tel")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "creat_time")
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "is_delete")
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", account=" + account + ", name=" + name + ", tel=" + tel + ", password="
				+ password + ", email=" + email + ", createTime=" + createTime + ", isDelete=" + isDelete + "]";
	}
	
}
