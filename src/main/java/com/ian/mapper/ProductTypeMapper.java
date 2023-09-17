package com.ian.mapper;

import com.ian.pojo.entity.ProductType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/17 16:17
 */
@Mapper
public interface ProductTypeMapper {
    //查询所有商品分类的方法
    public List<ProductType> findAllProductType();
}
