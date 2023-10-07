package com.crud.service.impl;

import com.crud.Dao.GroupDao;
import com.crud.domain.Group;
import com.crud.domain.UserInform;
import com.crud.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;
    @Override
    public boolean addGroup(Group group) {
        return groupDao.insert(group)>0;
    }

    @Override
    public boolean groupAddUser(Integer groupid, Integer id) {
        return groupDao.updateGroup(groupid,id)>0;
    }

    @Override
    public List<Group> getGroup() {
        return  groupDao.getGroup();
    }

    @Override
    public boolean deleteGroup(Integer group) {
        groupDao.updateUserGroupidToZero(group);
       return groupDao.deleteUsersByGroupid(group)>0;
    }

    @Override
    public boolean modifyGroup(Group group) {
        return groupDao.updateGroupName(group)>0;
    }


}
