package com.dongwt.glasses.service;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.BaseTest;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.GoodsRequest;
import com.dongwt.glasses.dao.Goods;
import com.dongwt.glasses.enums.UnitEnum;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created by dongwt on 2018/1/30.
 */
public class GoodsServiceImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(GoodsServiceImplTest.class);

    @Autowired
    private GoodsService goodsService;


    @Test
    public void insert() {
        Goods goods = new Goods();
        goods.setBrandId(2l);
        goods.setCategoryId(1l);
        goods.setDegree(0.5f);
        goods.setPurchasePrice(new BigDecimal(10));
        goods.setRetailPrice(new BigDecimal(100));
        goods.setUnit(UnitEnum.SHEET.getCode());
        goods.setNums(20l);
        goodsService.insert(goods);
    }


    @Test
    public void add() {
        Goods goods = new Goods();
        goods.setId(6l);
        goods.setNums(80l);
        goodsService.add(goods);
    }


    @Test
    public void reduce() {
        Goods goods = new Goods();
        goods.setId(1l);
        goods.setNums(1l);
        goodsService.reduce(goods);
    }

    @Test
    public void delete() {
        Goods goods = new Goods();
        goods.setId(4l);
        goodsService.delete(goods);
    }

    @Test
    public void update() {
        Goods goods = new Goods();
        goods.setId(1l);
        goods.setBrandId(3l);
        goodsService.update(goods);
    }

    @Test
    public void queryForPage() {
        GoodsRequest goodsRequest = new GoodsRequest();
        CommonPagination<Goods> data = goodsService.queryForPage(goodsRequest);
        logger.info("data:{}", JSONObject.toJSONString(data));
    }
}
