package com.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.service.TInfectionHistoryService;
import com.model.TInfectionHistory;
import com.dao.TInfectionHistoryDAO;
@Service
public class TInfectionHistoryServiceImpl extends BaseServiceImpl<TInfectionHistory, Long>  implements TInfectionHistoryService  {

    @Resource
    public void setBaseDao(TInfectionHistoryDAO tInfectionHistoryDAO) {
        this.baseDAO = tInfectionHistoryDAO;
    }

}
