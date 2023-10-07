package com.crud.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crud.controller.utils.R;
import com.crud.domain.Application;
import com.crud.domain.UserInform;
import com.crud.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable  int pageSize, Application application){

        IPage<Application> page = applicationService.getApplication(currentPage, pageSize, application);
        if(currentPage>page.getPages()){
            page = applicationService.getApplication((int)page.getPages(), pageSize, application);
        }
        return  new R(true,page);
    }
    @PutMapping
    public R update(@RequestBody Application application){
        return new R(applicationService.update(application));
    }
    @PostMapping
    public R insert(@RequestBody Application application){
        return new R(applicationService.setUserApplication(application));
    }

}
