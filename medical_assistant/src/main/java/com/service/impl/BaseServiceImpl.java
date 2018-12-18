package com.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.dao.BaseDao;
import com.dao.BasicInfoDao;
import com.dao.MainSuitDao;
import com.exception.MyException;
import com.model.BasicInfo;
import com.model.MainSuit;
import com.service.BaseService;

public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

	protected BaseDao<T, PK> baseDAO;

	@Resource
	private BasicInfoDao basicInfoDao;
	@Resource
	private MainSuitDao mainSuitDao;

	@SuppressWarnings({ "rawtypes" })
	public BaseDao getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDao(BaseDao<T, PK> baseDAO) {
		this.baseDAO = baseDAO;
	}

	@Override
	public T load(PK id) {
		return baseDAO.load(id);
	}

	@Override
	public T get(PK id) {
		return baseDAO.get(id);
	}

	@Override
	public T load(String propertyName, Object value) {
		return baseDAO.load(propertyName, value);
	}

	@Override
	public T load(String[] propertyNames, Object[] values) {
		return baseDAO.load(propertyNames, values);
	}

	@Override
	public List<T> queryAll() {
		return baseDAO.queryAll();
	}

	@Override
	public List<T> queryOrder(String orderProperty) {
		return baseDAO.queryOrder(orderProperty);
	}

	@Override
	public List<T> queryOrder(String propertyName, Object value, String orderProperty) {
		return baseDAO.queryOrder(propertyName, value, orderProperty);
	}

	@Override
	public List<T> queryOrder(String[] propertyNames, Object[] values, String orderProperty) {
		return baseDAO.queryOrder(propertyNames, values, orderProperty);
	}

	@Override
	public List<T> queryOrder(String[] propertyNames, Object[] values, String orderProperty, Integer orderKind) {
		return baseDAO.queryOrder(propertyNames, values, orderProperty, orderKind);
	}

	@Override
	public void save(T t) {
		baseDAO.save(t);
	}

	@Override
	public void update(T t) {
		baseDAO.update(t);
	}

	@Override
	public void flush() {
		baseDAO.flush();
	}

	@Override
	public Long count(String propertyName, Object value) {
		return baseDAO.count(propertyName, value);
	}

	@Override
	public Long count(String[] propertyNames, Object[] values) {
		return baseDAO.count(propertyNames, values);
	}

	@Override
	public void saveOrUpdate(T t) {
		baseDAO.saveOrUpdate(t);
	}

	@Override
	public void delete(String propertyName, Object value) {
		// TODO Auto-generated method stub
		baseDAO.delete(propertyName, value);
	}

	@Override
	public void delete(T model) {
		// TODO Auto-generated method stub
		baseDAO.delete(model);
	}
	
	protected void checkMainStatuValid(Long accountId, String serialNo){
		if(null == accountId){
			throw new MyException("请先登录");
		} else if(StringUtils.isBlank(serialNo)){
			throw new MyException("序列号不能为空");
		}
		BasicInfo basicInfo = basicInfoDao.load("serialNo", serialNo);
		if(null == basicInfo){
			throw new MyException("请先保存基本信息");
		}
		MainSuit mainSuit = mainSuitDao.load("serialNo", serialNo);
		if(null == mainSuit){
			throw new MyException("请先保存主诉");
		}
	}
	
}
