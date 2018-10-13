package com.hhg.jerry.exception;

import com.hhg.jerry.enums.ResultEnum;

/**
 * Created by lina on 2018/10/13.
 */
public class OrderException extends RuntimeException {
    private Integer code;
    public OrderException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
