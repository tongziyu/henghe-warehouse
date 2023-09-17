package com.ian.service;

import com.ian.pojo.entity.ProductType;

import java.util.List;

public interface ProductTypeService {
    //查询所有商品分类树的业务方法
    public List<ProductType> allProductTypeTree();
}
