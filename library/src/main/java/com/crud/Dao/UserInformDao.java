package com.crud.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crud.domain.UserInform;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserInformDao extends BaseMapper<UserInform> {
    @Select("select groupname from `group` where groupid=#{groupid}")
    UserInform selectByGroupidUserInform(Integer groupid);


    @Update("update user set isuse=1 where id=#{id}")
    int updateIsUserById(Integer id);
    @Select("select gasid from user_inform where username=#{username}")
    Integer selectByUsername(String username);

    @Update("update user_inform set isnull=#{isnull} where id=#{id}")
    int updateIsNullByName(Integer id,String isnull);
}
