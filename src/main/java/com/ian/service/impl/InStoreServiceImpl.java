package com.ian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ian.mapper.BuyListMapper;
import com.ian.mapper.InStoreMapper;
import com.ian.pojo.dto.InStorePageDTO;
import com.ian.pojo.entity.BuyList;
import com.ian.pojo.entity.InStore;
import com.ian.pojo.vo.InStorePageVo;
import com.ian.service.InStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/19 01:06
 */
@Service
@Slf4j
public class InStoreServiceImpl implements InStoreService {
    @Autowired
    private InStoreMapper inStoreMapper;

    @Autowired
    private BuyListMapper buyListMapper;

    /**
     * 入库分页查询
     * @param inStorePageDTO
     * @return
     */
    @Override
    public InStorePageVo QueryInStorePage(InStorePageDTO inStorePageDTO) {
        PageHelper.startPage(inStorePageDTO.getPageNum(),inStorePageDTO.getPageSize());
        List<InStore> inStores = inStoreMapper.selectInStorePage(inStorePageDTO);

        PageInfo pageInfo = new PageInfo(inStores);
        InStorePageVo inStorePageVo = new InStorePageVo();
        inStorePageVo.setTotalNum(pageInfo.getTotal());
        inStorePageVo.setResultList(pageInfo.getList());

        return inStorePageVo;
    }

    /**
     * 生成入库单
     * @param inStore
     */
    @Override
    @Transactional
    public void addInWarehouse(InStore inStore, BuyList buyList) {
        // 入库
        inStoreMapper.insert(inStore);
        buyList.setIsIn("1");
        // 入库成功后,将buyList表中的is_in 设置为1
        buyListMapper.updateIsIn(buyList);
    }
}
