package com.dongwt.glasses.api.response;

import com.dongwt.glasses.enums.ResponseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Response<T, E> extends ResponseData<E> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private int status;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    public Response() {
    }

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Response(int status, String message, T data) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public Response(ResponseEnum responseEnum) {
        this.status = responseEnum.getStatus();
        this.message = responseEnum.getMessage();
    }

    public static <T, E> Response<T, E> success() {
        Response<T, E> response = new Response<T, E>();
        response.setStatus(ResponseEnum.SUCCESS.getStatus());
        response.setMessage(ResponseEnum.SUCCESS.getMessage());
        return response;
    }

    public static <T, E> Response<T, E> error() {
        Response<T, E> response = new Response<T, E>();
        response.setStatus(ResponseEnum.ERROR.getStatus());
        response.setMessage(ResponseEnum.ERROR.getMessage());
        return response;
    }

    public static <T, E> Response<T, E> error(String message) {
        Response<T, E> response = new Response<>();
        response.setStatus(ResponseEnum.ERROR.getStatus());
        response.setMessage(message);
        return response;
    }

}
