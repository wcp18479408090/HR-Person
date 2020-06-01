package com.common;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//统一异常处理
@Component
public class MyException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println("进入统一异常管理");
        ModelAndView modelAndView = new ModelAndView();
      //未授权与未登陆
        ModelMap map = new ModelMap();
        map.put("ex",e);
       if(e instanceof UnauthorizedException){
           System.out.println("没有权限");
           return  new ModelAndView("unauthorized",map);
           //modelAndView.setViewName("forward:/unauthorized.html");
       }else if(e instanceof AuthorizationException){
           System.out.println("没有登陆");
           modelAndView.setViewName("forward:/login.html");
       }

        return modelAndView;
    }
}
