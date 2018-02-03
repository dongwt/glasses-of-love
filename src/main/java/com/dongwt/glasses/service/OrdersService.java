package com.dongwt.glasses.service;

import com.dongwt.glasses.api.pagination.CommonPagination;
import com.dongwt.glasses.api.request.OrdersRequest;
import com.dongwt.glasses.dao.Orders;

/**
 * Created by dongwt on 2018/2/3.
 */
public interface OrdersService {

    void add(Orders orders);


    void delete(Orders orders);

    CommonPagination<Orders> queryForPage(OrdersRequest ordersRequest);

}
