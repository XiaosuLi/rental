package com.rental.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInterceptor implements HandlerInterceptor {

    //用户请求刚过来，controller处理前
    //返回值：判断是否将当前的请求拦截下来
    //true：请求继续执行
    //flase：请求终止
    //Object o ：表示的是被拦截的控制类的对象
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("执行到了preHandle方法");
        return true;
    }


    //controller处理请求后，还没发往用户，在进行一次处理发往用户
    //ModelAndView modelAndView：可以修改显示的视图或修改显示视图的方法
    //modelAndView.addObject("msg","拦截器修改的消息"); 修改拦截器里面的属性值啥的
    //  modelAndView.setViewName("hello2"); 修改返回的视图啥的
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("执行到了postHandle方法");
       // modelAndView.addObject("msg","拦截器修改的消息");
       // modelAndView.setViewName("hello2");
    }


    //已经发到用户了，请求结束，用来销毁资源不常用
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("执行到了afterHandle方法");
    }
}
