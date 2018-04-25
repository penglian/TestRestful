package com.example.administrator.testrestful.model.bean;

/**
 * Created by pl on 2018/4/24 0024.
 * 用户信息
 */

public class UserBean extends BaseBean{
    private String username;   //用户名
    private String password;   //密码
    private boolean emailVerified;  //邮箱认证
    private String email;   //邮箱
    private String mobilePhoneNumber;  //手机号
    private boolean mobilePhoneNumberVerified;   //手机认证
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public boolean isMobilePhoneNumberVerified() {
        return mobilePhoneNumberVerified;
    }

    public void setMobilePhoneNumberVerified(boolean mobilePhoneNumberVerified) {
        this.mobilePhoneNumberVerified = mobilePhoneNumberVerified;
    }
}
