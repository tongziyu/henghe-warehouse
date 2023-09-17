package com.ian.service.impl;


import ch.qos.logback.classic.Logger;
import com.ian.exception.ProductException;
import com.ian.mapper.ProductMapper;
import com.ian.pojo.Result;
import com.ian.pojo.dto.Page;
import com.ian.pojo.entity.Product;
import com.ian.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    //注入ProductMapper
    @Autowired
    private ProductMapper productMapper;

    @Value("${file.access.path}")
    private String fileAccessPath;

    /**
     * 分页查询商品的业务方法
     * @param page
     * @param product
     * @return
     */
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

    /**
     * 添加商品
     * @param product
     */
    @Override
    public void addProduct(Product product) {
        // 添加商品前,先判断一下表里面有没有 已经存在的商品
        Product product1 = productMapper.selectProductByProductNum(product);

        if (product1 != null){
            throw new ProductException("商品已存在!");
        }
        // 处理img路径:
        String imgPath = fileAccessPath + product.getImgs();
        log.info("imgPath:{}",imgPath);

        product.setImgs(imgPath);
        productMapper.insert(product);
    }

    /**
     * 修改商品状态
     * @param product
     */
    @Override
    public void changeState(Product product) {
        productMapper.updateState(product);
    }

    /**
     * 批量删除product
     * @param productIdList
     */
    @Override
    public void deleteBatch(List<Integer> productIdList) {
        productMapper.deleteBatch(productIdList);
    }
}
