package com.hhg.jerry.controller;

import com.hhg.jerry.dto.OrderDTO;
import com.hhg.jerry.enums.ResultEnum;
import com.hhg.jerry.exception.OrderException;
import com.hhg.jerry.form.OrderForm;
import com.hhg.jerry.service.OrderService;
import com.hhg.jerry.utils.OrderForm2DTO;
import com.hhg.jerry.utils.ResultVOUtils;
import com.hhg.jerry.visualobject.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lina on 2018/10/12.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResultVO<Map<String, Object>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2DTO.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtils.success(map);
    }
}
