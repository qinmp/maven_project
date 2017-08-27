// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CommQueryCondition.java

package com.dao.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.Query;

public class CommQueryCondition implements QueryCondition {
	/** 查询的条件(key对应javabean的属性，value为属性值) */
	protected Map<String, Object> conditions;

	/** 查询的计数的hql语句 */
	protected String countHql;

	/** 预定义查询列表的hql语句 */
	protected String prepareHql;

	/**
	 * 概要：CommQueryCondition类的构造函数
	 */
	public CommQueryCondition() {
		conditions = new HashMap<String, Object>();
		countHql = null;
		prepareHql = null;
	}

	public String getBaseHql() {
		return null;
	}

	public void setBaseHql(String s) {
	}

	public String getCountHql() {
		return countHql;
	}

	public void setCountHql(String countHql) {
		this.countHql = countHql;
	}

	public String getPrepareHql() {
		return prepareHql;
	}

	public void setPrepareHql(String prepareSql) {
		prepareHql = prepareSql;
	}

	@SuppressWarnings({ "rawtypes" })
	public void setParameters(Map map) {
	}
	
	public Map<String, Object> getConditions() {
		return conditions;
	}

	public void setConditions(Map<String, Object> conditions) {
		if (conditions != null)
			this.conditions = conditions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yq365.web.comm.QueryCondition#launchParamValues(org.hibernate.Query)
	 */
	@SuppressWarnings({ "rawtypes" })
	public void launchParamValues(Query query) {
		if (conditions != null) {
			for (Iterator it = conditions.keySet().iterator(); it.hasNext();) {
				String name = (String) it.next();
				Object value = conditions.get(name);
				if (value instanceof String) {
					if ("keyword".equals(name)) {// 关键字 统一用keyword
						query.setString(name, '%' + (String) value + '%');
					} else if ("before_keyword".equals(name)) {
						query.setString(name, '%' + (String) value);
					} else if ("after_keyword".equals(name)) {
						query.setString(name, (String) value + '%');
					} else {
						query.setString(name, (String) value);
					}
				} else if (value instanceof Integer)
					query.setInteger(name, ((Integer) value).intValue());
				else if (value instanceof Long)
					query.setLong(name, ((Long) value).longValue());
				else if (value instanceof Float)
					query.setFloat(name, ((Float) value).floatValue());
				else if (value instanceof Double)
					query.setDouble(name, ((Double) value).doubleValue());
				else if (value instanceof Timestamp)
					query.setTimestamp(name, (Timestamp) value);
				else if (value instanceof Date)
					query.setDate(name, (Date) value);
				else if (value instanceof Collection)
					query.setParameterList(name, (Collection) value);
				else if (value instanceof Object[])
					query.setParameterList(name, (Object[]) value);
				else
					query.setParameter(name, value);
			}
		}

	}
	
}
