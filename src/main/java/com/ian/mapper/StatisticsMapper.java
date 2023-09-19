package com.ian.mapper;

import com.ian.pojo.entity.Statistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {


    /**
     * 统计仓库的商品数量
     * @return
     */
    List<Statistics> statisticsStoreInvent();

}
