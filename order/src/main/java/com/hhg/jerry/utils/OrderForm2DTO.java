package com.hhg.jerry.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hhg.jerry.dataobject.OrderDetail;
import com.hhg.jerry.dto.OrderDTO;
import com.hhg.jerry.enums.ResultEnum;
import com.hhg.jerry.exception.OrderException;
import com.hhg.jerry.form.OrderForm;

import java.util.List;

/**
 * Created by lina on 2018/10/13.
 */
public class OrderForm2DTO {

    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());

        try{
            Gson gson = new Gson();
            orderDTO.setOrderDetailList(
                    gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>(){}.getType()));
        }catch (Exception e){
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }

        return orderDTO;
    }
}
