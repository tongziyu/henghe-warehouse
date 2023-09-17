package com.ian.service;


import com.ian.pojo.Result;
import com.ian.pojo.dto.Page;
import com.ian.pojo.entity.Product;

public interface ProductService {
    /**
     * 分页查询商品的业务方法
     * @param page
     * @param product
     * @return
     */
    public Page queryProductPage(Page page, Product product);


    /**
     * 添加商品
     * @param product
     */
    void addProduct(Product product);

    /**
     * 修改商品状态
     * @param product
     */
    void changeState(Product product);
}
