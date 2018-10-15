package com.hhg.jerry.repository;

import com.hhg.jerry.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lina on 2018/10/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfoList = productRepository.findByProductStatus(0);
        System.out.println(productInfoList.size());
    }

    @Test
    public void findByProductIdInTest() throws Exception{
        List<ProductInfo> productInfos = productRepository.findByProductIdIn(Arrays.asList("aaabba","aaabbb"));
        System.out.println(productInfos.size());
    }

}