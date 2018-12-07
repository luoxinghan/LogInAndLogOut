package com.example.luo.loginandlogout.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.luo.loginandlogout.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String IS_REMEMBER = "isRemember";
    private Button mLoginButton;
    private EditText mUsernameEdit;
    private EditText mPasswordEdit;
    private ProgressBar mProgressBar;
    private CheckBox mLoginCheckBox;
    private String username;
    private String password;
    private Boolean isRemember;
    private String FILE = "userInfo";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUsernameEdit = findViewById(R.id.login_user_name_text);
        mPasswordEdit = findViewById(R.id.login_password_edit_text);
        mLoginButton = findViewById(R.id.login_button);
        mLoginCheckBox = findViewById(R.id.login_checkBox);
        mProgressBar = findViewById(R.id.login_progress_bar);
        mLoginButton.setOnClickListener(this);
        sp = this.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        username = sp.getString("username", "");
        password = sp.getString("password", "");
        isRemember = sp.getBoolean("isRemember",false);
        mUsernameEdit.setText(username);
        mPasswordEdit.setText(password);
        mLoginCheckBox.setChecked(isRemember);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        username = String.valueOf(mUsernameEdit.getText());
        password = String.valueOf(mPasswordEdit.getText());
        isRemember = mLoginCheckBox.isChecked();
        outState.putString(USERNAME, username);
        outState.putString(PASSWORD, password);
        outState.putBoolean(IS_REMEMBER, isRemember);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        username = savedInstanceState.getString(USERNAME);
        password = savedInstanceState.getString(PASSWORD);
        isRemember = savedInstanceState.getBoolean(IS_REMEMBER);
        mUsernameEdit.setText(username);
        mPasswordEdit.setText(password);
        mLoginCheckBox.setChecked(isRemember);
    }

    private boolean checkThePassword(String username, String password){
        if(username.equals("admin") && password.equals("123456")) {
            return true;
        } else {
            return false;
        }
    }

    private void validThread(Handler handler){
        long time = 2000L;
        try {
            Thread.sleep(time);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if(checkThePassword(username, password)){
                        if(isRemember){
                            sp = getSharedPreferences(FILE, Context.MODE_PRIVATE);
                            SharedPreferences.Editor edit = sp.edit();
                            edit.putString("username", username);
                            edit.putString("password", password);
                            edit.putBoolean("isRemember", isRemember);
                            edit.apply();
                        }
                        Intent intent = new Intent(getBaseContext(), WelcomeActivity.class);
                        intent.putExtra(USERNAME, username);
                        intent.putExtra(PASSWORD, password);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getBaseContext(), "Wrong username or password!", Toast.LENGTH_LONG).show();
                    }
                    mProgressBar.setVisibility(View.GONE);
                    mLoginButton.setEnabled(true);
                    mUsernameEdit.setEnabled(true);
                    mPasswordEdit.setEnabled(true);
                    mLoginCheckBox.setEnabled(true);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_button:
                final Handler handler = new Handler();
                username = mUsernameEdit.getText().toString();
                password = mPasswordEdit.getText().toString();
                isRemember = mLoginCheckBox.isChecked();
                mLoginButton.setEnabled(false);
                mUsernameEdit.setEnabled(false);
                mPasswordEdit.setEnabled(false);
                mLoginCheckBox.setEnabled(false);
                mProgressBar.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        validThread(handler);
                    }
                }).start();
                break;
        }
    }
}
