package com.dongwt.glasses.mapper;

import com.dongwt.glasses.api.request.OrdersRequest;
import com.dongwt.glasses.dao.Orders;

import java.util.List;

/**
 * Created by dongwt on 2018/2/1.
 */
public interface OrdersMapper {

    int add(Orders orders);


    int delete(Orders orders);


    int update(Orders orders);


    List<Orders> queryForPageData(OrdersRequest ordersRequest);

    int queryForPageCount(OrdersRequest ordersRequest);
}
