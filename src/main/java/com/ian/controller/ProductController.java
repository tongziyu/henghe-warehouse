package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.dto.Page;
import com.ian.pojo.dto.ProductPageDTO;
import com.ian.pojo.entity.Product;
import com.ian.pojo.entity.Supply;
import com.ian.service.BrandService;
import com.ian.service.ProductService;
import com.ian.service.StoreService;
import com.ian.service.SupplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/17 13:02
 */
@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private StoreService storeService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private SupplyService supplyService;

    @Autowired
    private ProductService productService;


    /**
     * 查询所有仓库
     * @return
     */
    @GetMapping("/store-list")
    public Result storeList(){
        return Result.ok(storeService.selectStoreList());
    }


    /**
     * 分页查询商品的url接口/product/product-page-list
     *
     * 参数Page对象用于接收请求参数页码pageNum、每页行数pageSize;
     * 参数Product对象用于接收请求参数仓库id storeId、商品名称productName、
     * 品牌名称brandName、分类名称typeName、供应商名称supplyName、产地名称
     * placeName、上下架状态upDownState、是否过期isOverDate;
     *
     * 返回值Result对象向客户端响应组装了所有分页信息的Page对象;
     */
    @RequestMapping("/product-page-list")
    public Result productPageList(Page page, Product product){
        //执行业务
        page = productService.queryProductPage(page, product);
        //响应
        return Result.ok(page);
    }


    /**
     * 查询所有的品牌
     */
    @GetMapping("/brand-list")
    public Result brandList(){
        return Result.ok(brandService.selectBrandList());
    }


    /**
     * 查询供应商
     * @return
     */
    @GetMapping("/supply-list")
    public Result supplyList(){
        List<Supply> supplies = supplyService.selectSupplyList();

        List<String> list = new ArrayList<>();
        for (Supply supply : supplies){
            list.add(supply.getSupplyName());
        }

        return Result.ok(list);
    }

}
