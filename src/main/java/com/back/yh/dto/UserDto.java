package com.back.yh.dto;

import com.back.tools.SplitPage;
import com.back.yh.pojo.User;

import java.util.List;

public class UserDto {
    //当前页数据
    List<User> userList;
    //分页数据
    SplitPage splitPage;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public SplitPage getSplitPage() {
        return splitPage;
    }

    public void setSplitPage(SplitPage splitPage) {
        this.splitPage = splitPage;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userList=" + userList +
                ", splitPage=" + splitPage +
                '}';
    }
}
