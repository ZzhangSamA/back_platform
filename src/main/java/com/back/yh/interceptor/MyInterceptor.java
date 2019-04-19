package com.back.yh.interceptor;

import com.back.yh.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {
    /**
     * 前置处理方法,判断session中是否有customer存在
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //1.什么不能拦截（1.login-register.html不能拦截,2.loginCheck不能拦截）
        //1.1获取路径
        String uri = httpServletRequest.getRequestURI();
        //1.2判断路径,如果这个路径包含login-register或者loginCheck，我就放行
        if(uri.indexOf("login")!=-1||uri.indexOf("loginCheck")!=-1||uri.indexOf("clearSession")!=-1){
            return true;
        }else{
            //如果不是包含login或者loginCheck，我就验这个session里面有没有user
            //2.获取session
            HttpSession httpSession = httpServletRequest.getSession();

            User user = (User) httpSession.getAttribute("user");
            //获取对应的菜单信息，将其保存到session中
            System.out.println(user);
            if(user==null){
                return false;
            }else{
                return true;
            }
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
