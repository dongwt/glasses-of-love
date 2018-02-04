package com.dongwt.glasses.service;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.BaseTest;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.OptometryRequest;
import com.dongwt.glasses.dao.Optometry;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dongwt on 2018/1/29.
 */
public class OptometryServiceImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(OptometryServiceImplTest.class);

    @Autowired
    private OptometryService optometryService;


    @Test
    public void add() {
        Optometry optometry = new Optometry();
        optometry.setConsumerId(1l);
        optometry.setLeftEyeDegree(0.5f);
        optometry.setRightEyeDegree(0.6f);
        optometryService.add(optometry);
    }

    @Test
    public void delete() {
        Optometry optometry = new Optometry();
        optometry.setId(1l);
        optometryService.delete(optometry);
    }

    @Test
    public void update() {
        Optometry optometry = new Optometry();
        optometry.setConsumerId(1l);
        optometry.setLeftEyeDegree(0.7f);
        optometry.setRightEyeDegree(0.9f);
        optometry.setId(1l);
        optometryService.update(optometry);
    }

    @Test
    public void query() {
        Optometry optometry  = new Optometry();
        List<Optometry> data = optometryService.query(optometry);
        logger.info("data:{}", JSONObject.toJSONString(data));
    }

    @Test
    public void queryForPage() {
        OptometryRequest optometryRequest = new OptometryRequest();
        optometryRequest.setConsumerName("t");
        CommonPagination<Optometry> data = optometryService.queryForPage(optometryRequest);
        logger.info("data:{}", JSONObject.toJSONString(data));
    }
}
