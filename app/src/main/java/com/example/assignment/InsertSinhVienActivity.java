package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.dao.SinhVienDAO;
import com.example.assignment.model.SinhVien;

public class InsertSinhVienActivity extends AppCompatActivity {
    EditText etMaSinhVien, etTenSinhVien, etMaLop;
    Button btnThemSinhVien;
    SinhVienDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_sinh_vien);

        dao = new SinhVienDAO(InsertSinhVienActivity.this);
        etMaSinhVien = findViewById(R.id.edtMaSinhVien);
        etTenSinhVien = findViewById(R.id.edtTenSinhVien);
        etMaLop = findViewById(R.id.edtMaLop);
        btnThemSinhVien = findViewById(R.id.btnThemSinhVien);
        btnThemSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = etMaSinhVien.getText().toString();
                String ten = etTenSinhVien.getText().toString();
                String maLop = etMaLop.getText().toString();
                SinhVien sinhVien = new SinhVien(ma, ten, maLop);
                if (dao.create(sinhVien)){
                    Toast.makeText(InsertSinhVienActivity.this, "Thanh Cong", Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(InsertSinhVienActivity.this, "That Bai", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
