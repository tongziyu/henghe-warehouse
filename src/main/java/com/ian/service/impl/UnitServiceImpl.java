package com.ian.service.impl;

import com.ian.mapper.UnitMapper;
import com.ian.pojo.entity.Unit;
import com.ian.service.UnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/17 19:58
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "com.ian.service.impl.UnitServiceImpl")
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitMapper unitMapper;

    /**
     * 查询所有的单位
     * @return
     */
    @Override
    public List<Unit> selectUnitList() {

        return unitMapper.selectUnitList();
    }
}
