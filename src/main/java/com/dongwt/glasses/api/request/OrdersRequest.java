package com.dongwt.glasses.api.request;

import lombok.Data;

/**
 * 订单分页查询请求实体
 */
@Data
public class OrdersRequest  extends BasePageRequest{

    private Long id;

    /**
     * 订单编号
     */
    private Long tradeNo;

    /**
     * 客户id
     */
    private Long consumerId;
}
