package com.example.assignment.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.LoginActivity;
import com.example.assignment.database.DbHelper;
import com.example.assignment.model.User;

public class QuanTriDAO {
    DbHelper helper;
    public QuanTriDAO(Context context){
        helper = new DbHelper(context);
    }
    public boolean checkLogin(User user){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT * FROM QUANTRI WHERE username = ? AND password = ?", new String[]{user.getUsername(), user.getPassword()});
        if (cs.getCount() <= 0){
            return false;
        }
        return true;
    }
    public boolean checkOldPwd(String oldPwd){
        String pwd = LoginActivity.USER.getPassword();
        if (!oldPwd.equals(pwd)){
            return false;
        }
        return true;
    }
    public boolean updatePwd(User user){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("password", user.getPassword());
        int row = db.update("QUANTRI", values, "username=?", new String[]{user.getUsername()});

        return row>0;
    }
}
