package com.hhg.jerry.exception;

import com.hhg.jerry.enums.ResultEnum;

/**
 * Created by lina on 2018/10/15.
 */
public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
