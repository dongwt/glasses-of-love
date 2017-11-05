package com.dongwt.glasses.enums;

/**
 * 
 * Function: 响应枚举类
 *
 * @author   dongwt
 * @Date	 2017年2月10日		下午3:45:58
 *
 * @see
 */
public enum ResponseEnum {
    
    SUCCESS(1,"成功"),
    
    ERROR(0,"失败");
   
    private Integer status;
    
    private String message;
  
    ResponseEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
