package com.ian.mapper;

import com.ian.pojo.entity.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UnitMapper {

    /**
     * 查询所有的单位信息
     * @return
     */
    @Select("select * from unit")
    List<Unit> selectUnitList();
}