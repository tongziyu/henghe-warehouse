package com.ian.service.impl;


import com.ian.mapper.ProductMapper;
import com.ian.pojo.Result;
import com.ian.pojo.dto.Page;
import com.ian.pojo.entity.Product;
import com.ian.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    //注入ProductMapper
    @Autowired
    private ProductMapper productMapper;

    //分页查询商品的业务方法
    @Override
    public Page queryProductPage(Page page, Product product) {

        //查询商品总行数
        int productCount = productMapper.selectProductCount(product);

        //分页查询商品
        List<Product> productList = productMapper.selectProductPage(page, product);

        //将查询到的总行数和当前页数据组装到Page对象
        page.setTotalNum(productCount);
        page.setResultList(productList);

        return page;
    }


}
