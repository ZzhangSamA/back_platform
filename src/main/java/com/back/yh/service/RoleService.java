package com.back.yh.service;

import com.back.yh.pojo.Menu;
import com.back.yh.pojo.Role;
import com.back.yh.pojo.User;
import com.back.yh.vo.RoleVo;

import java.util.List;

public interface RoleService {

    public Integer getTotalRole();

    public List<Role> initRolePage(Role role);

    public List<Menu> getMenuListForRole();
    public List<User> getUserListForRole();

    public Boolean addRole(RoleVo roleVo);
    public Boolean updateRole(RoleVo roleVo);

    public List<Menu> getMenuByRoleId(int roleId);

    public List<User> getUserByRoleId(int roleId);
    public Role getRoleByRoleId(int roleId);

    public Boolean deleteRole(int roleId);
}
