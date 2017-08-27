package com.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.service.TMedicalHistoryReviewService;
import com.model.TMedicalHistoryReview;
import com.dao.TMedicalHistoryReviewDAO;
@Service
public class TMedicalHistoryReviewServiceImpl extends BaseServiceImpl<TMedicalHistoryReview, Long>  implements TMedicalHistoryReviewService  {

    @Resource
    public void setBaseDao(TMedicalHistoryReviewDAO tMedicalHistoryReviewDAO) {
        this.baseDAO = tMedicalHistoryReviewDAO;
    }

}
