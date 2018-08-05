package com.diviner.magic.mvp_again.model;

public interface UserLoginModel {
    void login(String userName,String passWord,UserLoginListener userLoginListener);
}
