package com.news.gfs.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 其他情况判断session中是否有key，有的话继续用户的操作
        if (request.getSession().getAttribute("user") != null) {
            return true;
        }
        // 最后的情况就是进入登录页面
        response.sendRedirect( "/login.jsp");
        return false;
    }
}
