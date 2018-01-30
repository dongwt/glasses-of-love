package com.dongwt.glasses.dao;

import com.dongwt.glasses.enums.UnitEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 */
@Data
public class Goods {

    private Long id;

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
     * 进价
     */
    private BigDecimal purchasePrice;

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

    private Date createdAt;

    private Date updatedAt;


    public UnitEnum getUnitEnum(Integer unit) {
        return UnitEnum.getByCode(unit);
    }

}
