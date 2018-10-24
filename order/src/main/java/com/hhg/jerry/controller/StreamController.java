package com.hhg.jerry.controller;

import com.hhg.jerry.mq.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by lina on 2018/10/25.
 */
@RestController
public class StreamController {

//    @Autowired
//    private StreamClient streamClient;
//
//    @GetMapping("/sendMessage")
//    public void process(){
//        String msg = "now :" + new Date();
//        streamClient.output().send(MessageBuilder.withPayload(msg).build());
//    }
}
