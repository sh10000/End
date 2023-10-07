package com.crud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crud.Dao.UserDao;
import com.crud.Dao.UserInformDao;
import com.crud.domain.User;
import com.crud.domain.UserInform;
import com.crud.service.UserInformServer;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInformServiceimpl extends ServiceImpl<UserInformDao, UserInform>  implements UserInformServer {
    @Autowired
    private UserInformDao userInformDao;
    @Autowired
    private UserDao userDao;

    @Override
    public IPage<UserInform> getPage(int currentPage, int PageSize, UserInform userInfrom) {
        LambdaQueryWrapper<UserInform> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(userInfrom.getUsername()), UserInform::getUsername, userInfrom.getUsername());
        lqw.like(Strings.isNotEmpty(userInfrom.getIsnull()), UserInform::getIsnull, userInfrom.getIsnull());
        if(userInfrom.getGroupid() != null) {
            lqw.like(UserInform::getGroupid, userInfrom.getGroupid());
        }
        IPage<UserInform> page=new Page<>(currentPage,PageSize);
        userInformDao.selectPage(page,lqw);
        // 假设UserInform类中有setGroupName和getGroupName方法
        List<UserInform> filteredRecords = new ArrayList<>();

        for (UserInform u : page.getRecords()) {
            User user = userDao.findById(u.getId());
            if(user.getIsuse()==null||user.getIsuse() != 1){
                UserInform result = userInformDao.selectByGroupidUserInform(u.getGroupid());
                // 将查询结果中的group_name设置到当前记录中
                if (result != null) {
                    u.setGroupname(result.getGroupname());
                    filteredRecords.add(u);
                }
            }

        }
        page.setRecords(filteredRecords);
        return page;
    }

    @Override
    public boolean modify(UserInform userInform) {
        return userInformDao.updateById(userInform)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return userInformDao.updateIsUserById(id)>0;
    }


}
