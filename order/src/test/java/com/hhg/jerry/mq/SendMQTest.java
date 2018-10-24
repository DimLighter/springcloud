package com.hhg.jerry.mq;

import com.hhg.jerry.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lina on 2018/10/24.
 */
@Component
public class SendMQTest extends OrderApplicationTests {
    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    public void sendMsg(){
        amqpTemplate.convertAndSend("myQueue", "now is " + System.currentTimeMillis());
    }

    @Test
    public void orderForFruitTest(){
        amqpTemplate.convertAndSend("myExchange", "computer", "iphone");
        amqpTemplate.convertAndSend("myExchange", "fruit", "apple");
        amqpTemplate.convertAndSend("myExchange", null, "get lost");
    }
}
