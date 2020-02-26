package com.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bean.MainSuitReqBean;
import com.dao.BasicInfoDao;
import com.dao.MainSuitDao;
import com.exception.BusinessException;
import com.model.BasicInfo;
import com.model.MainSuit;
import com.service.MainSuitService;
import com.util.DateUtil;
import com.util.vo.ServiceResult;

@Service
public class MainSuitServiceImpl  extends BaseServiceImpl<MainSuit, Long> implements MainSuitService {
	private Logger logger=Logger.getLogger(MainSuitServiceImpl.class);
	@Resource
	private MainSuitDao mainSuitDao;
	
	@Resource
	private BasicInfoDao basicInfoDao;
	
	@Resource
	public void setBaseDao(MainSuitDao mainSuitDao){
		this.baseDAO = mainSuitDao;
	}
	
	@Override
	public void saveMainSuit(MainSuitReqBean bean, ServiceResult result, Long accountId) {
		MainSuit mainSuit1 = null;
		MainSuit mainSuit2 = null;
		if(null == accountId){
			throw new BusinessException("请先登录");
		} else if(StringUtils.isBlank(bean.getSerialNo())){
			throw new BusinessException("序列号不能为空");
		} else if((bean.getMainSuitValue() == 0) || (bean.getMainSuitValue() > 24)){
			throw new BusinessException("请选择主诉");
		} else if(StringUtils.isBlank(bean.getAttackTime())){
			throw new BusinessException("请选择发病时间");
		}
		BasicInfo basicInfo = basicInfoDao.load("serialNo", bean.getSerialNo());
		if(null == basicInfo){
			throw new BusinessException("请先保存基本信息");
		}
		mainSuit1 = mainSuitDao.load("serialNo", bean.getSerialNo());
		if(null == mainSuit1){
			mainSuit1 = new MainSuit();
		}
		mainSuit1.setAttackTime(new Timestamp(DateUtil.toDate(bean.getAttackTime()).getTime()));
		mainSuit1.setCreateTime(DateUtil.getNowTimestamp());
		mainSuit1.setMainSuitContent(bean.getMainSuitContent());
		mainSuit1.setMainSuitValue(bean.getMainSuitValue());
		mainSuit1.setUpdateTime(DateUtil.getNowTimestamp());
		mainSuit1.setSerialNo(bean.getSerialNo());
		mainSuit1.setAccountId(accountId);
		mainSuitDao.saveOrUpdate(mainSuit1);
		
		//如果第二个主诉不为空，添加进数据库
		if((bean.getMainSuitValue2() != 0) && (bean.getMainSuitValue2() <= 24)){
			if(StringUtils.isBlank(bean.getAttackTime2())){
				throw new BusinessException("请选择发病时间");
			}
			mainSuit2 = new MainSuit();
			mainSuit2.setAttackTime(new Timestamp(DateUtil.toDate(bean.getAttackTime2()).getTime()));
			mainSuit2.setCreateTime(DateUtil.getNowTimestamp());
			mainSuit2.setMainSuitContent(bean.getMainSuitContent2());
			mainSuit2.setMainSuitValue(bean.getMainSuitValue2());
			mainSuit2.setUpdateTime(DateUtil.getNowTimestamp());
			mainSuit2.setSerialNo(bean.getSerialNo());
			mainSuit2.setAccountId(accountId);
			mainSuitDao.saveOrUpdate(mainSuit2);
		}
		result.setIsSuccess(true);
		result.setMessage("保存成功");
	}

	@Override
	public void deleteMainSuit(MainSuitReqBean bean, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(bean.getSerialNo())){
			throw new BusinessException("合同编码不能为空");
		}
		//主诉一起删除
		List<MainSuit> mainSuits = mainSuitDao.query(new String[]{"serialNo","accountId"}, new Object[]{bean.getSerialNo(), accountId});
		if(!mainSuits.isEmpty()){
			for(MainSuit mainSuit:mainSuits){
				mainSuitDao.delete(mainSuit);
			}
		}
		result.setMessage("删除成功");
		result.setIsSuccess(true);
	}

}
