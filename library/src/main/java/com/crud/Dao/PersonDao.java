package com.crud.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crud.domain.UserInform;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonDao extends BaseMapper<UserInform> {
    @Select("SELECT id, username, address,number, isnull, gasid, groupid, price\n" +
            "FROM user_inform\n" +
            "WHERE id IN (\n" +
            "    SELECT id \n" +
            "    FROM user\n" +
            "    WHERE username = #{username}\n" +
            ");")
    UserInform getByUsername(String username);
}
