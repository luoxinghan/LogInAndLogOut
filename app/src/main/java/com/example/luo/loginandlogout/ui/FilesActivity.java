package com.example.luo.loginandlogout.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luo.loginandlogout.R;
import com.example.luo.loginandlogout.data.helper.ContactDBTable;
import com.example.luo.loginandlogout.data.helper.SQLiteDatabaseHelper;
import com.example.luo.loginandlogout.data.modules.FileUser;

public class FilesActivity extends AppCompatActivity implements View.OnClickListener {

    private String name;
    private String phonenumber;
    private EditText mFilesNameEdit;
    private EditText mFilesPhoneEdit;
    private Button mFilesSaveButton;
    private Button mFilesFindButton;
    private Button mFilesShowListButton;

    private SQLiteDatabaseHelper mSQLiteDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        mFilesNameEdit = findViewById(R.id.files_name_edit_text);
        mFilesPhoneEdit = findViewById(R.id.files_phone_edit_text);
        mFilesSaveButton = findViewById(R.id.files_save_button);
        mFilesFindButton = findViewById(R.id.files_find_button);
        mFilesShowListButton = findViewById(R.id.files_show_list_button);

        mSQLiteDatabaseHelper = new SQLiteDatabaseHelper(this);

        name = mFilesNameEdit.getText().toString();
        phonenumber = mFilesPhoneEdit.getText().toString();

        mFilesSaveButton.setOnClickListener(this);
        mFilesFindButton.setOnClickListener(this);
        mFilesShowListButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        name = mFilesNameEdit.getText().toString();
        phonenumber = mFilesPhoneEdit.getText().toString();
        switch (v.getId()){
            case R.id.files_save_button:
                if (name.equals("") || phonenumber.equals("")){
                    Toast.makeText(getBaseContext(), "Please enter name and password!", Toast.LENGTH_LONG).show();
                } else {
                    saveInDatabase(new FileUser(name, phonenumber));
                    resetTheEditText();
                }
                break;

            case R.id.files_find_button:
                FileUser fileUser = new FileUser();
                if (name.equals("") && !phonenumber.equals("")){
                    fileUser = findInDatabase(phonenumber);
                } else if (!name.equals("") && phonenumber.equals("")){
                    fileUser = findInDatabase(name);
                } else {
                    Toast.makeText(getBaseContext(), "Please enter name or password!", Toast.LENGTH_LONG).show();
                }
                if (fileUser == null){
                    Toast.makeText(getBaseContext(), "Did't find!", Toast.LENGTH_LONG).show();
                } else {
                    mFilesNameEdit.setText(fileUser.getName());
                    mFilesPhoneEdit.setText(fileUser.getPhone());
                }
                break;
            case R.id.files_show_list_button:
                Intent intent = new Intent(FilesActivity.this, ContactActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void resetTheEditText(){
        mFilesNameEdit.setText("");
        mFilesPhoneEdit.setText("");
    }

    private void saveInDatabase(FileUser fileUser){
        SQLiteDatabase sqLiteDatabase = mSQLiteDatabaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactDBTable.CONTACT_NAME, fileUser.getName());
        contentValues.put(ContactDBTable.CONTACT_PHONE, fileUser.getPhone());
        sqLiteDatabase.insert(ContactDBTable.TABLE_NAME, null, contentValues);
    }

    private FileUser findInDatabase(String str){
        FileUser fileUser = new FileUser();
        SQLiteDatabase sqLiteDatabase = mSQLiteDatabaseHelper.getWritableDatabase();
        String[] columns = {ContactDBTable.CONTACT_NAME, ContactDBTable.CONTACT_PHONE};
        Cursor cursor = sqLiteDatabase.query(ContactDBTable.TABLE_NAME, columns,"name = ? or phone = ?",new String[]{str, str} ,null,null,null);
        if (cursor.moveToNext()) {
            fileUser = new FileUser(cursor.getString(cursor.getColumnIndex(ContactDBTable.CONTACT_NAME)), cursor.getString(cursor.getColumnIndex(ContactDBTable.CONTACT_PHONE)));
        } else {
            fileUser = null;
        }
        cursor.close();
        return fileUser;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSQLiteDatabaseHelper.close();
    }
}
