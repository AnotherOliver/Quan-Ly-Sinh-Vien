package com.example.assignment.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context, "LT15304", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE LOP(MaLop text primary key, TenLop text)";
        db.execSQL(sql);

        sql = "INSERT INTO LOP VALUES('LT15304', 'Lap Trinh Mobile 15.3.4')";
        db.execSQL(sql);
        sql = "INSERT INTO LOP VALUES('LT15303', 'Lap Trinh Mobile 15.3.3')";
        db.execSQL(sql);
        sql = "INSERT INTO LOP VALUES('LT15302', 'Lap Trinh Mobile 15.3.2')";
        db.execSQL(sql);

        sql = "CREATE TABLE SINHVIEN(MaSinhVien text primary key, TenSinhVien text," +
                "MaLop references LOP(MaLop))";
        db.execSQL(sql);

        sql = "INSERT INTO SINHVIEN VALUES('PS13222', 'Nguyen Nhat An', 'LT15304')";
        db.execSQL(sql);
        sql = "INSERT INTO SINHVIEN VALUES('PS13152', 'Vo Nhat Son', 'LT15303')";
        db.execSQL(sql);
        sql = "INSERT INTO SINHVIEN VALUES('PS13232', 'Le Hoai Son', 'LT15302')";
        db.execSQL(sql);

        sql = "CREATE TABLE QUANTRI(username text primary key, password text)";
        db.execSQL(sql);
        sql = "INSERT INTO QUANTRI VALUES('admin', 'admin')";
        db.execSQL(sql);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS SINHVIEN");
        db.execSQL("DROP TABLE IF EXISTS LOP");
        onCreate(db);
    }
}
