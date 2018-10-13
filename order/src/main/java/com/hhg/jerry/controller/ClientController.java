package com.hhg.jerry.controller;

import com.hhg.jerry.config.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lina on 2018/10/13.
 */
@RestController
public class ClientController {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/getProductMsg1")
    public String getMsg1(){
        return "Method1 received message : " +
                new RestTemplate().getForObject("http://localhost:8080/msg", String.class);
    }

    @RequestMapping("/getProductMsg2")
    public String getMsg2(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        return "Method2 received message : " + new RestTemplate().getForObject(String.format("http://%s:%s/%s",
                serviceInstance.getHost(), serviceInstance.getPort(), "msg"), String.class);
    }

    @RequestMapping("/getProductMsg3")
    public String getMsg3(){
        return "Method3 received message : " + restTemplate.getForObject("http://PRODUCT/msg", String.class);
    }
}
