package com.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Description:基本DAO  包含了对实体T的基本操作：
 * @Copyright: 深圳法大大网络科技有限公司 (c)2016
 * @Created Date : 2016-3-7
 * @author jcf
 * @vesion 2.0
 */
@SuppressWarnings("rawtypes")
public interface BaseDao<T,PK extends Serializable> {
	/**
	 * @Description: 保存实体
	 * @Created: 2012-10-8 下午1:49:13
	 * @Author jcf
	 * @param model
	 */
	void save(T model);
	/**
	 * @Description: 保存或更新实体
	 * @Create: 2016-3-7 下午05:45:13
	 * @author jcf
	 * @update logs
	 * @param model
	 */
	void saveOrUpdate(T model);
	/**
	 * @Description:  删除相应实体
	 * @Created: 2012-10-8 下午1:48:36
	 * @Author jcf
	 * @param model 要删除的实体
	 */
	void delete(T model);
	/**
	 * @Description: 根据主键删除实体
	 * @Create: 2012-10-27 下午2:21:26
	 * @author jcf
	 * @update logs
	 * @param pk
	 * @throws Exception
	 */
	void delete(PK pk);
	/**
	 * @Description: 根据某个属性删除实体
	 * @Create: 2013-11-7 下午03:40:39
	 * @author jcf
	 * @update logs
	 * @param propertyName
	 */
	void delete(String propertyName, Object value);
	/**
	 * 更新相应实体
	 * @param model
	 */
	void update(T model);
	/**
	 * 更新
	 * @param model
	 */
	void update(String sql);
	/**
	 * @Description:  刷新session
	 * @Create: 2012-3-28 下午06:49:59
	 * @author longweier
	 * @update logs
	 * @throws Exception
	 */
	void flush();
	
	/**
	 * @Description: 清除Session
	 * @Create: 2012-3-28 下午06:50:13
	 * @author longweier
	 * @update logs
	 * @throws Exception
	 */
	void clear();
	/**
	 * @Description: 清除某一对象
	 * @Create: 2012-3-28 下午06:50:30
	 * @author longweier
	 * @update logs
	 * @param object 清除对象.
	 * @throws Exception
	 */
	void evict(Object object);
	/**
	 * @Description: 更新相应实体
	 * @Created: 2013-8-22 下午10:49:27
	 * @Author jcf
	 * @param model
	 */
	void merger(T model);
	/**
	 * @Description: 根据id取得model
	 * @Create: 2012-9-17 下午11:27:16
	 * @author jcf
	 * @param id
	 * @return
	 */
	T load(PK id);
	/**
	 * @Description: 根据id取得model
	 * @Create: 2013-2-17 下午2:13:21
	 * @author jcf
	 * @update logs
	 * @param id
	 * @return
	 */
	T get(PK id);
	/**
	 * @Description: 根据某种属性propertyName取得model
	 * @Create: 2012-9-17 下午11:33:29
	 * @author jcf
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
	 * @Description: 查询所有的model
	 * @Create: 2012-12-23 下午10:54:57
	 * @author jcf
	 * @update logs
	 * @return
	 */
	List<T> queryAll();
	/**
	 * @Description: 根据属性orderProperty排序查询出结果
	 * @Created: 2013-8-12 上午10:59:35
	 * @Author jcf
	 * @param orderProperty
	 * @return
	 */
	List<T> queryOrder(String orderProperty);
	/**
	 * @Description: 根据排序查询出结果
	 * @Created: 2013-8-12 上午10:59:35
	 * @Author jcf
	 * @param orderProperty
	 * @return
	 */
	List<T> queryOrder(String orderProperty,Integer orderKind);
	/**
	 * @Description: 根据属性propertyName的model
	 * @Create: 2012-12-23 下午10:58:44
	 * @author jcf
	 * @update logs
	 * @param propertyName
	 * @param value
	 * @return
	 */
	List<T> query(String propertyName, Object value);
	/**
	 * @Description: 根据属性propertyName统计
	 * @Create: 2013-11-2 下午03:20:12
	 * @author jcf
	 * @update logs
	 * @param propertyName
	 * @param value
	 * @return
	 */
	Long count(String propertyName, Object value);
	/**
	 * @Description: 根据属性propertyName查询
	 * @Created: 2013-8-4 上午10:00:51
	 * @author jcf
	 * @update logs
	 * @throws Exception
	 * @param propertyName
	 * @param value
	 * @param orderProperty
	 * @param orderKind 0-desc 1-asc 
	 * @return
	 */
	List<T> queryOrder(String propertyName, Object value,String orderProperty);
	/**
	 * @Description: 查询属性propertyName值为value的model
	 * @Created: 2013-8-4 上午10:00:51
	 * @author jcf
	 * @update logs
	 * @throws Exception
	 * @param propertyName
	 * @param value
	 * @param orderProperty
	 * @param orderKind 0-desc 1-asc 
	 * @return
	 */
	List<T> queryOrder(String propertyName, Object value,String orderProperty,Integer orderKind);
	/**
	 * @Description: 根据多个属性取得Model
	 * @Created Time: 2013-4-18 下午9:23:54
	 * @Author jcf
	 * @param propertyNames
	 * @param values
	 * @return
	 */
	List<T> query(String[] propertyNames, Object[] values);
	/**
	 * @Description: 根据多个属性统计Model
	 * @Create: 2013-11-2 下午03:25:28
	 * @author jcf
	 * @update logs
	 * @param propertyNames
	 * @param values
	 * @return
	 */
	Long count(String[] propertyNames, Object[] values);
	/**
	 * @Description: 根据多个属性取得Model，并按照属性orderProperty的升序查询
	 * @Created: 2013-8-22 下午9:41:39
	 * @Author jcf
	 * @param propertyNames
	 * @param values
	 * @param orderProperty
	 * @return
	 */
	List<T> queryOrder(String[] propertyNames, Object[] values,String orderProperty);
	/**
	 * @Description: 根据多个属性取得Model，并按照属性orderProperty排序orderKind
	 * @Created: 2013-8-22 下午9:41:39
	 * @Author jcf
	 * @param propertyNames
	 * @param values
	 * @param orderProperty
	 * @param orderKind 0-desc 1-asc 
	 * @return
	 */
	List<T> queryOrder(String[] propertyNames, Object[] values,String orderProperty,Integer orderKind);
	/**
	 * @Description: 根据属性取得最大值
	 * @Created: 2013-8-4 上午11:43:38
	 * @author jcf
	 * @update logs
	 * @throws Exception
	 * @param propertyName
	 * @return
	 */
	Object getMax(String maxPropertyName);
	/**
	 * @Description: 限定属性，取得属性
	 * @Created: 2013-8-24 下午9:56:47
	 * @Author jcf
	 * @param propertyName
	 * @param value
	 * @param maxPropertyName
	 * @return
	 */
	Object getMax(String propertyName, Object value, String maxPropertyName);
	/**
	 * @Description: 根据Sql查询对应的结果
	 * @Created Time: 2013-3-14 上午11:02:10
	 * @Author jcf
	 * @param sql
	 * @return
	 */
	List<Map<String,Object>> query(String sql);
	
	/**
	 * @Description: 根据Sql查询对应的结果
	 * @Create: 2016-3-8 下午06:57:08
	 * @author jcf
	 * @update logs
	 * @param sql
	 * @param parameters
	 * @return
	 */
	List<Map<String,Object>> query(String sql,Integer pageSize,Integer pageNo,Map<String, Object> params);
	List queryEntityBySql(String sql,Integer pageSize,Integer pageNo,Map<String, Object> params,Class entity);
	List queryEntityBySql(String sql,Map<String, Object> params,Class entity);
	List queryEntityBySql(String sql,Class entity);
	/**
	 * @Description: 根据Sql统计
	 * @Create: 2016-3-8 下午06:57:35
	 * @author jcf
	 * @update logs
	 * @param sql
	 * @param parameters
	 * @return
	 */
	Long count(String sql,Map<String, Object> params);
	
	/**
	 * @Description: 批量更新
	 * @Create: 2015-12-25 下午03:53:38
	 * @author jcf
	 * @update logs
	 * @param models
	 */
	void batchSaveOrUpdateObj(List<T> models);
	
	/**
	 * @Description: 根据Sql查询对应的结果
	 * @Created Time: 2013-3-14 上午11:02:10
	 * @Author jcf
	 * @param sql
	 * @return
	 */
	List<Map<String,Object>> query(String sql,Map<String, Object> params);
}
