package com.dongwt.glasses.enums;

/**
 * 单位枚举
 */
public enum UnitEnum {

    SHEET(0, "片"), PAIR(1, "副");

    UnitEnum(Integer code, String describe) {
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

    public static UnitEnum getByCode(Integer code) {
        for (UnitEnum item : values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }
}
