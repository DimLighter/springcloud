package com.hhg.jerry.enums;

/**
 * Created by lina on 2018/10/12.
 */
public enum OrderStatusEnum {
    NEW(0, "新下单"),
    Finished(1, "已完结"),
    CANCEL(2,"取消");

    private Integer code;
    private String message;

    OrderStatusEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
