package com.hhg.jerry.repository;

import com.hhg.jerry.OrderApplicationTests;
import com.hhg.jerry.dataobject.OrderMaster;
import com.hhg.jerry.enums.OrderStatusEnum;
import com.hhg.jerry.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lina on 2018/10/12.
 */
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests{
    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("orderid111");
        orderMaster.setBuyerAddress("燕郊东贸");
        orderMaster.setBuyerName("ted");
        orderMaster.setBuyerOpenid("weixinid_ids");
        orderMaster.setBuyerPhone("13666666666");
        orderMaster.setOrderAmount(new BigDecimal(5.2));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster saved = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(saved != null);
    }
}