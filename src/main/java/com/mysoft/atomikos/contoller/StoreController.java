package com.mysoft.atomikos.contoller;

import com.mysoft.atomikos.exception.CommonException;
import com.mysoft.atomikos.exception.StoreException;
import com.mysoft.atomikos.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @RequestMapping("testNoRoll")
    public void testNoRoll() {
        System.out.println("begin testNoRoll.");
        try {
            storeService.storeWithNoRollbackException();
        } catch (CommonException e) {
            System.out.println("get CommonException");
        }
        System.out.println("end testNoRoll.");
    }

    @RequestMapping("testRoll")
    public void testRoll() {
        System.out.println("begin testRoll.");
        try {
            storeService.storeWithStoreException();
        } catch (StoreException e) {
            System.out.println("get StoreException");
        }
        System.out.println("end testRoll.");
    }

}
