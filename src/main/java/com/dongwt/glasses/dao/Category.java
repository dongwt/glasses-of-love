package com.dongwt.glasses.dao;

import lombok.Data;

/**
 * 小类
 */
@Data
public class Category {

    private Long id;

    /**
     * 品牌名
     */
    private String name;


    /**
     * 逻辑删除 0:不可用 1:可用
     */
    private Integer status;
}
