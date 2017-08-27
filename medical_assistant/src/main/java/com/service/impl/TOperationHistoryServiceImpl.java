package com.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.service.TOperationHistoryService;
import com.model.TOperationHistory;
import com.dao.TOperationHistoryDAO;
@Service
public class TOperationHistoryServiceImpl extends BaseServiceImpl<TOperationHistory, Long>  implements TOperationHistoryService  {

    @Resource
    public void setBaseDao(TOperationHistoryDAO tOperationHistoryDAO) {
        this.baseDAO = tOperationHistoryDAO;
    }

}
