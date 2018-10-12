package com.hhg.jerry.service;

import com.hhg.jerry.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by lina on 2018/10/12.
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
