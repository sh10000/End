package com.crud.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crud.domain.Group;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GroupDao extends BaseMapper<Group> {

    @Insert("insert into `group`(groupname,address,inform) values (#{groupname},#{address},#{inform})")
    int insert(Group group);

    @Update("update user_inform set groupid=#{groupid} where id=#{id}")
    int updateGroup(Integer groupid,Integer id);

    @Select("select * from `group`")
    List<Group> getGroup();

    @Update("update user_inform set groupid = 0 where groupid = #{groupid}")
    int updateUserGroupidToZero(int groupid);

    @Delete("delete from `group`  where groupid = #{groupid}")
    int deleteUsersByGroupid(int groupid);

    @Update("UPDATE `group` SET groupname=#{groupname} where groupid=#{groupid}")
    int updateGroupName(Group group);
}
