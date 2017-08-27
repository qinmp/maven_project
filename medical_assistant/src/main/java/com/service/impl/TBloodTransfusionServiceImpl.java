package com.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.service.TBloodTransfusionService;
import com.model.TBloodTransfusion;
import com.dao.TBloodTransfusionDAO;
@Service
public class TBloodTransfusionServiceImpl extends BaseServiceImpl<TBloodTransfusion, Long>  implements TBloodTransfusionService  {

    @Resource
    public void setBaseDao(TBloodTransfusionDAO tBloodTransfusionDAO) {
        this.baseDAO = tBloodTransfusionDAO;
    }

}
