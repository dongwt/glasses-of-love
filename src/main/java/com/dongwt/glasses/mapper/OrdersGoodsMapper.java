package com.dongwt.glasses.mapper;

import com.dongwt.glasses.dao.OrdersGoods;

/**
 * Created by dongwt on 2018/2/1.
 */
public interface OrdersGoodsMapper {

    int add(OrdersGoods ordersGoods);


    int delete(OrdersGoods ordersGoods);


    int deleteByOrdersId(OrdersGoods ordersGoods);

}
