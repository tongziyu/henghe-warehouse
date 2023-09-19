package com.ian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ian.mapper.StoreMapper;
import com.ian.pojo.dto.StorePageDTO;
import com.ian.pojo.entity.Store;
import com.ian.pojo.vo.StorePageVO;
import com.ian.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/17 13:30
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "com.ian.service.impl.StoreServiceImpl")
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;

    /**
     * 查询所有仓库
     * 缓存中的key 必须要加 ' '
     * @return
     */
    @Cacheable(key = "'storeList'")
    @Override
    public List<Store> selectStoreList() {
        List<Store> stores = storeMapper.selectStoreList();
        return stores;
    }

    /**
     * 分页查询仓库,带条件
     * @param storePageDTO
     * @return
     */
    @Override
    public StorePageVO selectStorePage(StorePageDTO storePageDTO) {
        PageHelper.startPage(storePageDTO.getPageNum(),storePageDTO.getPageSize());

        List<Store> stores = storeMapper.selectStorePage(storePageDTO);

        PageInfo pageInfo = new PageInfo(stores);

        StorePageVO storePageVO = new StorePageVO();

        storePageVO.setTotalNum(pageInfo.getTotal());
        storePageVO.setResultList(pageInfo.getList());

        return storePageVO;
    }

    /**
     * 根据num查询仓库
     * @param storeNum
     * @return
     */
    @Override
    public Store checkStoreNum(String storeNum) {
        Store store = storeMapper.selectStoreByStoreNum(storeNum);
        return store;
    }

    /**
     * 新增仓库
     * @param store
     */
    @CacheEvict(key = "'storeList'")
    @Override
    public void addStore(Store store) {
        // 新增仓库前,首先先判断一下 新增仓库的仓库名是否存在,如果存在则抛出异常
        Store store1 = storeMapper.selectStoreByStoreName(store.getStoreName());

        if (store1 != null ){
            throw new RuntimeException("仓库名已存在!!");
        }
        // 新建仓库
        storeMapper.insert(store);
    }

    /**
     * 修改仓库信息
     * @param store
     */
    @CacheEvict(key = "'storeList'")
    @Override
    public void updateStore(Store store) {
        /*
        思路:
            - 修改仓库前,先判断该仓库名是否已经存在  store_name = #{storeName} and store_id != #{storeId}
         */
        Store store1 = storeMapper.selectStoreByStoreNameWithOutStoreId(store);

        if (store1 != null){
            throw new RuntimeException("仓库名已存在");
        }
        // 修改仓库
        storeMapper.updateStore(store);
    }

    /**
     * 删除仓库
     * @param storeId
     */
    @Override
    @CacheEvict(key = "'storeList'")
    public void deleteStore(Integer storeId) {
        storeMapper.deleteStoreByStoreId(storeId);
    }
}
