package com.dao.impl;
import org.springframework.stereotype.Repository;
import com.dao.TPersonHistoryDAO;
import com.model.TPersonHistory;
@Repository
public class TPersonHistoryDAOImpl extends BaseDAOImpl<TPersonHistory, Long>  implements TPersonHistoryDAO  {
}
