package com.ian.mapper;

import com.ian.pojo.dto.StorePageDTO;
import com.ian.pojo.entity.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    /**
     * 查询所有的仓库
     * @return
     */
    List<Store> selectStoreList();

    /**
     * 查询仓库 按条件
     * @param storePageDTO
     * @return
     */
    List<Store> selectStorePage(StorePageDTO storePageDTO);
}