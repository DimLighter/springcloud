package com.hhg.jerry.repository;

import com.hhg.jerry.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lina on 2018/10/11.
 */
public interface ProductRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
