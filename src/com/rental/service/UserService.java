package com.rental.service;

import com.rental.pojo.User;

import java.util.List;

public interface UserService {

    public List<User> listAllUser();


    /*
    * 用户注册
    */
    public void userRegister(User user);

    /*
    判断用户是否存在
     */
    public boolean userIsExist(String userPhone);

    /*
    用户登录,登录成功后把手机号写入cookie中
     */
    public  User userLogin(String userPhone,String userPassword);


    /*
    判断用户是否登录
     */

    public User userIsLogined(String userPhone);


    /*
    修改密码
    */

    public void userChangePswd(String userPhone,String userPassword);
}
