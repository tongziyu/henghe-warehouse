package com.ian.mapper;

import com.ian.pojo.dto.Page;
import com.ian.pojo.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductMapper {

    //查询商品总行数的方法
    int selectProductCount(Product product);

    //分页查询商品的方法
    List<Product> selectProductPage(@Param("page") Page page, @Param("product") Product product);


    /**
     * 插入数据
     * @param product
     */
    void insert(Product product);

    /**
     * 通过product_num查询商品
     * @return
     */
    @Select("select * from product where product_num = #{productNum}")
    Product selectProductByProductNum(Product product);

    /**
     * 修改商品状态
     * @param product
     */
    @Update("update product set up_down_state = #{upDownState} where product_id = #{productId}")
    void updateState(Product product);
}
