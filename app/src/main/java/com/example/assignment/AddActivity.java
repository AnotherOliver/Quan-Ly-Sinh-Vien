package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.assignment.adapter.SinhVienAdapter;
import com.example.assignment.dao.SinhVienDAO;
import com.example.assignment.model.SinhVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    ListView lvsinhvien;
    ArrayList<SinhVien> data = new ArrayList<>();
    SinhVienAdapter adapter;
    SinhVienDAO dao;
    FloatingActionButton btnInsertSinhVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        lvsinhvien = findViewById(R.id.lvSinhVien);
        btnInsertSinhVien = findViewById(R.id.fbInsertSinhVien);
        dao = new SinhVienDAO(AddActivity.this);
        data = dao.readAll();
        adapter = new SinhVienAdapter(AddActivity.this, data);
        lvsinhvien.setAdapter(adapter);

        btnInsertSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddActivity.this, InsertSinhVienActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        data.clear();
        data.addAll(dao.readAll());
        adapter.notifyDataSetChanged();
    }
}
