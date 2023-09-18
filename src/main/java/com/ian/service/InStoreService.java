package com.ian.service;

import com.ian.pojo.dto.InStorePageDTO;
import com.ian.pojo.entity.BuyList;
import com.ian.pojo.entity.InStore;
import com.ian.pojo.vo.InStorePageVo;

/**
 * @author tongziyu
 */
public interface InStoreService {
    /**
     * 入库分页查询
     * @param inStorePageDTO
     * @return
     */
    InStorePageVo QueryInStorePage(InStorePageDTO inStorePageDTO);

    /**
     * 生成入库单
     * @param inStore
     */
    void addInWarehouse(InStore inStore, BuyList buyList);

    /**
     * 确认入库
     * @param inStore
     */
    void updateConfirm(InStore inStore);
}
