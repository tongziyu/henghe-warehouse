package com.ian.mapper;

import com.ian.pojo.dto.OutStorePageDTO;
import com.ian.pojo.entity.OutStore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OutStoreMapper {
    /**
     * 添加出库记录
     * @param outStore
     */
    void insertOutStore(OutStore outStore);

    /**
     * 分页查询所有的出库记录,带条件
     * @param outStorePageDTO
     * @return
     */
    List<OutStore> selectOutStorePage(OutStorePageDTO outStorePageDTO);

    /**
     * 修改出库状态
     * @param outStore
     */
    @Update("update out_store set is_out = #{isOut} where outs_id = #{outsId}")
    void updateIsOut(OutStore outStore);
}