package com.hhg.jerry.service;

import com.hhg.jerry.dataobject.ProductInfo;
import com.hhg.jerry.dto.CartDTO;

import java.util.List;

/**
 * Created by lina on 2018/10/12.
 */
public interface ProductService {
    List<ProductInfo> findUpAll();

    List<ProductInfo> findByProductIdIn(List<String> productIdList);

    void decreaseStock(List<CartDTO> cartDTOList);
}
