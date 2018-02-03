package com.dongwt.glasses.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.OrdersRequest;
import com.dongwt.glasses.dao.Goods;
import com.dongwt.glasses.dao.Orders;
import com.dongwt.glasses.dao.OrdersGoods;
import com.dongwt.glasses.mapper.GoodsMapper;
import com.dongwt.glasses.mapper.OrdersGoodsMapper;
import com.dongwt.glasses.mapper.OrdersMapper;
import com.dongwt.glasses.service.OrdersService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by dongwt on 2018/2/3.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrdersGoodsMapper ordersGoodsMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    private String generateTradeNo() {
        DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern("yyyyMMddHHmmss");
        String millsStr = String.valueOf(System.currentTimeMillis());
        return DateTime.now().toString(dateTimeFormat) + millsStr.substring(millsStr.length() - 6, millsStr.length());
    }


    private void checkParams(Orders orders){
        //计算应付金额
        BigDecimal payableAmount = new BigDecimal(0);
        for (OrdersGoods item : orders.getOrdersGoodsList()) {
            Goods goods = new Goods();
            goods.setId(item.getGoodsId());
            Goods result = goodsMapper.queryById(goods);
            if(item.getNums() > result.getNums()){
                throw  new RuntimeException(result.getBrandName() + "-" + result.getCategoryName() + "-" + result.getDegree() + "库存不足!");
            }
            payableAmount = payableAmount.add(result.getRetailPrice().multiply(new BigDecimal(item.getNums())));
        }
        orders.setPayableAmount(payableAmount);
    }


    @Transactional
    @Override
    public void add(Orders orders) {
        checkParams(orders);
        orders.setTradeNo(generateTradeNo());
        //1.新增orders
        ordersMapper.add(orders);
        //2.新增orders_goods
        for (OrdersGoods item : orders.getOrdersGoodsList()) {
            item.setOrdersId(orders.getId());
            ordersGoodsMapper.add(item);
        }
    }

    @Transactional
    @Override
    public void delete(Orders orders) {
        //1.删除orders
        ordersMapper.delete(orders);
        //2.删除orders_goods
        OrdersGoods ordersGoods = new OrdersGoods();
        ordersGoods.setOrdersId(orders.getId());
        ordersGoodsMapper.deleteByOrdersId(ordersGoods);
    }


    @Override
    public CommonPagination<Orders> queryForPage(OrdersRequest ordersRequest) {
        List<Orders> ordersList = ordersMapper.queryForPageData(ordersRequest);
        logger.info("goodsList:{}", JSONObject.toJSONString(ordersList));
        int count = ordersMapper.queryForPageCount(ordersRequest);
        logger.info("count:{}", count);
        CommonPagination<Orders> commonPagination = new CommonPagination<>();
        commonPagination.setItems(ordersList);
        commonPagination.setPage(ordersRequest);
        commonPagination.setTotal(count);
        return commonPagination;
    }
}
