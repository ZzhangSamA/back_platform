package com.back.yh.service;

import com.back.yh.pojo.User;
import com.back.yh.vo.UserVo;

import java.util.List;

public interface UserService {
    User loginCheck(User user);

    int getCount(UserVo userVo);

    List<User> getUserPage(UserVo userVo);

    int addUser(User user);

    User getUser(Integer userId);
}
