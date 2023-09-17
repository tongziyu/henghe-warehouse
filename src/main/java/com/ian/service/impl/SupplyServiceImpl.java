package com.ian.service.impl;

import com.ian.mapper.SupplyMapper;
import com.ian.pojo.entity.Supply;
import com.ian.service.SupplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/17 14:04
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "com.ian.service.impl.SupplyServiceImpl")
public class SupplyServiceImpl implements SupplyService {
    @Autowired
    private SupplyMapper supplyMapper;
    /**
     * 查询所有供应商
     * @return
     */
    @Override
    public List<Supply> selectSupplyList() {

        return supplyMapper.SelectSupplyList();
    }
}
