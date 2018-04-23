package com.rental.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("test")
public class TestController {

    //测试下Session
    @RequestMapping("/session")
    public void testSession(HttpSession session) {
        session.setAttribute("testCode", "123456");
    }

    @RequestMapping("/getsession")
    public void testSession1(HttpSession session) {
        String testCode = (String) session.getAttribute("testCode");
        if (testCode == null) {
            System.out.println("session不存在");
        } else {
            System.out.println("code是" + testCode);
        }

    }


    //测试下springmvc的返回类型
    @RequestMapping("return")
    @ResponseBody
    public String testReturn() {
        return "hello";
    }


    //测试一下接受ajax的数据
    @RequestMapping("/ajax")
    // @ResponseBody
    public String testAjax(String name, String city) {
        System.out.println(name + city);
        return "ajax";
    }


    //测试一下cookies

    @RequestMapping("/show")
    public void hello(@CookieValue(value = "JSESSIONID", defaultValue = "0") String jSessionID, HttpServletResponse response) {
        System.out.println("JSESSIONID是：" + jSessionID);
        Cookie userPhoneCookie = new Cookie("userPhone", "130123456780");
        userPhoneCookie.setMaxAge(60 * 60);
        response.addCookie(userPhoneCookie);
    }


    //中文乱码问题的拦截器
    @RequestMapping("/chinese")
    public void testChinese(String name,HttpSession session){
        System.out.println("中文测试");
        System.out.println(name);
        String userPhone = session.getAttribute("userPhone").toString();
        System.out.println(userPhone);
    }

}
