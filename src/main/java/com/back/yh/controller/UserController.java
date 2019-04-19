package com.back.yh.controller;

import com.back.yh.pojo.User;
import com.back.yh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "loginCheck" ,method = RequestMethod.POST)
    public Object loginCheck(@RequestBody User user, HttpSession httpSession){
        Boolean flag=false;
        System.out.println("userName="+user.getUserName()+",password="+user.getPassword());
        flag = this.userService.loginCheck(user);
        if(flag){
            //登录成功,保存
            httpSession.setAttribute("user",user);
        }
        return flag.toString();
    }
}
