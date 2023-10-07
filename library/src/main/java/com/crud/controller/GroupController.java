package com.crud.controller;

import com.crud.domain.GroupIdAndId;
import com.crud.controller.utils.R;
import com.crud.domain.Group;
import com.crud.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @PostMapping()
    public R addNewGroup(@RequestBody Group group){
        boolean b = groupService.addGroup(group);
        return  new R(b,"增加成功");
    }
    @PutMapping("/user")
    public R update(@RequestBody GroupIdAndId groupIdAndId){
        return new R(groupService.groupAddUser(groupIdAndId.getGroupid(), groupIdAndId.getId()));
    }
    @GetMapping()
    public R getGroup(){
        return new R(true,groupService.getGroup());
    }
    @DeleteMapping()
    public R DeleteGroup(@RequestParam Integer groupid){
        return new R(true,groupService.deleteGroup(groupid));
    }
    @PutMapping()
    public  R modifyGroupName(@RequestBody Group group){
        return new R(true,groupService.modifyGroup(group));
    }

}
