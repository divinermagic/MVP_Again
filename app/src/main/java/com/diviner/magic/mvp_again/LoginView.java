package com.diviner.magic.mvp_again;

public interface LoginView {
    void showLoading();
    void hideLoading();
    void success();
    void failed();
    void clear();
}
