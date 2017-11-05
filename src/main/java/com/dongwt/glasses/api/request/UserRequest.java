package com.dongwt.glasses.api.request;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by dongwt on 2017/11/5.
 */
@Data
public class UserRequest implements Serializable{

    private static final long serialVersionUID = -2192435787314309158L;
    /**
     * 用户名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;
}
