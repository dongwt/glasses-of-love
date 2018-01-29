package com.dongwt.glasses.enums;

/**
 * Created by dongwt on 2017/11/5.
 */
public enum Sex {

    WOMAN(0, "女"), MAN(1, "男");

    Sex(Integer code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    private Integer code;

    private String describe;

    public Integer getCode(){
        return this.code;
    }

    public String getDescribe(){
        return  this.describe;
    }

    public static Sex getByCode(Integer code){
        for (Sex item : values()){
            if(item.getCode().equals(code)){
                return item;
            }
        }
        return null;
    }

}
