package com.dongwt.glasses.api.request;

import lombok.Data;

import java.util.List;

/**
 * Created by dongwt on 2018/1/28.
 */
@Data
public class BrandRequest extends BasePageRequest{

    private Long id;

    /**
     * 品牌名
     */
    private String name;

    /**
     * 类别id集合
     */
    private List<Long> categoryIds;
}
