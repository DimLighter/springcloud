package com.hhg.jerry.service;

import com.hhg.jerry.ProductApplicationTests;
import com.hhg.jerry.dataobject.ProductInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by lina on 2018/10/12.
 */
@Component
public class ProductServiceTest extends ProductApplicationTests{

    @Autowired
    ProductService productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList = productService.findUpAll();
        System.out.println(productInfoList.size());
    }

}