package com.rental.service;

import com.rental.pojo.User;

import java.util.List;

public interface UserService {

    public List<User> listAllUser();


    /*
    * �û�ע��
    */
    public void userRegister(User user);

    /*
    �ж��û��Ƿ����
     */
    public boolean userIsExist(String userPhone);

    /*
    �û���¼,��¼�ɹ�����ֻ���д��cookie��
     */
    public  User userLogin(String userPhone,String userPassword);


    /*
    �ж��û��Ƿ��¼
     */

    public User userIsLogined(String userPhone);


    /*
    �޸�����
    */

    public void userChangePswd(String userPhone,String userPassword);
}
