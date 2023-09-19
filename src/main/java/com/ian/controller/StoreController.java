package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.dto.StorePageDTO;
import com.ian.pojo.entity.Store;
import com.ian.pojo.vo.StorePageVO;
import com.ian.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 查询storeNum存不存在
     * @return
     */
    @GetMapping("/store-num-check")
    public Result storeNumCheck(String storeNum){
        Store store = storeService.checkStoreNum(storeNum);
        return Result.ok(store == null);
    }

    @PostMapping("/store-add")
    public Result addStore(@RequestBody Store store){
        log.info("新增仓库:{}",store);

        storeService.addStore(store);
        return Result.ok();
    }

    /**
     * 修改仓库信息
     * @param store
     * @return
     */
    @PutMapping("/store-update")
    public Result updateStore(@RequestBody Store store){
        log.info("修改仓库信息:{}",store);
        storeService.updateStore(store);
        return Result.ok("修改成功!!");
    }


    /**
     * 删除仓库
     * @return
     */
    @DeleteMapping("/store-delete/{storeId}")
    public Result deleteStore(@PathVariable Integer storeId){
        storeService.deleteStore(storeId);
        return Result.ok("删除成功!!");
    }

    /**
     * 导出数据
     */
    @GetMapping("/exportTable")
    public Result exportTable(StorePageDTO storePageDTO){
        StorePageVO storePageVO = storeService.selectStorePage(storePageDTO);

        return Result.ok(storePageVO);
    }
}
