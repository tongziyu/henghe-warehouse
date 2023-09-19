package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.dto.StorePageDTO;
import com.ian.pojo.entity.Store;
import com.ian.pojo.vo.StorePageVO;
import com.ian.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/19 14:44
 */
@RestController
@RequestMapping("/store")
@Slf4j
public class StoreController {

    @Autowired
    private StoreService storeService;

    /**
     * 分页查询仓库信息:
     * storeName=             & storeAddress=            &concat=          &phone=
     * &pageSize=5          &pageNum=1             &totalNum=0
     * @return
     */
    @GetMapping("/store-page-list")
    public Result storePageList(StorePageDTO storePageDTO){
        StorePageVO storePageVO = storeService.selectStorePage(storePageDTO);

        return Result.ok(storePageVO);
    }

}
