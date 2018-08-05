package com.diviner.magic.mvp_again.model;

import android.os.Handler;

public class UserLoginModelImpl implements UserLoginModel {
    @Override
    public void login(final String userName, final String passWord, final UserLoginListener userLoginListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if ("jike".equals(userName)&&"123".equals(passWord)){
                    userLoginListener.loginScuess();
                }else {
                    userLoginListener.loginFailed();
                }
            }
        },2000);
    }
}
