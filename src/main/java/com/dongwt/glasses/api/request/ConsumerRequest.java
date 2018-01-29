package com.dongwt.glasses.api.request;

import com.dongwt.glasses.enums.Sex;
import lombok.Data;

/**
 * Created by dongwt on 2018/1/29.
 */
@Data
public class ConsumerRequest extends BasePageRequest{

    private Long id;

    /**
     * 客户名
     */
    private String name;


    /**
     * 手机号
     */
    private String phone;


    public Sex getSex(Integer sex) {
        return Sex.getByCode(sex);
    }
}
