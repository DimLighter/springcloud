package com.hhg.jerry.enums;

/**
 * Created by lina on 2018/10/13.
 */
public enum ResultEnum {
    PARAM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车为空"),
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
