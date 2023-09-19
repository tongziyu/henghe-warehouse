package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.entity.Statistics;
import com.ian.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/19 14:15
 */
@RestController
@RequestMapping("/statistics")
@Slf4j
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    /**
     * 统计仓库的商品数量
     * @return
     */
    @GetMapping("/store-invent")
    public Result storeInvent(){
        List<Statistics> statistics = statisticsService.statisticsStoreInvent();

        return Result.ok(statistics);
    }
}
