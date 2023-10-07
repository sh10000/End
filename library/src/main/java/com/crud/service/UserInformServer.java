package com.crud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crud.domain.UserInform;

public interface UserInformServer extends IService<UserInform>  {

    IPage<UserInform> getPage(int currentPage, int PageSize, UserInform userInfrom);

    boolean modify(UserInform userInform);

    boolean delete(Integer id);
}
