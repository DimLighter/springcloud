package com.hhg.jerry.service.impl;

import com.hhg.jerry.client.ProductClient;
import com.hhg.jerry.dataobject.OrderDetail;
import com.hhg.jerry.dataobject.OrderMaster;
import com.hhg.jerry.dataobject.ProductInfo;
import com.hhg.jerry.dto.CartDTO;
import com.hhg.jerry.dto.OrderDTO;
import com.hhg.jerry.enums.OrderStatusEnum;
import com.hhg.jerry.enums.PayStatusEnum;
import com.hhg.jerry.repository.OrderDetailRepository;
import com.hhg.jerry.repository.OrderMasterRepository;
import com.hhg.jerry.service.OrderService;
import com.hhg.jerry.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lina on 2018/10/12.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMasterRepository orderMasterRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtils.getUniqueId();

        List<String> productIds = orderDTO.getOrderDetailList().stream().
                map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIds);

        BigDecimal totalPrice = new BigDecimal(BigInteger.ZERO);
        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()){
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getProductId().equals(orderDetail.getProductId())){
                    totalPrice = productInfo.getProductPrice().multiply(
                            new BigDecimal(orderDetail.getProductQuantity())).add(totalPrice);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtils.getUniqueId());
                    //亲 你的外键被你删掉了吗
                    //orderDetailRepository.save(orderDetail);
                }
            }
        }

        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().
                map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(totalPrice);
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode();
        orderMasterRepository.save(orderMaster);

        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()){
            orderDetailRepository.save(orderDetail);
        }

        return orderDTO;
    }
}
