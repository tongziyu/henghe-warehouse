package com.ian.mapper;

import com.ian.pojo.dto.StorePageDTO;
import com.ian.pojo.entity.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 通过StoreNum查询Store
     * @param storeNum
     * @return
     */
    @Select("select * from store where store_num = #{storeNum}")
    Store selectStoreByStoreNum(String storeNum);

    /**
     * 通过storeName查询store
     * @param storeName
     * @return
     */
    @Select("select * from store where store_name = #{storeName}")
    Store selectStoreByStoreName(String storeName);

    /**
     * 新增仓库
     * @param store
     */
    void insert(Store store);
}