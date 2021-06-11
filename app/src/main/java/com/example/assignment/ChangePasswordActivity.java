package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.dao.QuanTriDAO;
import com.example.assignment.model.User;

public class ChangePasswordActivity extends AppCompatActivity {
    EditText oldPwd, newPwd, rePwd;
    Button  btDmk, btNhapLai;
    QuanTriDAO qtDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        qtDao= new QuanTriDAO(ChangePasswordActivity.this);
        oldPwd = findViewById(R.id.txtOldPwd);
        newPwd = findViewById(R.id.txtNewPwd);
        rePwd = findViewById(R.id.txtRePwd);
        btDmk = findViewById(R.id.btnDoi);
        btNhapLai = findViewById(R.id.btnNhapLai);

        btDmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String old = oldPwd.getText().toString();
                String nPwd = newPwd.getText().toString();
                String re = rePwd.getText().toString();
                String un = LoginActivity.USER.getUsername();
                if (!qtDao.checkOldPwd(old)){
                    Toast.makeText(ChangePasswordActivity.this, "Mật khẩu cũ không đúng", Toast.LENGTH_SHORT).show();
                }else {
                    if (!nPwd.equals(re)){
                        Toast.makeText(ChangePasswordActivity.this, "Mật khẩu nhập lại không đúng", Toast.LENGTH_SHORT).show();
                    }else {
                        if (qtDao.updatePwd(new User(un, nPwd))){
                            Toast.makeText(ChangePasswordActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                            LoginActivity.USER.setPassword(nPwd);
                        }else {
                            Toast.makeText(ChangePasswordActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}
