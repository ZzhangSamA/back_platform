package com.back.yh.service;

import com.back.yh.pojo.User;
import com.back.yh.vo.UserVo;

import java.util.List;
import java.util.Map;

public interface UserService {
    //登录
    User loginCheck(User user);
    //获取数据分页
    List<User> getUserPage(UserVo userVo);
    //获取数据条数
    int getCount(UserVo userVo);
    //添加
    int addUser(User user);
    //用户信息回显
    User getUser(Integer userId);
    //修改
    int updateUser(User user);
    //单个删除
    int delUser(int userId);
    //批量删除
    boolean batchDelUser(Map map);
}
