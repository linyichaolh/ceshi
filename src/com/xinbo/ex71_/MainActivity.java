package com.xinbo.ex71_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEditPwd;
    private EditText mEditUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        mEditUser = (EditText) findViewById(R.id.edit_user);
        mEditPwd = (EditText) findViewById(R.id.edit_pwd);
    }

    public void btnSignUp(View view) {
        String username = mEditUser.getText().toString();
        String password = mEditPwd.getText().toString();
        //TODO 1. 判空
        if (TextUtils.isEmpty(username)){
            mEditUser.setError("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(password)){
            mEditPwd.setError("请输入密码");
            return;
        }
        //TODO 2. 合法性校验
        // 用户名合法条件：手机/会员名/邮箱
        boolean isPhone = RegexValidateUtil.checkMobileNumber(username);
        boolean isEmail = RegexValidateUtil.checkEmail(username);
//        boolean isCharacter = RegexValidateUtil.checkCharacter(username);
        if (!isPhone && !isEmail ){
            mEditUser.setError("请输入正确的用户名");
            return;
        }
        // 密码合法条件：6-16字母和数字
        boolean isPwdValid = RegexValidateUtil.checkCharacter(password);
        if (!isPwdValid){
            mEditPwd.setError("请输入6-16位字母和数字密码");
            return;
        }
        //TODO 3. 发送到服务端
//        HTTPutils.

    }

    public void btnSignIn(View view) {

    }
}
