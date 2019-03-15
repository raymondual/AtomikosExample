package com.mysoft.atomikos.service;

import com.mysoft.atomikos.exception.CommonException;
import com.mysoft.atomikos.exception.StoreException;

public interface StoreService {

    public void storeWithStoreException() throws StoreException;

    public void storeWithNoRollbackException() throws CommonException;
}
