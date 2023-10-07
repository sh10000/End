package com.crud.service.impl;

import com.crud.Dao.MessageDao;
import com.crud.domain.Message;
import com.crud.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServicelmpl implements MessageService {
    @Autowired
    public MessageDao messageDao;
    @Override
    public Message getMessage(Integer userId) {
        return messageDao.getGroup(userId);
    }

    @Override
    public Boolean updateMessage(Integer Id) {
       return messageDao.update(Id)>0;
    }
}
