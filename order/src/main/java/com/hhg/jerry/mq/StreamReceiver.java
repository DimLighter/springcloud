package com.hhg.jerry.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by lina on 2018/10/25.
 */
@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {
    private Logger logger = LoggerFactory.getLogger(StreamReceiver.class);
    @StreamListener("myMessage1")
    public void process(Object object){
        logger.info("receive msg : {}", object);
    }
}
