package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QLLHActivity extends AppCompatActivity {
    Button btChinhSuaLopHoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_l_h);
        btChinhSuaLopHoc = findViewById(R.id.btnChinhSuaLopHoc);
        btChinhSuaLopHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QLLHActivity.this, Add2Activity.class);
                startActivity(intent);
            }
        });
    }
}
