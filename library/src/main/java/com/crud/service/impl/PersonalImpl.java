package com.crud.service.impl;

import com.crud.Dao.PersonDao;
import com.crud.domain.UserInform;;
import com.crud.service.PersonalServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class PersonalImpl implements PersonalServer {
    @Autowired
    private PersonDao personDao;

    @Override
    public UserInform getInform() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        UserInform userInfo = personDao.getByUsername(username);
        return userInfo;
    }

    @Override
    public boolean update(UserInform userInform) {
        return personDao.updateById(userInform)>0;
    }
}
