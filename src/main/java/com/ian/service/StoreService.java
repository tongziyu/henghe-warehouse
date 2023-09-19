package com.ian.service;

import com.ian.pojo.dto.InStorePageDTO;
import com.ian.pojo.dto.StorePageDTO;
import com.ian.pojo.entity.InStore;
import com.ian.pojo.entity.Store;
import com.ian.pojo.vo.StorePageVO;

import java.util.List;

public interface StoreService {
    /**
     * 查询所有仓库
     * @return
     */
    List<Store> selectStoreList();


    /**
     * 分页查询仓库,带条件
     * @param storePageDTO
     * @return
     */
    StorePageVO selectStorePage(StorePageDTO storePageDTO);

    /**
     * 根据num查询仓库
     * @param storeNum
     * @return
     */
    Store checkStoreNum(String storeNum);

    /**
     * 新增仓库
     * @param store
     */
    void addStore(Store store);
}
