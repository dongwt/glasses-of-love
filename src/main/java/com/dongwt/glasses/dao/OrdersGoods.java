package com.dongwt.glasses.dao;

import com.dongwt.glasses.enums.UnitEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单商品关联表
 */
@Data
public class OrdersGoods {

    private Long id;

    /**
     * 订单表id
     */
    private Long ordersId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 品牌名
     */
    private String brandName;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 分类名
     */
    private String categoryName;

    /**
     * 度数
     */
    private Float degree;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;


    /**
     * 单位 0:片 1:付
     */
    private Integer unit;

    /**
     * 数量
     */
    private Long nums;


    public UnitEnum getUnitEnum(Integer unit) {
        return UnitEnum.getByCode(unit);
    }
}
