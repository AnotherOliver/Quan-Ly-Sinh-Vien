package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.dao.QuanTriDAO;
import com.example.assignment.model.User;

public class LoginActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btDangNhap;
    CheckBox ckRem;
    QuanTriDAO qtDao;
    public static User USER = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        qtDao = new QuanTriDAO(LoginActivity.this);
        btDangNhap= findViewById(R.id.btnDangNhap);
        etUsername = findViewById(R.id.txtUsername);
        etPassword = findViewById(R.id.txtPassword);
        ckRem = findViewById(R.id.ckRem);
        loadData();
        btDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String pwd = etPassword.getText().toString();
                boolean check = ckRem.isChecked();
                User user = new User(username, pwd);
                if (qtDao.checkLogin(user)){
                    luuTT(username, pwd, check);
                    USER = user;
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void luuTT(String un, String pwd, boolean check){
        SharedPreferences preferences = getSharedPreferences("thongtin.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (check){
            editor.putString("username", un);
            editor.putString("password", pwd);
            editor.putBoolean("check", check);
        }else {
            editor.clear();
        }
        editor.commit();
    }
    private void loadData(){
        SharedPreferences pref = getSharedPreferences("thongtin.dat", MODE_PRIVATE);
        boolean check = pref.getBoolean("check", false);
        if (check){
            etUsername.setText(pref.getString("username", ""));
            etPassword.setText(pref.getString("password", ""));
            ckRem.setChecked(check);
        }
    }

}
