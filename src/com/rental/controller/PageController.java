package com.rental.controller;


import com.rental.pojo.User;
import com.rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class PageController {


    @Autowired
    UserService userService;


    @RequestMapping("index")
    /*+++
    * 利用ModelMap model，addAttribute向jsp页面传递参数；
    * jsp 利用EL表达式 ${user.xxxx}
    * */
    public String toIndexPage(ModelMap model, HttpSession session) {

        String tmp = null;
        try {
             tmp = session.getAttribute("userPhone").toString();
        }catch (Exception e){
        }
        if (tmp != null) {
            User user = userService.userIsLogined(tmp);
            model.addAttribute("user",user);
            System.out.println(user.getUserName());
        }
        return "index";
    }

    @RequestMapping("rental")
    public String toRentalPage() {
        return "rental";
    }

}
