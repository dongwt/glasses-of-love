package com.dongwt.glasses.api.request;

import lombok.Data;

/**
 * Created by dongwt on 2018/2/4.
 */
@Data
public class OptometryRequest extends BasePageRequest{
    /**
     * 客户名
     */
    private String consumerName;


    /**
     * 客户手机号
     */
    private String consumerPhone;
}
