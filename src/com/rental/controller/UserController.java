package com.rental.controller;


import com.rental.pojo.User;
import com.rental.service.UserService;
import com.rental.utility.TestCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    /*+++
    1、传参小结：get和post的情况下，键值对，form表格的name参数可以直接传过来用
       在参数上名字一样就能解析出来
    2、把传来的参数封装成一个bean类（可以只填充部分属性），还是只要bean类属性名跟form表格的name一样，自动注入bean类中
       注：如果bean中有其他的构造方法，写一个无参数的构造方法
    3、可以同时注入一个baen类+接收部分其他参数，传来的参数不必全部放到bean中

     */




    /*
       转到注册页面
     */
    @RequestMapping("/register")
    public String toRegisterPage(){
        return "register";
    }

    /*
       转到登录界面
     */
    @RequestMapping("/login")
    public String toLoginPage(){
        return "login";
    }

    /*
    跳转到忘记密码页面
     */

    @RequestMapping("/forgetpawd")
    public String toForgetpawdPage(){
        return "forgetpawd";
    }

    /*
    跳转到修改密码页面
     */

    @RequestMapping("/changepawd")
    public String toChangepawd(){
        return "changepawd";
    }







    /*
    执行注册操作
    */
    @RequestMapping("/doregister")
    @ResponseBody
    public Map<String,Object> listAllUser(User u, String testCode, HttpSession session) {

        Map<String,Object> resultMap = new HashMap<String,Object>();
        if (userService.userIsExist(u.getUserPhone())) {
            resultMap.put("result", "用户已经注册");
            return resultMap;
        }

        //判断参数否符合规范
        String myTestCodePhone = (String) session.getAttribute("testCodePhone");
        String myTestCode = (String) session.getAttribute("testCode");
        if (testCode.equals(myTestCode) && testCode.length() != 0
                && u.getUserPhone().equals(myTestCodePhone)) {
            System.out.println("注册成功");
            //返回成功的结果
            resultMap.put("result", "SUCCESS");
            userService.userRegister(u);
            return resultMap;
        } else {
            //返回验证码错误
            resultMap.put("result", "验证码错误");
            return resultMap;
        }

    }

    /*
    执行登录操作
     */
    @RequestMapping("/dologin")
    @ResponseBody
    public Map<String,Object> userLogin(String userPhone, String userPassword,
                                        HttpSession session) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        User user = userService.userLogin(userPhone, userPassword);
        if (user == null) {
            resultMap.put("result", "用户不存在或密码错误");
            return  resultMap;
        } else {
            //将userPhone 写入Session;
            session.setAttribute("userPhone", userPhone);
            System.out.println(session.getAttribute("userPhone").toString());
            resultMap.put("result", "SUCCESS");
            return  resultMap;
        }
    }

    /*
    获取验证码,
    注册时：
    先看手机号注册没，
    注册返回已经注册，不发短信；未注册，发送短信


    */
    @RequestMapping("/getcode")
    @ResponseBody
    public Map<String,Object> getTestCode(String userPhone, HttpSession session) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        if (userService.userIsExist(userPhone)) {
            resultMap.put("result", "用户已经注册");
            System.out.println("用户已经注册");
            return resultMap;
        } else {
            //发送验证码，并将验证码写入Session
            TestCode testCode = new TestCode();
            String code = testCode.createTestCode();
            System.out.println("手机号是:" + userPhone);
            System.out.println("验证码是:" + code);
            session.setAttribute("testCodePhone",userPhone);
            session.setAttribute("testCode", code);
            //TODO 发送短信验证码的开关
            //  testCode.sendTestCode(userPhone,code);
            resultMap.put("result", "SUCCESS");
            return resultMap;
        }
    }



    /*
    修改密码时：
    先看手机号存在没，
    不存在提示：用户不存在；存在，发送验证码
     */

    @RequestMapping("/getpawdcode")
    @ResponseBody
    public Map<String,Object> getPawdTestCode(String userPhone, HttpSession session) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        if (userService.userIsExist(userPhone)) {
            TestCode testCode = new TestCode();
            String code = testCode.createTestCode();
            System.out.println("手机号是:" + userPhone);
            System.out.println("忘记密码时验证码是:" + code);
            session.setAttribute("testCodePhone",userPhone);
            session.setAttribute("testCode", code);
            //TODO 发送短信验证码的开关
            //  testCode.sendTestCode(userPhone,code);
            resultMap.put("result", "SUCCESS");
            return resultMap;
        } else {

            resultMap.put("result", "用户不存在");
            System.out.println("用户不存在");
            return resultMap;
        }
    }


    /*
    忘记密码-看验证码是否通过
    通过后跳转到忘记密码的jsp

     */

    @RequestMapping("/changepawdcode")
    @ResponseBody
    public Map<String,Object> changePassword(HttpSession session,String testCode,String userPhone,HttpServletResponse resp) throws IOException {

        Map<String,Object> resultMap = new HashMap<String,Object>();

        String myTestCodePhone = (String) session.getAttribute("testCodePhone");
        String myTestCode = (String) session.getAttribute("testCode");
        if (testCode.equals(myTestCode) && testCode.length() != 0
                && userPhone.equals(myTestCodePhone)) {
            System.out.println("修改密码成功");
            //返回成功的结果
            resultMap.put("result", "SUCCESS");
            //在修改密码页面通过 这个值来获取user
            session.setAttribute("passUserPhone",userPhone);
            return resultMap;
        } else {
            //返回验证码错误
            resultMap.put("result", "验证码错误");
            return resultMap;
        }

    }



    /*

    修改密码成功后跳转到登录页面

     */

    @RequestMapping("tochangepawd")
    public String toChangePawd (String userPassword,HttpSession session){

        System.out.println(userPassword);
        String userPhone = session.getAttribute("passUserPhone").toString();
        userService.userChangePswd(userPhone,userPassword);
        return "login";
    }


}
