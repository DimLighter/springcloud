package com.hhg.jerry.enums;

/**
 * Created by lina on 2018/10/12.
 */
public enum ProductStatusEnum {
    UP("上架",0),
    DOWN("下架",1);

    Integer code;
    String message;

    ProductStatusEnum(String message, int code){
        this.message = message;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
