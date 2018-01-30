package com.dongwt.glasses.enums;

/**
 * 销售枚举
 */
public enum SellStatusEnum {

    NOT_SOLD(0, "未销售"), SOLD(1, "已销售");

    SellStatusEnum(Integer code, String describe) {
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

    public static SellStatusEnum getByCode(Integer code) {
        for (SellStatusEnum item : values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }
}
