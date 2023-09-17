package com.ian.service;

import com.ian.pojo.entity.Supply;

import java.util.List;

public interface SupplyService {
    /**
     * 查询所有供应商
     * @return
     */
    List<Supply> selectSupplyList();
}
