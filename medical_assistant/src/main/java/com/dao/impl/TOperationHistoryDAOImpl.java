package com.dao.impl;
import org.springframework.stereotype.Repository;
import com.dao.TOperationHistoryDAO;
import com.model.TOperationHistory;
@Repository
public class TOperationHistoryDAOImpl extends BaseDAOImpl<TOperationHistory, Long>  implements TOperationHistoryDAO  {
}
