package com.dongwt.glasses.dao;

import com.dongwt.glasses.enums.OrderStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单表
 */
@Data
public class Orders {

    private Long id;

    /**
     * 订单编号
     */
    private String tradeNo;

    /**
     * 客户id
     */
    private Long consumerId;

    /**
     * 客户名称
     */
    private String consumerName;

    /**
     * 数量
     */
    private Long nums;

    /**
     * 应付金额
     */
    private BigDecimal payableAmount;

    /**
     * 实付金额
     */
    private BigDecimal actuallyAmount;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    private List<OrdersGoods> ordersGoodsList;

    public OrderStatusEnum getOrderStatusEnum(Integer orderStatus) {
        return OrderStatusEnum.getByCode(orderStatus);
    }

}
