package com.ian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ian.mapper.OutStoreMapper;
import com.ian.mapper.ProductMapper;
import com.ian.pojo.dto.OutStorePageDTO;
import com.ian.pojo.entity.OutStore;
import com.ian.pojo.entity.Product;
import com.ian.pojo.vo.OutStorePageVO;
import com.ian.service.OutStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private ProductMapper productMapper;

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

    /**
     * 修改出库状态
     * @param outStore
     */
    @Transactional
    @Override
    public void confirmOutStore(OutStore outStore) {
        /*
            出库之后,把商品的库存数量 - 出库数量
         */
        // 根据商品id查询商品
        Product product = productMapper.selectProductByProductId(outStore.getProductId());

        // 修改商品的库存数量
        product.setProductInvent(product.getProductInvent() - outStore.getOutNum());

        // 修改数据库商品数量
        productMapper.updateProductInventByProductId(product);

        // 确认出库
        outStore.setIsOut("1");
        outStoreMapper.updateIsOut(outStore);

    }
}
