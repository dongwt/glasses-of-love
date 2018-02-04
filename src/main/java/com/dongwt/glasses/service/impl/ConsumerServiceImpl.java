package com.dongwt.glasses.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.ConsumerRequest;
import com.dongwt.glasses.dao.Consumer;
import com.dongwt.glasses.mapper.ConsumerMapper;
import com.dongwt.glasses.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dongwt on 2018/1/29.
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ConsumerMapper consumerMapper;

    @Override
    public synchronized void add(Consumer consumer) {
        consumerMapper.add(consumer);
    }

    @Override
    public synchronized void delete(Consumer consumer) {
        consumerMapper.delete(consumer);
    }

    @Override
    public synchronized void update(Consumer consumer) {
        consumerMapper.update(consumer);
    }

    @Override
    public CommonPagination<Consumer> queryForPage(ConsumerRequest consumerRequest) {
        List<Consumer> consumerList = consumerMapper.queryForPageData(consumerRequest);
        logger.info("brandList:{}", JSONObject.toJSONString(consumerList));
        int count = consumerMapper.queryForPageCount(consumerRequest);
        logger.info("count:{}",count);
        CommonPagination<Consumer> commonPagination = new CommonPagination<>();
        commonPagination.setItems(consumerList);
        commonPagination.setPage(consumerRequest);
        commonPagination.setTotal(count);
        return commonPagination;
    }

    @Override
    public List<Consumer> query(ConsumerRequest consumerRequest) {
        return consumerMapper.query(consumerRequest);
    }
}
