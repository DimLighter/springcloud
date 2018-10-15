package com.hhg.jerry.enums;

/**
 * Created by lina on 2018/10/15.
 */
public enum ResultEnum {
    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_NOT_ENOUGH(2, "库存不够"),
    ;

    private Integer code;
    private String message;

    ResultEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
