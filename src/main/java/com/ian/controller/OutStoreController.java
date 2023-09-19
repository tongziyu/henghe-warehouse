package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.dto.OutStorePageDTO;
import com.ian.pojo.entity.OutStore;
import com.ian.pojo.vo.OutStorePageVO;
import com.ian.service.OutStoreService;
import com.ian.service.StoreService;
import com.ian.utils.CurrentUser;
import com.ian.utils.TokenUtils;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/18 19:15
 */
@RestController
@Slf4j
@RequestMapping("/outstore")
public class OutStoreController {
    @Autowired
    private OutStoreService outStoreService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private StoreService storeService;

    /**
     * 添加出库单
     * @return
     */
    @PostMapping("/outstore-add")
    public Result addOutStroe(@RequestBody OutStore outStore,
                              @RequestHeader("token") String token){
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);

        outStore.setTallyId(currentUser.getUserId());

        outStore.setCreateBy(currentUser.getUserId());

        outStore.setIsOut("0");

        log.info("出库记录:{}",outStore);
        outStoreService.addOutStore(outStore);
        return Result.ok("出库成功");
    }

    /**
     * 查询所有的仓库
     * @return
     */
    @GetMapping("/store-list")
    public Result storeList(){
        return Result.ok(storeService.selectStoreList());
    }

    /**
     * 分页查询出库列表 带条件
     * /outstore-page-list?   storeId=1     &productName=     &startTime=     &endTime=
     *  &isOut=      &pageSize=5     &pageNum=1     &totalNum=0
     * @return
     */
    @GetMapping("/outstore-page-list")
    public Result outStorePageList(OutStorePageDTO outStorePageDTO){
        log.info("分页查询出库列表:{}",outStorePageDTO);
        OutStorePageVO outStorePageVO = outStoreService.selectOutStorePage(outStorePageDTO);
        return Result.ok(outStorePageVO);
    }

    /**
     * 确认出库
     * @param outStore
     * @return
     */
    @PutMapping("/outstore-confirm")
    public Result outStoreConfirm(@RequestBody OutStore outStore){
        log.info("确认出库信息:{}",outStore);
        outStoreService.confirmOutStore(outStore);
        return Result.ok();
    }
}
