package com.hhg.jerry.controller;

import com.hhg.jerry.client.ProductClient;
import com.hhg.jerry.config.RestTemplateConfig;
import com.hhg.jerry.dataobject.ProductInfo;
import com.hhg.jerry.dto.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lina on 2018/10/13.
 */
@RestController
public class ClientController {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ProductClient productClient;

    @RequestMapping("/getProductMsg1")
    public String getMsg1(){
        return "Method1 received message : " +
                new RestTemplate().getForObject("http://localhost:8800/msg", String.class);
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

    @RequestMapping("/getProductByFeign")
    public String getFeignMsg(){
        return "Method feign received msg : " + productClient.productMsg();
    }

    @RequestMapping("/getProductList")
    public String getProductList(){
        productClient.listForOrder(Arrays.asList("aaabba","aaabbb"));
        return "ok";
    }

    @RequestMapping("/decreaseStock")
    public String decreaseStock(){
        productClient.decreaseStock(Arrays.asList(new CartDTO("aaabbb", 5)));
        return "ok";
    }
}
