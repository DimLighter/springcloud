package com.hhg.jerry.controller;

import com.hhg.jerry.dataobject.ProductCategory;
import com.hhg.jerry.dataobject.ProductInfo;
import com.hhg.jerry.service.CategoryService;
import com.hhg.jerry.service.ProductService;
import com.hhg.jerry.utils.ResultVOUtils;
import com.hhg.jerry.visualobject.ProductInfoVO;
import com.hhg.jerry.visualobject.ProductVO;
import com.hhg.jerry.visualobject.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lina on 2018/10/11.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        List<ProductInfo> productInfoList = productService.findUpAll();
        List<Integer> categoryTypeList = productInfoList.stream().
                map(ProductInfo::getCategoryType).collect(Collectors.toList());

        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOS = new ArrayList<>();

        for(ProductCategory productCategory : productCategories){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOS.add(productVO);
        }

        return ResultVOUtils.success(productVOS);
    }
}
