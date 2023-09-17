package com.ian.service;

import com.ian.pojo.entity.Place;

import java.util.List;

public interface PlaceService {
    /**
     * 查询所有的产地信息
     * @return
     */
    List<Place> selectPlaceList();
}
