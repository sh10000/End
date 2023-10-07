package com.crud.service;

import com.crud.domain.Message;

public interface MessageService {
    Message getMessage(Integer userId);
    Boolean updateMessage(Integer id);
}
