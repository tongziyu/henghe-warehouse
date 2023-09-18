package com.ian.mapper;

import com.ian.pojo.entity.ProductType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 根据typeCode查询Type
     * @param typeCode
     */
    @Select("select * from product_type where type_code = #{typeCode}")
    ProductType selectTypeWithTypeCode(String typeCode);

    /**
     * 通过name和parentId查询type
     * @param productType
     * @return
     */
    @Select("select * from product_type where type_name = #{typeName} and parent_id = #{parentId}")
    ProductType selectTypeByNameWithParentId(ProductType productType);


    void insert(ProductType productType);

    /**
     * 通过父ID查询productType
     * @param typeId
     * @return
     */
    @Select("select * from product_type where parent_id = #{typeId}")
    List<ProductType> selectTypeByParentId(Integer typeId);

    @Delete("delete from product_type where type_id = #{typeId}")
    void delete(Integer typeId);
}
