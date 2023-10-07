package com.crud.Dao;

import com.crud.domain.Group;
import com.crud.domain.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MessageDao {
    @Select("select id,isread,msg from msg where userid=#{id}")
    Message getGroup(Integer id);

    @Update("update msg set isread = 'true' where id = #{id}")
    Integer update(int id);

}
