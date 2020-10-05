package com.example.doandatvemaybay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DangKiActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    String sex , name,email,pass,user;
    Button btnLogin, btnRegister;
    Boolean kt=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_dangki);
        edtUsername = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassWord);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegiser);
        Intent intent = getIntent();
        edtUsername.setText(intent.getStringExtra("username"));
        edtPassword.setText(intent.getStringExtra("password"));
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        SharedPreferences share = getSharedPreferences("login", MODE_PRIVATE);
        edtUsername.setText(share.getString("user", ""));
        edtPassword.setText(share.getString("pass", ""));
        name = share.getString("name", "");
        email = share.getString("email", "");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = edtUsername.getText().toString();
                pass = edtPassword.getText().toString();
                if (edtUsername.getText().toString().isEmpty() && edtPassword.getText().toString().isEmpty()) {
                    xacNhanXoa();
                } else if (edtPassword.getText().toString().length() < 6) {
                    edtPassword.setError("Minimum 6 number");
                    return;
                } else if (edtPassword.getText().toString().equals("123456") && edtUsername.getText().toString().equals("huy")) {
                    Intent intent = new Intent(DangKiActivity.this, MainActivity.class);
                    intent.putExtra("username", edtUsername.getText().toString());
                    intent.putExtra("password", edtPassword.getText().toString());
                    intent.putExtra("gioitinh", sex);
                    intent.putExtra("name", name);
                    intent.putExtra("email", email);
                    SharedPreferences trangthai = getSharedPreferences("trangthai", MODE_PRIVATE);
                    SharedPreferences.Editor edit = trangthai.edit();
                    edit.putString("status", "true");
                    edit.apply();
                    SharedPreferences preInfo = getSharedPreferences("infomation", MODE_PRIVATE);
                    SharedPreferences.Editor editInfo = preInfo.edit();
                    editInfo.putString("pass", pass);
                    editInfo.putString("user", user);
                    editInfo.putString("email", email);
                    editInfo.putString("name", name);
                    editInfo.apply();
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent1 = new Intent(DangKiActivity.this, MainActivity.class);
                    edtPassword.getText().toString().equals(intent1.putExtra("username", edtPassword.getText().toString()));
                    edtUsername.getText().toString().equals(intent1.putExtra("username", edtUsername.getText().toString()));
                    startActivity(intent1);
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKiActivity.this,
                        RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == 101){
            edtUsername.setText(data.getStringExtra("username"));
            edtPassword.setText(data.getStringExtra("password"));
        }
        if(requestCode == 102 && resultCode == 101){
            edtUsername.setText(data.getStringExtra("username"));
            edtPassword.setText(data.getStringExtra("password"));
        }
    }
    public void xacNhanXoa(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Thông báo");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setMessage("Bạn có muốn tạo tài khoản không");
        dialog.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(DangKiActivity.this,
                        RegisterActivity.class);
                startActivityForResult(intent, 100);
            }
        });
        dialog.show();
    }
}