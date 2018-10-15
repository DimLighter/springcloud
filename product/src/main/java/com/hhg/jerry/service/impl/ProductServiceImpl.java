package com.hhg.jerry.service.impl;

import com.hhg.jerry.dataobject.ProductInfo;
import com.hhg.jerry.dto.CartDTO;
import com.hhg.jerry.enums.ProductStatusEnum;
import com.hhg.jerry.enums.ResultEnum;
import com.hhg.jerry.exception.ProductException;
import com.hhg.jerry.repository.ProductRepository;
import com.hhg.jerry.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ProductInfo> findByProductIdIn(List<String> productIdList) {
        return productRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = productRepository.findById(cartDTO.getProductId());
            if (!productInfoOptional.isPresent())
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);

            ProductInfo productInfo = productInfoOptional.get();
            if (productInfo.getProductStock() < cartDTO.getProductQuantity())
                throw new ProductException(ResultEnum.PRODUCT_NOT_ENOUGH);

            productInfo.setProductStock(productInfo.getProductStock() - cartDTO.getProductQuantity());
            productRepository.save(productInfo);
        }
    }
}
