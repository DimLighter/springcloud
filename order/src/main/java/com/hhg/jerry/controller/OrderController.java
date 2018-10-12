package com.hhg.jerry.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lina on 2018/10/12.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/create")
    public void create(){

    }
}
