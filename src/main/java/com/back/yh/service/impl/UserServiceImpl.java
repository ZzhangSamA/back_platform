package com.back.yh.service.impl;

import com.back.yh.mapper.UserMapper;
import com.back.yh.pojo.User;
import com.back.yh.service.UserService;
import com.back.yh.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    /**
     * 获取数据条数
     * @param userVo
     * @return
     */
    public int getCount(UserVo userVo) {
        return this.userMapper.getCount(userVo);
    }

    /**
     * 获取用户信息与分页
     * @param userVo
     * @return
     */
    public List<User> getUserPage(UserVo userVo) {
        return this.userMapper.getUserPage(userVo);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user) {
        return this.userMapper.addUser(user);
    }

    /**
     * 根据ID获取信息回显
     * @param userId
     * @return
     */
    public User getUser(Integer userId) {
        return this.userMapper.getUser(userId);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int updateUser(User user) {
        return this.userMapper.updateUser(user);
    }

    /**
     * 删除用户(单个删除)
     * @param userId
     * @return
     */
    public int delUser(int userId) {
        return this.userMapper.delUser(userId);
    }

    /**
     * 批量删除
     * @param map
     * @return
     */
    public boolean batchDelUser(Map map) {
        if(this.userMapper.batchDelUser(map)>0){
            return true;
        }
        return false;
    }
}
