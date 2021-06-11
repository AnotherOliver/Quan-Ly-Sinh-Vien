package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.dao.LopHocDAO;
import com.example.assignment.model.LopHoc;

public class EditLopHocActivity extends AppCompatActivity {
    EditText etMa, etTen;
    Button btEditLopHoc;
    LopHocDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_lop_hoc);

        dao = new LopHocDAO(EditLopHocActivity.this);
        etMa = findViewById(R.id.edtMaLopEdit);
        etTen = findViewById(R.id.edtTenLopEdit);
        btEditLopHoc = findViewById(R.id.btnEditLopHoc);

        LopHoc lop = (LopHoc) getIntent().getSerializableExtra("lophoc");
        etMa.setText(lop.getMaLop());
        etTen.setText(lop.getTenLop());

        btEditLopHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = etMa.getText().toString();
                String ten = etTen.getText().toString();
                if (dao.update(ma, ten)){
                    Toast.makeText(EditLopHocActivity.this, "Thanh Cong", Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(EditLopHocActivity.this, "Khong Thanh Cong", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
