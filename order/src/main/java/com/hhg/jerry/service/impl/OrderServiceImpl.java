package com.hhg.jerry.service.impl;

import com.hhg.jerry.dataobject.OrderMaster;
import com.hhg.jerry.dto.OrderDTO;
import com.hhg.jerry.enums.OrderStatusEnum;
import com.hhg.jerry.enums.PayStatusEnum;
import com.hhg.jerry.repository.OrderDetailRepository;
import com.hhg.jerry.repository.OrderMasterRepository;
import com.hhg.jerry.service.OrderService;
import com.hhg.jerry.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created by lina on 2018/10/12.
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMasterRepository orderMasterRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(KeyUtils.getUniqueId());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(3.0));
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
