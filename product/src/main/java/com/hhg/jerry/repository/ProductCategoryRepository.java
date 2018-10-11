package com.hhg.jerry.repository;

import com.hhg.jerry.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lina on 2018/10/11.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
