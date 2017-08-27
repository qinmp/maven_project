package com.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, PK extends Serializable> {
	/**
	 * 根据ID获取实体对象.
	 * 
	 * @param id
	 *            记录ID
	 * @return 实体对象
	 */
	T load(PK id);
	/**
	 * 根据ID获取实体对象.
	 * 
	 * @param id
	 *            记录ID
	 * @return 实体对象
	 */
	T get(PK id);

	/**
	 * @Description: 根据某种属性propertyName取得model
	 * @Create: 2013-9-28 下午9:25:22
	 * @author jcf
	 * @update logs
	 * @param propertyName
	 * @param value
	 * @return
	 */
	T load(String propertyName, Object value);

	/**
	 * @Description: 根据多个属性propertyNames取得Model
	 * @Created: 2013-8-22 下午10:50:07
	 * @Author jcf
	 * @param propertyNames
	 * @param values
	 * @return
	 */
	T load(String[] propertyNames, Object[] values);

	/**
	 * @Description: 查询所有的T
	 * @Created: 2013-9-22 下午9:49:35
	 * @Author jcf
	 * @return
	 */
	List<T> queryAll();

	/**
	 * @Description: 根据属性orderProperty排序查询出结果（默认升序）
	 * @Created: 2013-8-12 上午10:59:35
	 * @Author jcf
	 * @param orderProperty
	 * @return
	 */
	List<T> queryOrder(String orderProperty);

	/**
	 * @Description: 根据属性propertyName查询
	 * @Created: 2013-8-4 上午10:00:51
	 * @author jcf
	 * @update logs
	 * @throws Exception
	 * @param propertyName
	 * @param value
	 * @param orderProperty
	 * @param orderKind
	 *            0-desc 1-asc
	 * @return
	 */
	List<T> queryOrder(String propertyName, Object value, String orderProperty);

	/**
	 * @Description: 根据属性propertyNames查询
	 * @Created: 2013-8-4 上午10:00:51
	 * @author jcf
	 * @update logs
	 * @throws Exception
	 * @param propertyNames
	 * @param value
	 * @param orderProperty
	 * @param orderKind
	 *            0-desc 1-asc
	 * @return
	 */
	List<T> queryOrder(String[] propertyNames, Object[] values, String orderProperty);

	/**
	 * @Description: 根据属性propertyNames查询
	 * @Created: 2013-8-4 上午10:00:51
	 * @author jcf
	 * @update logs
	 * @throws Exception
	 * @param propertyNames
	 * @param value
	 * @param orderProperty
	 * @param orderKind
	 *            0-desc 1-asc
	 * @return
	 */
	List<T> queryOrder(String[] propertyNames, Object[] values, String orderProperty, Integer orderKind);

	/**
	 * @Description: 保存
	 * @Create: 2014-5-12 下午4:01:26
	 * @author jcf
	 * @update logs
	 * @param t
	 */
	void save(T t);
	/**
	 * @Description: 更新
	 * @Create: 2016年12月15日 下午7:32:52
	 * @author jcf
	 * @update logs
	 * @param t
	 */
	void update(T t);
	
	void saveOrUpdate(T t);

	void delete(String propertyName, Object value);
	
	void delete(T model);
	
	/**
	 * @Description: 刷新session
	 * @Create: 2012-3-28 下午06:49:59
	 * @author longweier
	 * @update logs
	 * @throws Exception
	 */
	void flush();
	
	/**
	 * @Description: 根据一个条件统计
	 * @Create: 2015-12-30 上午01:18:58
	 * @author jcf
	 * @update logs
	 * @param propertyName
	 * @param value
	 * @return
	 */
	Long count(String propertyName, Object value);
	
	/**
	 * @Description: 多个条件统计
	 * @Create: 2015-12-30 上午01:20:03
	 * @author jcf
	 * @update logs
	 * @param propertyNames
	 * @param values
	 * @return
	 */
	Long count(String[] propertyNames, Object[] values);
}
