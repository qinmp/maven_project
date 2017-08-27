package com.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.dao.BaseDao;

/**
 * @Description:基本DAO 包含了对实体T的基本操作：增 save 删 delete 改 update 分页查询 get和count
 * @Copyright: 深圳法大大网络科技有限公司 (c)2016
 * @Created Date : 2016-3-7
 * @author jcf
 * @vesion 2.0
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class BaseDAOImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

	@Resource
	protected SessionFactory sessionFactory;

	private Class<T> entityClass;

	public BaseDAOImpl() {
		this.entityClass = null;
		Class c = getClass();
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
			this.entityClass = (Class<T>) parameterizedType[0];
		}
	}

	/**
	 * @Description: 取得当前的Session
	 * @Create: 2012-10-14 下午10:34:18
	 * @author jcf
	 * @update logs
	 * @return
	 * @throws Exception
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 保存相应实体
	 * 
	 * @param model
	 */
	@Override
	public void save(T model) {
		getCurrentSession().save(model);
	}

	@Override
	public void saveOrUpdate(T model) {
		getCurrentSession().saveOrUpdate(model);
	}

	/**
	 * 删除相应实体
	 * 
	 * @param model
	 */
	@Override
	public void delete(T model) {
		getCurrentSession().delete(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.linys.dao.BaseDAO#delete(java.io.Serializable)
	 */
	@Override
	public void delete(PK pk) {
		T t = load(pk);
		delete(t);
	}

	@Override
	public void delete(String propertyName, Object value) {
		List<T> tList = query(propertyName, value);
		for (T t : tList) {
			delete(t);
		}
	}

	/**
	 * 更新相应实体
	 * 
	 * @param model
	 */
	@Override
	public void update(T model) {
		getCurrentSession().update(model);
	}

	/**
	 * 更新
	 * 
	 * @param model
	 */
	@Override
	public void update(String sql) {
		Query query = getCurrentSession().createSQLQuery(sql);
		query.executeUpdate();
	}

	/**
	 * 刷新session
	 */
	@Override
	public void flush() {
		getCurrentSession().flush();
	}

	/**
	 * 清空session
	 */
	@Override
	public void clear() {
		getCurrentSession().clear();
	}

	/**
	 * 移除相应实体
	 * 
	 * @param model
	 */
	@Override
	public void evict(Object object) {
		if (object != null) {
			getCurrentSession().evict(object);
		}
	}

	/**
	 * 更新相应实体
	 * 
	 * @param model
	 */
	@Override
	public void merger(T model) {
		getCurrentSession().merge(model);
	}

	@Override
	public T load(PK id) {
		return (T) getCurrentSession().load(entityClass, id);
	}

	@Override
	public T get(PK id) {
		return (T) getCurrentSession().get(entityClass, id);
	}

	@Override
	public T load(String propertyName, Object value) {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		criteria.add(Restrictions.eq(propertyName, value));
		Cache cache = entityClass.getAnnotation(Cache.class);
		if (cache != null) {
			criteria.setCacheable(true);
		} else {
			criteria.setCacheable(false);
		}
		List<T> list = criteria.list();
		return (list.size() == 0 ? null : list.get(0));
	}

	@Override
	public T load(String[] paramNames, Object[] values) {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		for (int i = 0; i < paramNames.length; i++) {
			String propertyName = paramNames[i];
			Object value = values[i];
			criteria.add(Restrictions.eq(propertyName, value));
		}
		Cache cache = entityClass.getAnnotation(Cache.class);
		if (cache != null) {
			criteria.setCacheable(true);
		} else {
			criteria.setCacheable(false);
		}
		List<T> list = criteria.list();
		return (list.size() == 0 ? null : list.get(0));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.linys.dao.BaseDAO#queryAll()
	 */
	@Override
	public List<T> queryAll() {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		Cache cache = entityClass.getAnnotation(Cache.class);
		if (cache != null) {
			criteria.setCacheable(true);
		} else {
			criteria.setCacheable(false);
		}
		return criteria.list();
	}

	@Override
	public List<T> queryOrder(String orderProperty) {
		return queryOrder(orderProperty, 1);
	}

	@Override
	public List<T> queryOrder(String orderProperty, Integer orderKind) {
		return queryOrder(null, 1, orderProperty, orderKind);
	}

	@Override
	public List<T> query(String propertyName, Object value) {
		return queryOrder(propertyName, value, null, 1);
	}

	@Override
	public Long count(String propertyName, Object value) {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		if (propertyName != null) {// 属性
			criteria.add(Restrictions.eq(propertyName, value));
		}
		criteria.setProjection(Projections.rowCount());
		return new Long(criteria.uniqueResult().toString());
	}

	@Override
	public List<T> queryOrder(String propertyName, Object value, String orderProperty) {
		return queryOrder(propertyName, value, orderProperty, 1);
	}

	public List<T> queryOrder(String propertyName, Object value, String orderProperty, Integer orderKind) {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		if (propertyName != null) {// 属性
			criteria.add(Restrictions.eq(propertyName, value));
		}
		if (orderProperty != null) {// 排序属性
			if (orderKind == 0) {
				criteria.addOrder(Order.desc(orderProperty));
			} else if (orderKind == 1) {
				criteria.addOrder(Order.asc(orderProperty));
			}
		}
		Cache cache = entityClass.getAnnotation(Cache.class);
		if (cache != null) {
			criteria.setCacheable(true);
		} else {
			criteria.setCacheable(false);
		}
		return criteria.list();
	}

	@Override
	public List<T> query(String[] propertyNames, Object[] values) {
		return queryOrder(propertyNames, values, null, 1);
	}

	@Override
	public Long count(String[] propertyNames, Object[] values) {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		for (int i = 0; i < propertyNames.length; i++) {
			criteria.add(Restrictions.eq(propertyNames[i], values[i]));
		}
		criteria.setProjection(Projections.rowCount());
		return new Long(criteria.uniqueResult().toString());
	}

	@Override
	public List<T> queryOrder(String[] propertyNames, Object[] values, String orderProperty) {
		return queryOrder(propertyNames, values, orderProperty, 1);
	}

	@Override
	public List<T> queryOrder(String[] propertyNames, Object[] values, String orderProperty, Integer orderKind) {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		for (int i = 0; i < propertyNames.length; i++) {
			criteria.add(Restrictions.eq(propertyNames[i], values[i]));
		}
		if (orderProperty != null) {
			if (orderKind == 0) {
				criteria.addOrder(Order.desc(orderProperty));
			} else if (orderKind == 1) {
				criteria.addOrder(Order.asc(orderProperty));
			}
		}
		Cache cache = entityClass.getAnnotation(Cache.class);
		if (cache != null) {
			criteria.setCacheable(true);
		} else {
			criteria.setCacheable(false);
		}
		return criteria.list();
	}

	@Override
	public Object getMax(String maxPropertyName) {
		return getMax(null, null, maxPropertyName);
	}

	@Override
	public Object getMax(String propertyName, Object value, String maxPropertyName) {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		if (propertyName != null) {// 属性
			criteria.add(Restrictions.eq(propertyName, value));
		}
		return criteria.setProjection(Projections.max(maxPropertyName)).uniqueResult();
	}

	@Override
	public List<Map<String, Object>> query(String sql) {
		return getCurrentSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@Override
	public void batchSaveOrUpdateObj(List<T> list) {
		for (T t : list) {
			getCurrentSession().saveOrUpdate(t);
		}
	}

	@Override
	public Long count(String sql, Map<String, Object> params) {
		CommQueryCondition mqc = new CommQueryCondition();
		mqc.setCountHql(sql);
		mqc.setConditions(params);
		SQLQuery countSqlQuery = getCurrentSession().createSQLQuery(mqc.getCountHql());
		mqc.launchParamValues(countSqlQuery);
		Long totalCount = new Long(countSqlQuery.uniqueResult().toString());// 统计总的条数
		return totalCount;
	}

	@Override
	public List<Map<String, Object>> query(String sql, Integer pageSize, Integer pageNo, Map<String, Object> params) {
		CommQueryCondition mqc = new CommQueryCondition();
		mqc.setPrepareHql(sql);
		mqc.setConditions(params);
		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(sql);// 查询列表语句对象
		mqc.launchParamValues(sqlQuery);// 根据parameters设置参数值
		sqlQuery.setFirstResult((pageNo - 1) * pageSize);
		sqlQuery.setMaxResults(pageSize);
		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return sqlQuery.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fdd.dao.BaseDAO#query(java.lang.String, java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> query(String sql, Map<String, Object> params) {
		CommQueryCondition mqc = new CommQueryCondition();
		mqc.setPrepareHql(sql);
		mqc.setConditions(params);
		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(sql);// 查询列表语句对象
		mqc.launchParamValues(sqlQuery);// 根据parameters设置参数值
		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return sqlQuery.list();
	}

	@Override
	public List queryEntityBySql(String sql, Integer pageSize, Integer pageNo, Map<String, Object> params, Class entity) {
		CommQueryCondition mqc = new CommQueryCondition();
		mqc.setPrepareHql(sql);
		mqc.setConditions(params);
		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(sql);// 查询列表语句对象
		mqc.launchParamValues(sqlQuery);// 根据parameters设置参数值
		sqlQuery.setFirstResult((pageNo - 1) * pageSize);
		sqlQuery.setMaxResults(pageSize);
		sqlQuery.setResultTransformer(Transformers.aliasToBean(entity));
		return sqlQuery.list();
	}
	
	@Override
	public List queryEntityBySql(String sql, Map<String, Object> params, Class entity) {
		CommQueryCondition mqc = new CommQueryCondition();
		mqc.setPrepareHql(sql);
		mqc.setConditions(params);
		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(sql);// 查询列表语句对象
		mqc.launchParamValues(sqlQuery);// 根据parameters设置参数值
		sqlQuery.setResultTransformer(Transformers.aliasToBean(entity));
		return sqlQuery.list();
	}
	
	@Override
	public List queryEntityBySql(String sql, Class entity) {
		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(sql);// 查询列表语句对象
		sqlQuery.setResultTransformer(Transformers.aliasToBean(entity));
		return sqlQuery.list();
	}
}
