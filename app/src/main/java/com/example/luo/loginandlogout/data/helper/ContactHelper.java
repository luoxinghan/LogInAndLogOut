package com.example.luo.loginandlogout.data.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.luo.loginandlogout.data.modules.FileUser;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper {

    public static List<FileUser> getAllContacts(SQLiteDatabaseHelper mSQLiteDatabaseHelper){
        List<FileUser> fileUsers = new ArrayList<FileUser>();
        SQLiteDatabase sqLiteDatabase = mSQLiteDatabaseHelper.getWritableDatabase();
        String[] columns = {ContactDBTable.CONTACT_NAME, ContactDBTable.CONTACT_PHONE};
        Cursor cursor = sqLiteDatabase.query(ContactDBTable.TABLE_NAME, columns,null,null ,null,null,null);
        while (cursor.moveToNext()) {
            fileUsers.add(new FileUser(cursor.getString(cursor.getColumnIndex(ContactDBTable.CONTACT_NAME)), cursor.getString(cursor.getColumnIndex(ContactDBTable.CONTACT_PHONE))));
        }
        cursor.close();
        return fileUsers;
    }
}
