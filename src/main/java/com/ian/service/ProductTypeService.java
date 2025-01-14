package com.ian.service;

import com.ian.pojo.Result;
import com.ian.pojo.entity.ProductType;

import java.util.List;

public interface ProductTypeService {
    //查询所有商品分类树的业务方法
    List<ProductType> allProductTypeTree();

    /**
     * 验证新增商品种类的id是否已存在
     * @param typeCode
     */
    ProductType verifyTypeCode(String typeCode);

    /**
     * 添加分类
     * @param productType
     */
    void addType(ProductType productType);

    /**
     * 通过id删除分类,已经删除子分类
     * @param typeId
     */
    void deleteById(Integer typeId);

    /**
     * 修改分类
     * @param productType
     */
    void updateType(ProductType productType);
}
