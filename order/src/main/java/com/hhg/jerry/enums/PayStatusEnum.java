package com.hhg.jerry.enums;

/**
 * Created by lina on 2018/10/12.
 */
public enum PayStatusEnum {
    WAIT(0,"待支付"),
    SUCCESS(1,"支付成功");


    private Integer code;
    private String message;

    PayStatusEnum(int code, String message){
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
