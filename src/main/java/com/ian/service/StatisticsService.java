package com.ian.service;

import com.ian.pojo.entity.Statistics;

import java.util.List;

public interface StatisticsService {
    /**
     * 统计每个仓库中商品数量
     * @return
     */
    List<Statistics> statisticsStoreInvent();
}
