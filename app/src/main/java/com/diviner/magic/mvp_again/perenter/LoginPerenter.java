package com.diviner.magic.mvp_again.perenter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.diviner.magic.mvp_again.LoginView;
import com.diviner.magic.mvp_again.model.UserLoginListener;
import com.diviner.magic.mvp_again.model.UserLoginModel;
import com.diviner.magic.mvp_again.model.UserLoginModelImpl;

public class LoginPerenter {

    private LoginView mLoginView;
    private UserLoginModel mUserLoginModel;
    private Context mContext;

    public LoginPerenter(Context context,LoginView loginView) {
        this.mLoginView = loginView;
        this.mContext = context;
        mUserLoginModel = new UserLoginModelImpl();

    }

    public void login(String userName,String passWord){

        mLoginView.showLoading();
        if (TextUtils.isEmpty(userName)||TextUtils.isEmpty(passWord)){
            Toast.makeText(mContext, "用户名或密码不正确", Toast.LENGTH_SHORT).show();
        }else {
            mUserLoginModel.login(userName, passWord, new UserLoginListener() {
                @Override
                public void loginScuess() {
                    mLoginView.success();
                    mLoginView.hideLoading();
                }

                @Override
                public void loginFailed() {
                    mLoginView.failed();
                    mLoginView.hideLoading();
                }
            });
        }
    }

    public void clear(){
        mLoginView.clear();
    }
}
