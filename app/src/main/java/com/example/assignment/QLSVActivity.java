package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QLSVActivity extends AppCompatActivity {
    Button btChinhSuaSinhVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_s_v);
        btChinhSuaSinhVien = findViewById(R.id.btnChinhSuaSinhVien);
        btChinhSuaSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QLSVActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }
}
