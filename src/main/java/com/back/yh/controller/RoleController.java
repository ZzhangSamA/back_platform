package com.back.yh.controller;


import com.back.yh.pojo.Role;
import com.back.yh.service.RoleService;
import com.back.yh.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 获取角色的总数以显示在列表页面最上面
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getTotalRole",method = RequestMethod.GET)
    public Integer getTotalRole() {
        return roleService.getTotalRole();
    }

    /**
     * 初始化角色列表
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "initRolePage",method = RequestMethod.POST)
    public Object initRolePage(@RequestBody Role role) {
        return roleService.initRolePage(role);
    }

    /**
     * 获取所有的菜单列表，用于在角色的添加和修改页面显示出来
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getMenuListForRole",method = RequestMethod.GET)
    public Object getMenuListForRole() {
        return roleService.getMenuListForRole();
    }

    /**
     * 获取所有的用户列表，用于在角色的添加和修改页面显示出来
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getUserListForRole",method = RequestMethod.GET)
    public Object getUserListForRole() {
        return roleService.getUserListForRole();
    }

    /**
     * 添加角色
     * @param roleVo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "insertRole",method = RequestMethod.POST)
    public String addRole(@RequestBody RoleVo roleVo) {
        return roleService.addRole(roleVo).toString();
    }

    /**
     * 修改角色
     * @param roleVo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateRole",method = RequestMethod.POST)
    public String updateRole(@RequestBody RoleVo roleVo) {
        return roleService.updateRole(roleVo).toString();
    }

    /**
     * 根据roleId获取这个角色的已选菜单权限，在角色修改页面信息回显
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getMenuByRoleId",method = RequestMethod.POST)
    public Object getMenuByRoleId(@RequestBody int roleId) {
        return roleService.getMenuByRoleId(roleId);
    }

    /**
     * 根据roleId获取这个角色已选的用户，在角色修改页面信息回显
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getUserByRoleId",method = RequestMethod.POST)
    public Object getUserByRoleId(@RequestBody int roleId) {
        return roleService.getUserByRoleId(roleId);
    }

    /**
     * 根据roleId获取角色页面，在角色修改页面信息回显
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getRoleByRoleId",method = RequestMethod.POST)
    public Object getRoleByRoleId(@RequestBody int roleId) {
        return roleService.getRoleByRoleId(roleId);
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteRole",method = RequestMethod.POST)
    public Object deleteRole(@RequestBody int roleId) {
        return roleService.deleteRole(roleId);
    }
}
