package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.dao.SinhVienDAO;
import com.example.assignment.model.SinhVien;

public class EditSinhVienActivity extends AppCompatActivity {
    EditText etMaSinhVien, etTenSinhVien, etMaLop;
    Button btEditSinhVien;
    SinhVienDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sinh_vien);

        dao = new SinhVienDAO(EditSinhVienActivity.this);
        etMaSinhVien = findViewById(R.id.edtMaSinhVienEdit);
        etTenSinhVien = findViewById(R.id.edtTenSinhVienEdit);
        etMaLop = findViewById(R.id.edtMaLopEdit);
        btEditSinhVien = findViewById(R.id.btnEditSinhVien);

        SinhVien sv = (SinhVien) getIntent().getSerializableExtra("sinhvien");
        etMaSinhVien.setText(sv.getMaSinhVien());
        etTenSinhVien.setText(sv.getTenSinhVien());
        etMaLop.setText(sv.getMaLop());

        btEditSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = etMaSinhVien.getText().toString();
                String ten = etTenSinhVien.getText().toString();
                String maLop = etMaLop.getText().toString();
                if (dao.update(ma, ten, maLop)){
                    Toast.makeText(EditSinhVienActivity.this, "Thanh Cong", Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(EditSinhVienActivity.this, "Khong Thanh Cong", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
