package com.ian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ian.mapper.OutStoreMapper;
import com.ian.pojo.dto.OutStorePageDTO;
import com.ian.pojo.entity.OutStore;
import com.ian.pojo.vo.OutStorePageVO;
import com.ian.service.OutStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 分页查询所有的outStore 带条件
     * @param outStorePageDTO
     * @return
     */
    @Override
    public OutStorePageVO selectOutStorePage(OutStorePageDTO outStorePageDTO) {
        PageHelper.startPage(outStorePageDTO.getPageNum(),outStorePageDTO.getPageSize());
        List<OutStore> outStoreList = outStoreMapper.selectOutStorePage(outStorePageDTO);
        PageInfo pageInfo = new PageInfo(outStoreList);
        OutStorePageVO outStorePageVO = new OutStorePageVO();
        outStorePageVO.setTotalNum(pageInfo.getTotal());
        outStorePageVO.setResultList(pageInfo.getList());

        return outStorePageVO;
    }
}
