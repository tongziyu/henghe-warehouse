package com.ian.mapper;

import com.ian.pojo.entity.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BrandMapper {
    /**
     * 查询所有的品牌
     * @return
     */
    @Select("select * from brand")
    List<Brand> selectBrandList();
}