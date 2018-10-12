package com.hhg.jerry.utils;

import com.hhg.jerry.visualobject.ResultVO;

/**
 * Created by lina on 2018/10/12.
 */
public class ResultVOUtils {
    public static ResultVO success(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("success");
        resultVO.setData(data);
        return resultVO;
    }
}
