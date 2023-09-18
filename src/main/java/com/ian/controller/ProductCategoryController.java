package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.entity.ProductType;
import com.ian.service.ProductTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 验证新增商品种类的id是否已存在
     * @param typeCode
     * @return
     */
    @GetMapping("/verify-type-code")
    public Result verifyTypeCode(String typeCode){
        ProductType productType = productTypeService.verifyTypeCode(typeCode);
        return Result.ok(productType == null);
    }


    /**
     * 添加分类
     * @return
     */
    @PostMapping("/type-add")
    public Result addType(@RequestBody ProductType productType){
        log.info("添加分类:{}",productType);
        productTypeService.addType(productType);
        return Result.ok();
    }

    /**
     * 通过id删除分类,以及删除子分类
     * @param typeId
     * @return
     */
    @DeleteMapping("/type-delete/{typeId}")
    public Result deleteType(@PathVariable("typeId")Integer typeId){

        productTypeService.deleteById(typeId);
        return Result.ok();
    }


}
