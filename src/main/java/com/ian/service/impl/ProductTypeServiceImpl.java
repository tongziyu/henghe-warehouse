package com.ian.service.impl;

import com.ian.exception.ProductCategoryException;
import com.ian.mapper.ProductTypeMapper;
import com.ian.pojo.Result;
import com.ian.pojo.entity.ProductType;
import com.ian.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/17 16:19
 */
@Service
@CacheConfig(cacheNames = "com.ian.service.impl.ProductTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;

    /**
     * 查询所有商品分类树的业务方法
     * @return
     */
    //对查询到的所有商品分类树进行缓存,缓存到redis的键为all:typeTree
    @Cacheable(key = "'all:typeTree'")
    @Override
    public List<ProductType> allProductTypeTree() {
        //查询所有商品分类
        List<ProductType> allTypeList = productTypeMapper.findAllProductType();
        //将所有商品分类List<ProductType>转成商品分类树List<ProductType>
        List<ProductType> typeTreeList = allTypeToTypeTree(allTypeList, 0);
        //返回商品分类树List<ProductType>
        return typeTreeList;
    }

    //将查询到的所有商品分类List<ProductType>转成商品分类树List<ProductType>的算法
    private List<ProductType> allTypeToTypeTree(List<ProductType> allTypeList, Integer parentId){

        List<ProductType> typeList = new ArrayList<>();
        for (ProductType productType : allTypeList) {
            if(productType.getParentId().equals(parentId)){
                typeList.add(productType);
            }
        }

        for (ProductType productType : typeList) {
            List<ProductType> childTypeList = allTypeToTypeTree(allTypeList, productType.getTypeId());
            productType.setChildProductCategory(childTypeList);
        }

        return typeList;
    }
    /**
     * 验证新增商品种类的id是否已存在
     * @param typeCode
     */
    @Override
    public ProductType verifyTypeCode(String typeCode) {
        ProductType productType = productTypeMapper.selectTypeWithTypeCode(typeCode);

        return productType;
    }

    /**
     * 添加分类
     * 删除缓存
     * @param productType
     */
    @Override
    @CacheEvict(key = "'all:typeTree'")
    public void addType(ProductType productType) {
        /*
        思路:
            - 插入分类的时候,需要需要判断一下 在父类ID相同的情况下,type_name是不是已经存在
         */
        ProductType productType1 = productTypeMapper.selectTypeByNameWithParentId(productType);

        if (productType1 != null){
            throw new ProductCategoryException("分类名称已存在!!!");
        }
        // 插入分类
        productTypeMapper.insert(productType);
    }

    /**
     * 通过id删除分类,以及删除子分类
     * @param typeId
     */
    @Override
    @CacheEvict(key = "'all:typeTree'")
    public void deleteById(Integer typeId) {
        /*
        思路: 通过id查找有没有子类,  select * from product_type where parentId =#{typeId}
             如果有子类,则将子类全部删除
         */
        List<ProductType> productTypesList = productTypeMapper.selectTypeByParentId(typeId);

        if (productTypesList != null && productTypesList.size() > 0){
            for (ProductType pt : productTypesList){
                productTypeMapper.delete(pt.getTypeId());
            }
        }
        productTypeMapper.delete(typeId);
    }


    /**
     * 修改分类
     * @param productType
     */
    @Override
    @CacheEvict(key = "'all:typeTree'")
    public void updateType(ProductType productType) {
        /*
        思路:
            - 修改分类的时候,需要需要判断一下 在父类ID相同的情况下, type_name 是不是已经存在
         */
        ProductType productType1 = productTypeMapper.selectTypeByNameWithParentId(productType);

        if (productType1 != null){
            throw new ProductCategoryException("分类名称已存在!!!");
        }

        productTypeMapper.update(productType);
    }
}
