package com.ian.service;


import com.ian.pojo.Result;
import com.ian.pojo.dto.Page;
import com.ian.pojo.entity.Product;

public interface ProductService {

    //分页查询商品的业务方法
    public Page queryProductPage(Page page, Product product);


    /**
     * 添加商品
     * @param product
     */
    void addProduct(Product product);
}
