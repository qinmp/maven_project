package com.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class BaseModel implements Serializable {

	@Override
	public String toString() {
		return "BaseModel [order=" + order + ", sort=" + sort + ", pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
	}

	private static final long serialVersionUID = -459154537835121547L;
	public enum Order{
		asc,desc
	}
	/**
	 * 排序--asc/desc 非数据库字段
	 */
	private String order;
	/**
	 * 排序字段 非数据库字段
	 */
	private String sort;
	
	private Integer pageNo = 1;
	private Integer pageSize = 20;

	@Transient
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Transient
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	@Transient
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	@Transient
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
