package com.dongwt.glasses.dao;

import lombok.Data;

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
     * 左眼度数
     */
    private Float leftEyeDegree;


    /**
     * 右眼度数
     */
    private Float rightEyeDegree;
}
