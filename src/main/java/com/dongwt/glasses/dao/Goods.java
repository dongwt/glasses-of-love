package com.dongwt.glasses.dao;

/**
 * 商品
 */
public class Goods {

    private Long id;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 分类id
     */
    private Long categoryId;


    /**
     * 度数
     */
    private Float degree;


    /**
     * 数量
     */
    private Long nums;

    /**
     * 逻辑删除 0:不可用 1:可用
     */
    private Integer status;
}
