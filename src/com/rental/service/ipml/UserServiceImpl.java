package com.rental.service.ipml;

import com.rental.mapper.UserMapper;
import com.rental.pojo.User;
import com.rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    public List<User> listAllUser(){
        return userMapper.listAllUser();
    }

    /*
    * ÓÃ»§×¢²á
    */
    public void userRegister(User user){
        userMapper.userRegister(user);
    }

    public boolean userIsExist(String userPhone){
        User user = userMapper.userIsExist(userPhone);
        if (user == null){
            return false;
        }else {
            return true;
        }
    }

    public  User userLogin(String userPhone,String userPassword){
        return userMapper.userLogin(userPhone,userPassword);
    }

    public User userIsLogined(String userPhone){
        return userMapper.userIsLogined(userPhone);

    }
    public void userChangePswd(String userPhone,String userPassword){
        userMapper.userChangePawd(userPhone,userPassword);
    }
}
