package com.dongwt.glasses.api.request;

import lombok.Data;

/**
 * Created by dongwt on 2018/1/29.
 */
@Data
public class BrandCategoryRequest {

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
