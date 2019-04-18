package com.back.yh.controller;

import com.back.yh.pojo.User;
import com.back.yh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "loginCheck" ,method = RequestMethod.POST)
    public Object loginCheck(@RequestBody User user){
        Boolean flag=false;
        System.out.println("userName="+user.getUserName()+",password="+user.getPassword());
        User user1 = this.userService.loginCheck(user);
        if(user1!=null){
            flag=true;
        }
        return flag.toString();
    }
}
