package com.dongwt.glasses.api.request;

import lombok.Data;

/**
 * Created by dongwt on 2018/1/28.
 */
@Data
public class CategoryRequest extends BasePageRequest {

    /**
     * 品牌名
     */
    private String name;
}
