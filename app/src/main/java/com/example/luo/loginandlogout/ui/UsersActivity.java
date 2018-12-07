package com.example.luo.loginandlogout.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.luo.loginandlogout.R;
import com.example.luo.loginandlogout.data.modules.User;
import com.example.luo.loginandlogout.data.adapters.UsersAdapters;
import com.example.luo.loginandlogout.data.helper.UserHelper;

import java.util.List;

public class UsersActivity extends AppCompatActivity {

    private List<User> userList;
    private RecyclerView mUserRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private UsersAdapters mUsersAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        userList = UserHelper.createUserList(200);
        mUserRecyclerView = findViewById(R.id.users_recycler_view);
        mUserRecyclerView.setHasFixedSize(true);
        mUserRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        mLayoutManager = new LinearLayoutManager(this);
        mUserRecyclerView.setLayoutManager(mLayoutManager);

        mUsersAdapters = new UsersAdapters(userList);
        mUserRecyclerView.setAdapter(mUsersAdapters);
    }
}
