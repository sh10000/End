package com.crud.service;

import com.crud.domain.UserInform;

public interface PersonalServer {
    UserInform getInform();
    boolean update(UserInform userInform);
}
