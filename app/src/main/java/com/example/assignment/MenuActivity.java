package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button btQLSV, btQLLH, btchange, btDangXuat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btQLSV = findViewById(R.id.btnQLSV);
        btQLLH = findViewById(R.id.btnqllh);
        btchange = findViewById(R.id.btnchange);
        btDangXuat = findViewById(R.id.btnDangXuat);
        btQLSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, QLSVActivity.class);
                startActivity(intent);
            }
        });
        btQLLH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MenuActivity.this, QLLHActivity.class);
                startActivity(intent2);
            }
        });
        btchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MenuActivity.this, ChangePasswordActivity.class);
                startActivity(intent3);
            }
        });
        btDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
