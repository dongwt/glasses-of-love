package com.dongwt.glasses.service.impl;

import com.dongwt.glasses.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by dongwt on 2017/11/5.
 */
@Service
public class BaseServiceImpl implements BaseService {

    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Override
    public String index() {
        logger.info("info---------------------------------------");
        logger.warn("warn---------------------------------------");
        logger.debug("debug---------------------------------------");
        logger.error("error---------------------------------------");
        return "index";
    }
}
