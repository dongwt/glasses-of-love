package com.dongwt.glasses.api.request;

import lombok.Data;

/**
 * Created by dongwt on 2018/1/30.
 */
@Data
public class GoodsRequest extends BasePageRequest{

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 分类id
     */
    private Long categoryId;


}
