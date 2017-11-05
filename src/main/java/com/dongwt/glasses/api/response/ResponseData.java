package com.dongwt.glasses.api.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T additional;

}
