package com.ian.service;

import com.ian.pojo.entity.Unit;

import java.util.List;

public interface UnitService {
    /**
     * 查询所有的单位
     * @return
     */
    List<Unit> selectUnitList();
}
