package com.hhg.jerry.service;

import com.hhg.jerry.ProductApplicationTests;
import com.hhg.jerry.dataobject.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lina on 2018/10/12.
 */
@Component
public class CategoryServiceTest extends ProductApplicationTests{

    @Autowired
    CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(Arrays.asList(11,12));
        System.out.println(productCategories);
    }

}