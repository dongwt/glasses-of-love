package com.dongwt.glasses.service;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.BaseTest;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.ConsumerRequest;
import com.dongwt.glasses.dao.Consumer;
import com.dongwt.glasses.enums.Sex;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dongwt on 2018/1/29.
 */
public class ConsumerServiceImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerServiceImplTest.class);

    @Autowired
    private ConsumerService consumerService;

    @Test
    public void add() {
        Consumer consumer = new Consumer();
        consumer.setName("tom");
        consumer.setPhone("110");
        consumer.setAge(12);
        consumer.setSex(Sex.MAN.getCode());
        consumerService.add(consumer);
    }

    @Test
    public void delete() {
        Consumer consumer = new Consumer();
        consumer.setId(1l);
        consumerService.delete(consumer);
    }

    @Test
    public void update() {
        Consumer consumer = new Consumer();
        consumer.setName("tom1");
        consumer.setPhone("1101");
        consumer.setAge(121);
        consumer.setSex(Sex.WOMAN.getCode());
        consumer.setId(1l);
        consumerService.update(consumer);
    }

    @Test
    public void queryForPage() {
        ConsumerRequest consumerRequest  = new ConsumerRequest();
        CommonPagination<Consumer> data = consumerService.queryForPage(consumerRequest);
        logger.info("data:{}", JSONObject.toJSONString(data));
    }

    @Test
    public void query() {
        ConsumerRequest consumerRequest  = new ConsumerRequest();
//        consumerRequest.setName("t");
        List<Consumer> consumerList =  consumerService.query(consumerRequest);
        logger.info("consumerList:{}", JSONObject.toJSONString(consumerList));
    }

}
