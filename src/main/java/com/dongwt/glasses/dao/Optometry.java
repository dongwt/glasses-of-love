package com.dongwt.glasses.dao;

import lombok.Data;

import java.util.Date;

/**
 * 验光单
 */
@Data
public class Optometry {

    private Long id;

    /**
     * 客户id
     */
    private Long consumerId;

    /**
     * 客户名
     */
    private String consumerName;

    /**
     * 客户手机号
     */
    private String consumerPhone;

    /**
     * 左眼度数
     */
    private Float leftEyeDegree;


    /**
     * 右眼度数
     */
    private Float rightEyeDegree;

    private Date createdAt;

    private Date updatedAt;
}
