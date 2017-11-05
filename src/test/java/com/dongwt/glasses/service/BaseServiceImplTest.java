package com.dongwt.glasses.service;

import com.dongwt.glasses.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dongwt on 2017/11/5.
 */
public class BaseServiceImplTest  extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImplTest.class);

    @Autowired
    private BaseService baseService;

    @Test
    public void test(){
        baseService.index();
    }
}
