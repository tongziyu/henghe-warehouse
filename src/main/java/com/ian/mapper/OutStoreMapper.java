package com.ian.mapper;

import com.ian.pojo.entity.OutStore;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OutStoreMapper {
    /**
     * 添加出库记录
     * @param outStore
     */
    void insertOutStore(OutStore outStore);
}