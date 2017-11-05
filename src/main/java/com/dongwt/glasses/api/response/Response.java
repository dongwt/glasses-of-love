package com.dongwt.glasses.api.response;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by dongwt on 2017/11/5.
 */
@Data
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -6354092543740486153L;

    private T data;

    private Integer status;

    private String message;
}
