package com.ian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ian.mapper.InStoreMapper;
import com.ian.pojo.dto.InStorePageDTO;
import com.ian.pojo.entity.InStore;
import com.ian.pojo.vo.InStorePageVo;
import com.ian.service.InStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
