package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TMarryHistoryDAO;
import com.model.TMarryHistory;
import com.service.TMarryHistoryService;
import com.util.DateUtil;
import com.util.string.MyStringUtil;
import com.util.vo.ServiceResult;
@Service
public class TMarryHistoryServiceImpl extends BaseServiceImpl<TMarryHistory, Long>  implements TMarryHistoryService  {

	@Resource
	private TMarryHistoryDAO marryHistoryDAO;
	
    @Resource
    public void setBaseDao(TMarryHistoryDAO tMarryHistoryDAO) {
        this.baseDAO = tMarryHistoryDAO;
    }

	@Override
	public void getMarryHistory(String serialNoStr, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		boolean isEmpty = true;
		TMarryHistory marryHistory = marryHistoryDAO.load("serialNo", MyStringUtil.genSerialNo(serialNoStr, accountId));
		if(null != marryHistory){
			isEmpty = false;
		}
		if(!isEmpty){
			result.addData("marryHistoryModel", marryHistory);
			result.setIsSuccess(true);
			result.setMessage("获取成功");
		}else{
			result.setIsSuccess(false);
			result.setMessage("获取失败");
		}
	}

	@Override
	public void saveMarryHistory(Integer marryType, String serialNo, ServiceResult result, Long accountId) {
		this.checkMainStatuValid(accountId, serialNo);
		TMarryHistory marryHistory = this.load("serialNo", MyStringUtil.genSerialNo(serialNo, accountId));
		if(null == marryHistory){
			marryHistory = new TMarryHistory();
			marryHistory.setSerialNo(MyStringUtil.genSerialNo(serialNo, accountId));
			marryHistory.setCreateTime(DateUtil.getNowTimestamp());
		}
		marryHistory.setMarry_type(marryType);
		this.saveOrUpdate(marryHistory);
		result.setIsSuccess(true);
		result.setMessage("保存婚姻史成功");
	}

	@Override
	public void deleteMarryHistory(String serialNo, ServiceResult result, Long accountId) {
		// TODO Auto-generated method stub
		result.setIsSuccess(false);
		result.setMessage("删除失败");
		boolean isDelete = false;
		String realSerialNo = MyStringUtil.genSerialNo(serialNo, accountId);
		TMarryHistory marryHistory = marryHistoryDAO.load("serialNo", realSerialNo);
		if(marryHistory != null){
			marryHistoryDAO.delete(marryHistory);
			isDelete = true;
		}
		if(isDelete){
			result.setIsSuccess(true);
			result.setMessage("删除成功");
		}
	}

}
