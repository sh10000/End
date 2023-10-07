package com.crud.service;

import com.crud.domain.Group;
import com.crud.domain.UserInform;

import java.util.List;

public interface GroupService {
    boolean addGroup(Group group);
    boolean groupAddUser(Integer userId,Integer id);
    List<Group> getGroup();

    boolean deleteGroup(Integer group);
    boolean modifyGroup(Group group);
}
