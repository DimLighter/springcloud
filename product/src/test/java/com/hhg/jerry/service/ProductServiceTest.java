package com.hhg.jerry.service;

import com.hhg.jerry.ProductApplicationTests;
import com.hhg.jerry.dataobject.ProductInfo;
import com.hhg.jerry.dto.CartDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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

    @Test
    public void decreaseStockTest() throws Exception{
        CartDTO cartDTO1 = new CartDTO("aaabba", 2);
        CartDTO cartDTO2 = new CartDTO("aaabbb", 2);
        productService.decreaseStock(Arrays.asList(cartDTO1, cartDTO2));
    }

}