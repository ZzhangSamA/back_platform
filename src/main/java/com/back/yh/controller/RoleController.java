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

    @ResponseBody
    @RequestMapping(value = "getTotalRole",method = RequestMethod.GET)
    public Integer getTotalRole() {
        return roleService.getTotalRole();
    }
    @ResponseBody
    @RequestMapping(value = "initRolePage",method = RequestMethod.POST)
    public Object initRolePage(@RequestBody Role role) {
        return roleService.initRolePage(role);
    }

    @ResponseBody
    @RequestMapping(value = "getMenuListForRole",method = RequestMethod.GET)
    public Object getMenuListForRole() {
        return roleService.getMenuListForRole();
    }
    @ResponseBody
    @RequestMapping(value = "getUserListForRole",method = RequestMethod.GET)
    public Object getUserListForRole() {
        return roleService.getUserListForRole();
    }

    @ResponseBody
    @RequestMapping(value = "insertRole",method = RequestMethod.POST)
    public String addRole(@RequestBody RoleVo roleVo) {
        return roleService.addRole(roleVo).toString();
    }
    @ResponseBody
    @RequestMapping(value = "updateRole",method = RequestMethod.POST)
    public String updateRole(@RequestBody RoleVo roleVo) {
        return roleService.updateRole(roleVo).toString();
    }

    @ResponseBody
    @RequestMapping(value = "getMenuByRoleId",method = RequestMethod.POST)
    public Object getMenuByRoleId(@RequestBody int roleId) {
        return roleService.getMenuByRoleId(roleId);
    }

    @ResponseBody
    @RequestMapping(value = "getUserByRoleId",method = RequestMethod.POST)
    public Object getUserByRoleId(@RequestBody int roleId) {
        return roleService.getUserByRoleId(roleId);
    }

    @ResponseBody
    @RequestMapping(value = "getRoleByRoleId",method = RequestMethod.POST)
    public Object getRoleByRoleId(@RequestBody int roleId) {
        return roleService.getRoleByRoleId(roleId);
    }


    @ResponseBody
    @RequestMapping(value = "deleteRole",method = RequestMethod.POST)
    public Object deleteRole(@RequestBody int roleId) {
        return roleService.deleteRole(roleId);
    }
}
