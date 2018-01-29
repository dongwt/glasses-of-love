package com.dongwt.glasses.dao;

import com.dongwt.glasses.enums.Sex;
import lombok.Data;

import java.util.Date;

/**
 * Created by dongwt on 2018/1/29.
 */
@Data
public class Consumer {

    private Long id;

    /**
     * 客户名
     */
    private String name;


    /**
     * 手机号
     */
    private String phone;


    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 0:女 1:男 2:未知
     */
    private Integer sex;


    /**
     * 逻辑删除 0:不可用 1:可用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    public Sex getSex(Integer sex) {
        return Sex.getByCode(sex);
    }
}
