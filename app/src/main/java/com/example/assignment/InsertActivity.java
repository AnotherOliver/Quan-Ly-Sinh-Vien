package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.dao.LopHocDAO;
import com.example.assignment.model.LopHoc;

public class InsertActivity extends AppCompatActivity {
    EditText etMa, etTen;
    Button btThemLop;
    LopHocDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        dao = new LopHocDAO(InsertActivity.this);
        etMa = findViewById(R.id.edtMaLop);
        etTen = findViewById(R.id.edtTenLop);
        btThemLop = findViewById(R.id.btnThemLop);
        btThemLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = etMa.getText().toString();
                String ten = etTen.getText().toString();
                LopHoc lop = new LopHoc(ma, ten);
                if (dao.create(lop)){
                    Toast.makeText(InsertActivity.this, "Thanh Cong", Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(InsertActivity.this, "Khong Thanh Cong", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
