package com.back.yh.service.impl;

import com.back.yh.dto.RoleMenu;
import com.back.yh.dto.RoleUser;
import com.back.yh.mapper.RoleMapper;
import com.back.yh.pojo.Menu;
import com.back.yh.pojo.Role;
import com.back.yh.pojo.User;
import com.back.yh.service.RoleService;
import com.back.yh.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    public Integer getTotalRole() {
        return roleMapper.getTotalRole();
    }

    public List<Role> initRolePage(Role role) {
        return roleMapper.initRolePage(role);
    }

    public List<Menu> getMenuListForRole() {
        return roleMapper.getMenuListForRole();
    }

    public List<User> getUserListForRole() {
        return roleMapper.getUserListForRole();
    }

    @Transactional
    public Boolean addRole(RoleVo roleVo) {
        int i = roleMapper.addRole(roleVo.getRoleName());
        if(!(i > 0)) {
            return false;
        }
        int roleId = roleMapper.getRoleId(roleVo.getRoleName());
        String[] menus = roleVo.getMenus();
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRoleId(roleId);
        for(int j=0;j<menus.length;j++) {
            roleMenu.setMenuId(Integer.parseInt(menus[j]));
            roleMapper.addRoleMenu(roleMenu);
        }
        String[] users = roleVo.getUsers();
        RoleUser roleUser = new RoleUser();
        roleUser.setRoleId(roleId);
        for(int j=0;j<users.length;j++) {
            roleUser.setUserId(Integer.parseInt(users[j]));
            roleMapper.addRoleUser(roleUser);
        }
        return true;
    }

    @Transactional
    public Boolean updateRole(RoleVo roleVo) {
        //根据roleId删除所有相关数据
        int i = roleMapper.updateRole(roleVo);
        if(!(i > 0)) {
            return false;
        }
        i = roleMapper.deleteRoleMenu(roleVo.getRoleId());
        if(!(i > 0)) {
            return false;
        }
        i = roleMapper.deleteUserRole(roleVo.getRoleId());
        if(!(i > 0)) {
            return false;
        }
        //再重新加入新的数据
        int roleId = roleMapper.getRoleId(roleVo.getRoleName());
        String[] menus = roleVo.getMenus();
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRoleId(roleId);
        for(int j=0;j<menus.length;j++) {
            roleMenu.setMenuId(Integer.parseInt(menus[j]));
            roleMapper.addRoleMenu(roleMenu);
        }
        String[] users = roleVo.getUsers();
        RoleUser roleUser = new RoleUser();
        roleUser.setRoleId(roleId);
        for(int j=0;j<users.length;j++) {
            roleUser.setUserId(Integer.parseInt(users[j]));
            roleMapper.addRoleUser(roleUser);
        }
        return true;
    }

    public List<Menu> getMenuByRoleId(int roleId) {
        return roleMapper.getMenuByRoleId(roleId);
    }

    public List<User> getUserByRoleId(int roleId) {
        return roleMapper.getUserByRoleId(roleId);
    }

    public Role getRoleByRoleId(int roleId) {
        return roleMapper.getRoleByRoleId(roleId);
    }

    @Transactional
    public Boolean deleteRole(int roleId) {
        int i = roleMapper.deleteRole(roleId);
        if(!(i > 0)) {
            return false;
        }
        i = roleMapper.deleteRoleMenu(roleId);
        if(!(i > 0)) {
            return false;
        }
        i = roleMapper.deleteUserRole(roleId);
        if(!(i > 0)) {
            return false;
        }
        return true;
    }
}
