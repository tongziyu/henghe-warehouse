package com.ian.service;

import com.ian.pojo.entity.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有的品牌
     * @return
     */
    List<Brand> selectBrandList();
}
