package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.entity.OutStore;
import com.ian.service.OutStoreService;
import com.ian.utils.CurrentUser;
import com.ian.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
