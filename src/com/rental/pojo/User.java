package com.rental.pojo;

public class User {
  /*
    *
    * user_id,user_phone,user_name,user_password,
    * user_password_md5,user_photo,user_real_name,
    * user_ID_number*/

    private int userId;
    private String userPhone;
    private String userName;
    private String userPassword;
    private String userPasswordMd5;
    private String userPhoto;
    private String userRealName;
    private String userIDNumber;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPasswordMd5() {
        return userPasswordMd5;
    }

    public void setUserPasswordMd5(String userPasswordMd5) {
        this.userPasswordMd5 = userPasswordMd5;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserIDNumber() {
        return userIDNumber;
    }

    public void setUserIDNumber(String userIDNumber) {
        this.userIDNumber = userIDNumber;
    }

    /*public User( String userName, String userPassword,String userPhone) {
        this.userPhone = userPhone;
        this.userName = userName;
        this.userPassword = userPassword;
    }*/

    public User(String userPhone, String userName, String userPassword) {
        this.userPhone = userPhone;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(int userId, String userPhone, String userName, String userPassword, String userPasswordMd5, String userPhoto, String userRealName, String userIDNumber) {
        this.userId = userId;
        this.userPhone = userPhone;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPasswordMd5 = userPasswordMd5;
        this.userPhoto = userPhoto;
        this.userRealName = userRealName;
        this.userIDNumber = userIDNumber;
    }
    //+++spring注入时需要一个无参数的构造方法
    public User() {
    }
}
