package com.ian.service;

import com.ian.pojo.entity.Store;

import java.util.List;

public interface StoreService {
    /**
     * 查询所有仓库
     * @return
     */
    List<Store> selectStoreList();
}