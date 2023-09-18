package com.ian.service.impl;

import com.ian.mapper.OutStoreMapper;
import com.ian.pojo.entity.OutStore;
import com.ian.service.OutStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/18 19:18
 */
@Service
@Slf4j
public class OutStoreServiceImpl implements OutStoreService {
    @Autowired
    private OutStoreMapper outStoreMapper;

    /**
     * 添加出库记录
     * @param outStore
     */
    @Override
    public void addOutStore(OutStore outStore) {
        outStore.setOutPrice(outStore.getSalePrice());

        outStoreMapper.insertOutStore(outStore);
    }
}
