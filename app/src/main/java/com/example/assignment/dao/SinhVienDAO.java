package com.example.assignment.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.database.DbHelper;

import com.example.assignment.model.SinhVien;

import java.util.ArrayList;

public class SinhVienDAO {
    DbHelper helper;
    public SinhVienDAO(Context context){
        helper = new DbHelper(context);
    }
    public ArrayList<SinhVien> readAll(){
        ArrayList<SinhVien> ds = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT * FROM SINHVIEN", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            String maSinhVien = cs.getString(0);
            String tenSinhVien = cs.getString(1);
            String maLop = cs.getString(2);
            ds.add(new SinhVien(maSinhVien,tenSinhVien, maLop));
            cs.moveToNext();
        }
        cs.close();
        return ds;
    }
    public boolean create(SinhVien sinhVien){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaSinhVien", sinhVien.getMaSinhVien());
        values.put("TenSinhVien", sinhVien.getTenSinhVien());
        values.put("MaLop", sinhVien.getMaLop());
        long row = db.insert("SINHVIEN", null, values);
        return row>0;
    }
    public boolean update(String maSinhVien, String tenSinhVien, String maLop){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenSinhVien", tenSinhVien);
        int row = db.update("SINHVIEN", values, "MaLop=?", new String[]{maLop});
        return row>0;
    }
    public boolean delete(String ma) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int row = db.delete("SINHVIEN", "MaLop=?", new String[]{ma});
        return row > 0;
    }
}
