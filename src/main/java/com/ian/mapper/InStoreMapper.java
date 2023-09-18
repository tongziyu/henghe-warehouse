package com.ian.mapper;

import com.ian.pojo.dto.InStorePageDTO;
import com.ian.pojo.entity.InStore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InStoreMapper {
    List<InStore> selectInStorePage(InStorePageDTO inStorePageDTO);

    /**
     * 新增入库单
     * @param inStore
     */
    void insert(InStore inStore);
}