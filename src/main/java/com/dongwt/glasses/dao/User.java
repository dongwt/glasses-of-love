package com.dongwt.glasses.dao;

import com.dongwt.glasses.enums.Sex;
import lombok.Data;

/**
 * 用户
 */
@Data
public class User {

    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 0:女 1:男
     */
    private Integer sex;

    /**
     * 角色 0:超级管理员 1:普通管理员
     */
    private Integer role;

    /**
     * 逻辑删除 0:不可用 1:可用
     */
    private Integer status;

    public Sex getSex(Integer sex){
        return Sex.getByCode(sex);
    }

}
