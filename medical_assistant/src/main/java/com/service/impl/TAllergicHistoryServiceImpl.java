package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TAllergicHistoryDAO;
import com.model.TAllergicHistory;
import com.service.TAllergicHistoryService;
@Service
public class TAllergicHistoryServiceImpl extends BaseServiceImpl<TAllergicHistory, Long>  implements TAllergicHistoryService  {

    @Resource
    public void setBaseDao(TAllergicHistoryDAO tAllergicHistoryDao) {
        this.baseDAO = tAllergicHistoryDao;
    }

}
