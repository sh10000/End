package com.crud.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChartDao {
    @Select("select chartname from chartname where chartid=#{id}")
    String getChartName(Integer id);
}
