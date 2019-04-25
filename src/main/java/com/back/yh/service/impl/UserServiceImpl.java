package com.back.yh.service.impl;

import com.back.yh.mapper.UserMapper;
import com.back.yh.pojo.User;
import com.back.yh.service.UserService;
import com.back.yh.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
//        if(this.userMapper.loginCheck(user)!=null){
//            return true;
//        }
        return userMapper.loginCheck(user);
    }


    public int getCount(UserVo userVo) {
        return this.userMapper.getCount(userVo);
    }

    public List<User> getUserPage(UserVo userVo) {
        return this.userMapper.getUserPage(userVo);
    }

    public int addUser(User user) {
        return this.userMapper.addUser(user);
    }

    public User getUser(Integer userId) {
        return this.userMapper.getUser(userId);
    }
}
