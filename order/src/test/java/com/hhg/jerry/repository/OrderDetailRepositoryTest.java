package com.hhg.jerry.repository;

import com.hhg.jerry.OrderApplicationTests;
import com.hhg.jerry.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by lina on 2018/10/12.
 */
@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests{

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123");
        orderDetail.setOrderId("orderid111");
        orderDetail.setProductId("123");
        orderDetail.setProductName("nameproduct");
        orderDetail.setProductPrice(new BigDecimal(3.3));
        orderDetail.setProductQuantity(3);
        OrderDetail result = orderDetailRepository.save(orderDetail);

        Assert.assertTrue(result != null);
    }
}