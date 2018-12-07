package com.example.luo.loginandlogout.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.luo.loginandlogout.R;
import com.example.luo.loginandlogout.data.adapters.ContactsAdapters;
import com.example.luo.loginandlogout.data.adapters.UsersAdapters;
import com.example.luo.loginandlogout.data.helper.ContactHelper;
import com.example.luo.loginandlogout.data.helper.SQLiteDatabaseHelper;
import com.example.luo.loginandlogout.data.modules.FileUser;
import com.example.luo.loginandlogout.data.modules.User;

import java.util.List;

public class ContactActivity extends AppCompatActivity {

    private List<FileUser> fileUsers;
    private RecyclerView mContactRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ContactsAdapters mContactsAdapter;

    private SQLiteDatabaseHelper mSQLiteDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mSQLiteDatabaseHelper = new SQLiteDatabaseHelper(this);
        List<FileUser> fileUsers = ContactHelper.getAllContacts(mSQLiteDatabaseHelper);
        mContactRecyclerView = findViewById(R.id.contacts_recycler_view);
        mContactRecyclerView.setHasFixedSize(true);
        mContactRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        mLayoutManager = new LinearLayoutManager(this);
        mContactRecyclerView.setLayoutManager(mLayoutManager);

        mContactsAdapter = new ContactsAdapters(fileUsers);
        mContactRecyclerView.setAdapter(mContactsAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSQLiteDatabaseHelper.close();
    }
}
