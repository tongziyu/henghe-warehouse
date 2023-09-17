package com.ian.service.impl;

import com.ian.mapper.BrandMapper;
import com.ian.pojo.entity.Brand;
import com.ian.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@CacheConfig(cacheNames = "com.ian.service.impl.BrandServiceImpl")
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询所有的品牌,并放入缓存中
     * @return
     */
    @Cacheable(cacheNames = "brandList")
    @Override
    public List<Brand> selectBrandList() {
        return brandMapper.selectBrandList();
    }
}
