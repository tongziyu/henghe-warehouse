package com.ian.service.impl;

import com.ian.mapper.PlaceMapper;
import com.ian.pojo.entity.Place;
import com.ian.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/17 19:47
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "com.ian.service.impl.PlaceServiceImpl")
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceMapper placeMapper;

    /**
     * 查询所有的产地信息
     * @return
     */
    @Override
    @Cacheable(cacheNames = "placeList")
    public List<Place> selectPlaceList() {
        return placeMapper.selectPlaceList();
    }
}
