package com.dongwt.glasses.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.GoodsRequest;
import com.dongwt.glasses.dao.Goods;
import com.dongwt.glasses.mapper.GoodsMapper;
import com.dongwt.glasses.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dongwt on 2018/1/30.
 */
@Service
public class GoodsServiceImpl implements GoodsService{

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public void insert(Goods goods) {
        if(null == goodsMapper.query(goods)){
            logger.info("新增商品");
            goodsMapper.insert(goods);
        }
    }

    @Override
    public void add(Goods goods) {
        goodsMapper.add(goods);
    }

    @Override
    public void reduce(Goods goods) {
        goodsMapper.reduce(goods);
    }

    @Override
    public void delete(Goods goods) {
        goodsMapper.delete(goods);
    }

    @Override
    public void update(Goods goods) {
        goodsMapper.update(goods);
    }

    @Override
    public CommonPagination<Goods> queryForPage(GoodsRequest goodsRequest) {
        List<Goods> goodsList = goodsMapper.queryForPageData(goodsRequest);
        logger.info("goodsList:{}", JSONObject.toJSONString(goodsList));
        int count = goodsMapper.queryForPageCount(goodsRequest);
        logger.info("count:{}", count);
        CommonPagination<Goods> commonPagination = new CommonPagination<>();
        commonPagination.setItems(goodsList);
        commonPagination.setPage(goodsRequest);
        commonPagination.setTotal(count);
        return commonPagination;
    }
}
