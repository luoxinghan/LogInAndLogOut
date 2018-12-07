package com.example.luo.loginandlogout.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.luo.loginandlogout.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String USERNAME = "username";
    private TextView mWelcomeTextView;
    private Button mLogOutButton;
    private Button mWelcomeUserButton;
    private Button mWelcomeThreadButton;
    private Button mWelcomeFilmButton;
    private Button mWelcomeFilesButton;
    private String username;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            username = intent.getExtras().getString(USERNAME);
        }
        mWelcomeTextView = findViewById(R.id.welcome_text_view);
        mWelcomeThreadButton = findViewById(R.id.welcome_thread_button);
        mWelcomeUserButton = findViewById(R.id.welcome_user_button);
        mWelcomeFilmButton = findViewById(R.id.welcome_films_button);
        mWelcomeFilesButton = findViewById(R.id.welcome_files_button);

        mLogOutButton = findViewById(R.id.log_out_button);
        mLogOutButton.setOnClickListener(this);
        mWelcomeThreadButton.setOnClickListener(this);
        mWelcomeUserButton.setOnClickListener(this);
        mWelcomeFilmButton.setOnClickListener(this);
        mWelcomeFilesButton.setOnClickListener(this);
        mWelcomeTextView.setText("Welcome: " + username + " !");
    }

    public void clearnUserInfo() {
        sp = getSharedPreferences("userInfo",MODE_PRIVATE);
        sp.edit().clear().apply();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.log_out_button:
                clearnUserInfo();
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                intent.setFlags((Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                startActivity(intent);
                break;
            case R.id.welcome_thread_button:
                Intent threadIntent = new Intent(WelcomeActivity.this, ThreadActivity.class);
                startActivity(threadIntent);
                break;
            case R.id.welcome_user_button:
                Intent userIntent = new Intent(WelcomeActivity.this, UsersActivity.class);
                startActivity(userIntent);
                break;
            case R.id.welcome_films_button:
                Intent filmsIntent = new Intent(WelcomeActivity.this, FilmsActivity.class);
                startActivity(filmsIntent);
                break;
            case R.id.welcome_files_button:
                Intent filesIntent = new Intent(WelcomeActivity.this, FilesActivity.class);
                startActivity(filesIntent);
                break;
        }
    }
}
