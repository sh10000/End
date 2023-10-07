package com.crud.controller;

import com.crud.controller.utils.R;
import com.crud.service.impl.MessageServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    public MessageServicelmpl messageServicelmpl;

    @GetMapping()
    public R getMessage(@RequestParam Integer id){
        return new R(true,messageServicelmpl.getMessage(id));
    }
    @PostMapping()
    public R update(@RequestParam Integer id){
        return new R(messageServicelmpl.updateMessage(id));
    }
}
