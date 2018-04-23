package com.rental.mapper;

import com.rental.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public List<User> listAllUser();

    public void userRegister(User user);

    public User userIsExist(String userPhone);

    public User userLogin(@Param(value = "userPhone") String userPhone, @Param(value = "userPassword")  String userPassword);

    public User userIsLogined(String userPhone);

    public void userChangePawd(@Param(value = "userPhone")String userPhone,@Param(value = "userPassword")String userPassword);
}
