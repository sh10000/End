package com.crud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crud.domain.Application;
import com.crud.domain.UserInform;

import java.util.List;

public interface ApplicationService {
    boolean setUserApplication(Application application);
    boolean update(Application application);
    IPage<Application> getApplication(int currentPage, int PageSize, Application application);
}
