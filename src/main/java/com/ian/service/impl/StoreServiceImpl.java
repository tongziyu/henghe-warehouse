package com.ian.service.impl;

import com.ian.mapper.StoreMapper;
import com.ian.pojo.entity.Store;
import com.ian.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/17 13:30
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "com.ian.service.impl.StoreServiceImpl")
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;
    /**
     * 查询所有仓库
     * @return
     */
    @Cacheable(cacheNames = "storeList")
    @Override
    public List<Store> selectStoreList() {
        List<Store> stores = storeMapper.selectStoreList();
        return stores;
    }
}
