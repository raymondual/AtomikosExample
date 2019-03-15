package com.mysoft.atomikos.service;

import com.mysoft.atomikos.exception.CommonException;
import com.mysoft.atomikos.exception.StoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("storeService")
public class StoreServiceImpl implements StoreService {

    @Autowired
    private JdbcTemplate dongBankJdbcTemplate;

    @Autowired
    private JdbcTemplate xiBankJdbcTemplate;

    @Transactional(rollbackFor = StoreException.class)
    public void storeWithStoreException() throws StoreException {
        dongBankJdbcTemplate.execute("update user_amount set amount = amount + 100");
        xiBankJdbcTemplate.execute("update user_amount set amount = amount - 100");
        throw new StoreException();
    }

    @Transactional(noRollbackFor = CommonException.class, rollbackFor = StoreException.class)
    public void storeWithNoRollbackException() throws CommonException {
        dongBankJdbcTemplate.execute("update user_amount set amount = amount + 100");
        xiBankJdbcTemplate.execute("update user_amount set amount = amount - 100");
        throw new CommonException();
    }

}
