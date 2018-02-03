package com.dongwt.glasses.enums;

/**
 * 订单状态枚举
 */
public enum OrderStatusEnum {

    NOT_COMPLETE(0, "未完成"), COMPLETED(1, "已完成");

    OrderStatusEnum(Integer code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    private Integer code;

    private String describe;

    public Integer getCode() {
        return this.code;
    }

    public String getDescribe() {
        return this.describe;
    }

    public static OrderStatusEnum getByCode(Integer code) {
        for (OrderStatusEnum item : values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }
}
