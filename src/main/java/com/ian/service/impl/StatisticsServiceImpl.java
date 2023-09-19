package com.ian.service.impl;

import com.ian.mapper.StatisticsMapper;
import com.ian.pojo.entity.Statistics;
import com.ian.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/19 14:33
 */
@Service
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsMapper statisticsMapper;

    /**
     * 统计每个仓库中商品数量
     * @return
     */
    @Override
    public List<Statistics> statisticsStoreInvent() {
        List<Statistics> statistics = statisticsMapper.statisticsStoreInvent();
        return statistics;
    }
}
