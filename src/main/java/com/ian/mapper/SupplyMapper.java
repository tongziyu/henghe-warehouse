package com.ian.mapper;

import com.ian.pojo.entity.Supply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SupplyMapper {

    /**
     * 查询所有供应商
     * @return
     */
    @Select("select * from supply where is_delete = 0")
    List<Supply> SelectSupplyList();

}