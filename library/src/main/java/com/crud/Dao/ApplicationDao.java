package com.crud.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crud.domain.Application;

import com.crud.domain.Group;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ApplicationDao extends BaseMapper<Application> {
    @Insert("insert into application(user_id,user_name,application_data,application_reason,number,handleby,handleResult) values (#{user_id},#{user_name},#{application_data},#{application_reason},#{number},#{handleby},#{handleResult})")
    int insert(Application application);
    @Update("update application set handleResult =#{handleResult},handleby=#{handleby} where id=#{id}")
    int update(Application application);
}
