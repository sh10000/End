package com.crud.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crud.controller.utils.R;
import com.crud.domain.UserInform;
import com.crud.service.UserInformServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserInformController {
    @Autowired
    private UserInformServer userInformService;
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable  int pageSize, UserInform userInform){

        IPage<UserInform> page = userInformService.getPage(currentPage, pageSize, userInform);
        if(currentPage>page.getPages()){
            page = userInformService.getPage((int)page.getPages(), pageSize, userInform);
        }
        return  new R(true,page);
    }
    @PutMapping
    public R update(@RequestBody UserInform userInform){
        return new R(userInformService.modify(userInform));
    }
    @GetMapping("{id}")
    public R getById(@PathVariable    Integer id){
        if(userInformService.getById(id)!=null){
            return  new R(true,userInformService.getById(id));
        }
        return  new R(false,userInformService.getById(id));
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(userInformService.delete(id));
    }
}
