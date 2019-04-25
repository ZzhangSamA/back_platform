package com.back.yh.controller;

import com.back.tools.Md5Utils;
import com.back.tools.SplitPage;
import com.back.yh.dto.UserDto;
import com.back.yh.pojo.User;
import com.back.yh.service.UserService;
import com.back.yh.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    //登录校验
    @RequestMapping(value = "loginCheck" ,method = RequestMethod.POST)
    public Object loginCheck(@RequestBody User user, HttpSession httpSession){
        Boolean flag=false;
        user.setPassword(Md5Utils.encodePassword(user.getPassword()));
        System.out.println("userName="+user.getUserName()+",password="+user.getPassword());
        User user1 = this.userService.loginCheck(user);
        if(user1!=null){
            //登录成功,保存
            httpSession.setAttribute("user",user1);
            return "true";
        }
        return "false";
    }
    //获取页面数据与分页
    @RequestMapping(value = "getUserPage" ,method = RequestMethod.POST)
    public Object getUserPage(@RequestBody(required = false) UserVo userVo){
//        System.out.println(userVo);
        //获取分页类对象
        SplitPage splitPage = userVo.getSplitPage();
        //获取数据条数
        int count = userService.getCount(userVo);
        //每行条数
        splitPage.setPageSize(userVo.getSplitPage().getPageSize());
        //当前页，同时设置了start
        splitPage.setCurrentPage(userVo.getSplitPage().getCurrentPage());
        //总条数，同时设置了总页数
        splitPage.setTotalLine(count);
//        System.out.println(splitPage);
        //
        userVo.setSplitPage(splitPage);
        //当前第几页,每页多少行
        List<User> list = userService.getUserPage(userVo);
//        System.out.println(list);

        UserDto userDto = new UserDto();

        userDto.setSplitPage(splitPage);
        userDto.setUserList(list);
//        System.out.println(userDto);
        return userDto;
    }

    /**
     *添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "addUser" ,method = RequestMethod.POST)
    public Object addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    /**
     * 获取用户信息回显
     * @param user
     * @return
     */
    @RequestMapping(value = "getUser" ,method = RequestMethod.POST)
    public Object getUser(@RequestBody(required = false) User user){
        User user1 = this.userService.getUser(user.getUserId());
        System.out.println(user1);
        return user1;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "updateUser" ,method = RequestMethod.POST)
    public Object updateUser(@RequestBody(required = false) User user){
        int i = this.userService.updateUser(user);
        System.out.println(i);
        return i;
    }

    /**
     * 单个删除
     * @param user
     * @return
     */
    @RequestMapping(value = "delUser" ,method = RequestMethod.POST)
    public Object delUser(@RequestBody(required = false) User user){
        int i = this.userService.delUser(user.getUserId());
        System.out.println(i);
        return i;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "batchDelUser",method = RequestMethod.GET)
    public String batchDelUser(@RequestParam(value = "ids[]", required = false) Integer[] ids){
        Map<String,Object> map = new HashMap();
        map.put("ids",ids);
        Boolean flag = this.userService.batchDelUser(map);
        return flag.toString();
    }
}
