package com.example.assignment.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.database.DbHelper;
import com.example.assignment.model.LopHoc;

import java.util.ArrayList;

public class LopHocDAO {
    DbHelper helper;

    public LopHocDAO(Context context) {
        helper = new DbHelper(context);
    }

    public ArrayList<LopHoc> readAll() {
        ArrayList<LopHoc> ds = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT * FROM LOP", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()) {
            String maLop = cs.getString(0);
            String tenLop = cs.getString(1);
            ds.add(new LopHoc(maLop, tenLop));
            cs.moveToNext();
        }
        cs.close();
        return ds;
    }

    public boolean create(LopHoc lop) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaLop", lop.getMaLop());
        values.put("TenLop", lop.getTenLop());
        long row = db.insert("LOP", null, values);
        if (row > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(String ma, String tenLop) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenLop", tenLop);
        int row = db.update("LOP", values, "MaLop=?", new String[]{ma});
        return row > 0;
    }

    public boolean delete(String ma) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int row = db.delete("LOP", "MaLop=?", new String[]{ma});
        return row > 0;
    }
}
