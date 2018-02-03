package com.dongwt.glasses.api.request;

import com.dongwt.glasses.dao.Goods;

import java.util.List;

/**
 * 订单的crud
 */
public class OperateOrdersRequest {

    private Long id;

    private List<Goods> goodsList;
}
