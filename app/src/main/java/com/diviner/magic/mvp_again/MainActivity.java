package com.diviner.magic.mvp_again;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.diviner.magic.mvp_again.perenter.LoginPerenter;


/**
 * @author Magic
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener,LoginView {

    private EditText editTextUserName;
    private EditText editTextPassWord;
    private AppCompatButton btnLogin;
    private AppCompatButton btnClear;
    private LoginPerenter loginPerenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    private void initView() {
        loginPerenter = new LoginPerenter(this,this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("登录中，请稍候。。。");
        progressDialog.setCancelable(false);
        editTextUserName = findViewById(R.id.et_account);
        editTextPassWord = findViewById(R.id.et_pwd);
        btnLogin = findViewById(R.id.btn_login);
        btnClear = findViewById(R.id.btn_clear);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                loginPerenter.login(editTextUserName.getText().toString(),
                        editTextPassWord.getText().toString()
                        );

                break;
            case R.id.btn_clear:
                loginPerenter.clear();
                break;
            default:
                break;
        }
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void success() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failed() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clear() {
        editTextUserName.setText("");
        editTextPassWord.setText("");
    }
}
