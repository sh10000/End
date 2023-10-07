package com.crud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crud.Dao.ApplicationDao;
import com.crud.Dao.UserInformDao;
import com.crud.domain.Application;
import com.crud.domain.User;
import com.crud.domain.UserInform;
import com.crud.service.ApplicationService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationDao, Application> implements ApplicationService {
    @Autowired
    private ApplicationDao applicationDao;
    @Autowired
    private UserInformDao userInformDao;
    @Override
    public boolean setUserApplication(Application application) {
        return applicationDao.insert(application)>0;
    }

    @Override
    public boolean update(Application application) {
        userInformDao.updateIsNullByName(application.getUser_id(),application.getHandleResult());
        return applicationDao.update(application)>0;
    }

    @Override
    public IPage<Application> getApplication(int currentPage, int PageSize, Application application) {
        LambdaQueryWrapper<Application> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(application.getUser_name()), Application::getUser_name, application.getUser_name());
        lqw.like(Strings.isNotEmpty(application.getApplication_data()), Application::getApplication_data, application.getApplication_data());
        lqw.like(Strings.isNotEmpty(application.getHandleResult()), Application::getHandleResult, application.getHandleResult());
        IPage<Application> page=new Page<>(currentPage,PageSize);
        applicationDao.selectPage(page,lqw);
        // 假设UserInform类中有setGroupName和getGroupName方法
        return page;
    }
}
