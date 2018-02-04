package com.dongwt.glasses.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.OptometryRequest;
import com.dongwt.glasses.dao.Optometry;
import com.dongwt.glasses.mapper.OptometryMapper;
import com.dongwt.glasses.service.OptometryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dongwt on 2018/1/29.
 */
@Service
public class OptometryServiceImpl implements OptometryService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OptometryMapper optometryMapper;

    @Override
    public synchronized void add(Optometry optometry) {
        optometryMapper.add(optometry);
    }

    @Override
    public synchronized void delete(Optometry optometry) {
        optometryMapper.delete(optometry);
    }

    @Override
    public synchronized void update(Optometry optometry) {
        optometryMapper.update(optometry);
    }

    @Override
    public List<Optometry> query(Optometry optometry) {
        return optometryMapper.query(optometry);
    }

    @Override
    public CommonPagination<Optometry> queryForPage(OptometryRequest optometryRequest) {
        List<Optometry> optometryList = optometryMapper.queryForPageData(optometryRequest);
        logger.info("optometryList:{}", JSONObject.toJSONString(optometryList));
        int count = optometryMapper.queryForPageCount(optometryRequest);
        logger.info("count:{}", count);
        CommonPagination<Optometry> commonPagination = new CommonPagination<>();
        commonPagination.setItems(optometryList);
        commonPagination.setPage(optometryRequest);
        commonPagination.setTotal(count);
        return commonPagination;
    }
}
