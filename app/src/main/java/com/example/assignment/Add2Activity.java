package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.assignment.adapter.LopHocAdapter;
import com.example.assignment.dao.LopHocDAO;
import com.example.assignment.model.LopHoc;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Add2Activity extends AppCompatActivity {
    ListView lvLopHoc;
    ArrayList<LopHoc> data = new ArrayList<>();
    LopHocAdapter adapter;
    LopHocDAO dao;
    FloatingActionButton btnInsert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);
        lvLopHoc = findViewById(R.id.lvLopHoc);
        btnInsert = findViewById(R.id.fbInsertLopHoc);
        dao = new LopHocDAO(Add2Activity.this);
        data = dao.readAll();
        adapter = new LopHocAdapter(Add2Activity.this, data);
        lvLopHoc.setAdapter(adapter);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add2Activity.this, InsertActivity.class);
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
