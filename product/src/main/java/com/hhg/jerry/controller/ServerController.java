package com.hhg.jerry.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lina on 2018/10/13.
 */
@RestController
public class ServerController {

    @RequestMapping("/msg")
    public String getMsg(){
        return "I'm product server";
    }
}
