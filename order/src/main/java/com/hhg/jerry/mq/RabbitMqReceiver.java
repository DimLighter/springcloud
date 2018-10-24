package com.hhg.jerry.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lina on 2018/10/24.
 */
@Component
public class RabbitMqReceiver {
    private Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);

    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    public void queue(String message){
        logger.info("queue message is : {}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("computerQueue"),
            key = "computer",
            exchange = @Exchange("myExchange")))
    public void computerExchange(String message){
        logger.info("computerExchange message is : {}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fruitQueue"),
            key = "fruit",
            exchange = @Exchange("myExchange")))
    public void fruitExchange(String message){
        logger.info("fruit message is : {}", message);
    }
}
