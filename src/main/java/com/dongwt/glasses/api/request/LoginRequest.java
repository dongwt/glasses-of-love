package com.dongwt.glasses.api.request;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by dongwt on 2017/11/12.
 */
@Data
public class LoginRequest implements Serializable{
    private static final long serialVersionUID = -556930573738580949L;

    private String phone;

    private String password;
}
