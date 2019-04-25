package com.back.yh.mapper;

import com.back.yh.dto.RoleMenu;
import com.back.yh.dto.RoleUser;
import com.back.yh.pojo.Menu;
import com.back.yh.pojo.Role;
import com.back.yh.pojo.User;
import com.back.yh.vo.RoleVo;

import java.util.List;

public interface RoleMapper {

    public Integer getTotalRole();

    public List<Role> initRolePage(Role role);

    public List<Menu> getMenuListForRole();
    public List<User> getUserListForRole();

    public Integer addRole(String roleName);

    public Integer updateRole(RoleVo roleVo);
    public Integer deleteRoleMenu(int roleId);
    public Integer deleteUserRole(int roleId);
    public Integer deleteRole(int roleId);

    Integer getRoleId(String roleName);

    int addRoleMenu(RoleMenu roleMenu);
    int addRoleUser(RoleUser roleUser);

    public List<Menu> getMenuByRoleId(int roleId);
    public List<User> getUserByRoleId(int roleId);
    public Role getRoleByRoleId(int roleId);


}
