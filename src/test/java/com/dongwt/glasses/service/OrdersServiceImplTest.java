package com.dongwt.glasses.service;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.BaseTest;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.OrdersRequest;
import com.dongwt.glasses.dao.Orders;
import com.dongwt.glasses.dao.OrdersGoods;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by dongwt on 2018/2/3.
 */
public class OrdersServiceImplTest  extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(OrdersServiceImplTest.class);

    @Autowired
    private OrdersService ordersService;

    @Test
    public void add(){
        Orders orders = new Orders();
        orders.setActuallyAmount(new BigDecimal(0.5));

        OrdersGoods ordersGoods1 = new OrdersGoods();
        ordersGoods1.setGoodsId(1l);
        ordersGoods1.setNums(2l);

        OrdersGoods ordersGoods2 = new OrdersGoods();
        ordersGoods2.setGoodsId(6l);
        ordersGoods2.setNums(1l);
        orders.setOrdersGoodsList(Arrays.asList(ordersGoods1,ordersGoods2));
        ordersService.add(orders);
    }

    @Test
    public void delete(){
        Orders orders = new Orders();
        orders.setId(5l);
        ordersService.delete(orders);
    }


    @Test
    public void query() {
        OrdersRequest ordersRequest = new OrdersRequest();
        CommonPagination<Orders> data = ordersService.queryForPage(ordersRequest);
        logger.info("data:{}", JSONObject.toJSONString(data));
    }
}
