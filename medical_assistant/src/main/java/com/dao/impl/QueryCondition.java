// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   QueryCondition.java

package com.dao.impl;

import java.util.Map;
import org.hibernate.Query;

/**
 * <h3>概要:</h3> 
 *    定义查询条件接口
 * <br>
 * <h3>功能:</h3>
 * <ol>
 * 		<li>TODO(这里用一句话描述功能点)</li>
 * </ol>
 * <h3>履历:</h3>
 * <ol>
 * 		<li>2015-1-21[suxh] 新建</li>
 * </ol>
 */
public interface QueryCondition {

	public abstract String getBaseHql();

	public abstract void setBaseHql(String s);

	public abstract String getCountHql();

	public abstract void setCountHql(String s);

	public abstract String getPrepareHql();

	public abstract void setPrepareHql(String s);

	@SuppressWarnings({ "rawtypes" })
	public abstract void setParameters(Map map);

	/**
	 * <b>概要：</b>
	 * 	设置query对象的属性
	 * <b>作者：</b>suxh </br>
	 * <b>日期：</b>2015-1-21 </br>
	 * @param query query对象
	 */
	public abstract void launchParamValues(Query query);
}
