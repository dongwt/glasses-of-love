package com.dongwt.glasses.dao;

import lombok.Data;

/**
 * 品牌-类别
 */
@Data
public class BrandCategory {

    private Long id;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 类别id
     */
    private Long categoryId;
}
