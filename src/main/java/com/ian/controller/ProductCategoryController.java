package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.service.ProductTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/18 19:49
 */
@RestController
@Slf4j
@RequestMapping("/productCategory")
public class ProductCategoryController {
    @Autowired
    private ProductTypeService productTypeService;

    /**
     * 获取所有的商品种类树
     * @return
     */
    @GetMapping("/product-category-tree")
    public Result getProductCategoryTree(){
        return Result.ok(productTypeService.allProductTypeTree());
    }
}
