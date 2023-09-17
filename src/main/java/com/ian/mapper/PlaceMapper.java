package com.ian.mapper;

import com.ian.pojo.entity.Place;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlaceMapper {

    @Select("select * from place where is_delete = 0")

    List<Place> selectPlaceList();

}