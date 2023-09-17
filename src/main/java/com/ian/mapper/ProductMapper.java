package com.ian.mapper;

import com.ian.pojo.dto.Page;
import com.ian.pojo.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    //查询商品总行数的方法
    public int selectProductCount(Product product);

    //分页查询商品的方法
    public List<Product> selectProductPage(@Param("page") Page page, @Param("product") Product product);


}
