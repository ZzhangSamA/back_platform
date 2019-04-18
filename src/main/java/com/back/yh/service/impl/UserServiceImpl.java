package com.back.yh.service.impl;

import com.back.yh.mapper.UserMapper;
import com.back.yh.pojo.User;
import com.back.yh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserMapper userMapper;

    /**
     * 登录验证
     * @param user
     * @return
     */
    public User loginCheck(User user) {
        return this.userMapper.loginCheck(user);
    }
}
