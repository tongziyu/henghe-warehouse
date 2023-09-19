package com.ian.service;

import com.ian.pojo.dto.OutStorePageDTO;
import com.ian.pojo.entity.OutStore;
import com.ian.pojo.vo.OutStorePageVO;

import java.util.List;

public interface OutStoreService {


    /**
     * 添加出库记录
     * @param outStore
     */
    void addOutStore(OutStore outStore);

    /**
     * 分页查询所有的outStore 带条件
     * @param outStorePageDTO
     * @return
     */
    OutStorePageVO selectOutStorePage(OutStorePageDTO outStorePageDTO);

    /**
     * 修改出库状态
     * @param outStore
     */
    void confirmOutStore(OutStore outStore);
}
