package com.crud.controller;

import com.crud.controller.utils.R;
import com.crud.domain.Group;
import com.crud.domain.UserInform;
import com.crud.service.PersonalServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonalServer personal;
    @GetMapping()
    public R getUsername(){
        UserInform b = personal.getInform();
        return  new R(true,b);
    }
    @PutMapping
    public R update(@RequestBody UserInform userInform){
        return new R(personal.update(userInform));
    }
}
