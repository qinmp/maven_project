package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.dao.AccountDao;
import com.model.Account;

@Repository
public class AccountDAOImpl extends BaseDAOImpl<Account, Long>  implements AccountDao {

}
