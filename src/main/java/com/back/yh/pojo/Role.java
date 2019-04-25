package com.back.yh.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Role {
    int roleId;
    String roleName;
    String createTime;
    String updateTime;
    int status;
    List<String> userList;

    List<String> menuList;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updataTime) {
        this.updateTime = updataTime;
    }

    public List<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<String> menuList) {
        this.menuList = menuList;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updataTime='" + updateTime + '\'' +
                ", status=" + status +
                ", userList=" + userList +
                ", menuList=" + menuList +
                '}';
    }
}
