package com.hhg.jerry.service.impl;

import com.hhg.jerry.dataobject.ProductInfo;
import com.hhg.jerry.enums.ProductStatusEnum;
import com.hhg.jerry.repository.ProductRepository;
import com.hhg.jerry.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lina on 2018/10/12.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
