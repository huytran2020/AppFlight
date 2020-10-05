package com.example.doandatvemaybay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    EditText edtEmail, edtUsername, edtPassword, edtConfirm;
    Button btnSignIn, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register Account");
        edtEmail = findViewById(R.id.editText);
        edtUsername = findViewById(R.id.editText2);
        edtPassword = findViewById(R.id.editText3);
        edtConfirm = findViewById(R.id.editText4);
        btnSignIn = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isValid(edtEmail.getText().toString())) {
                    edtEmail.setError("Invalid Email Address");
                    return;
                }
                if (edtUsername.getText().toString().isEmpty()) {
                    edtUsername.setError("Username cannot be null ");
                    return;
                }

                if (edtPassword.getText().toString().isEmpty()) {
                    edtPassword.setError("Password required");
                    return;
                }
                if (edtConfirm.getText().toString().isEmpty()) {
                    edtConfirm.setError("Password required");
                    return;
                }
                if(edtPassword.getText().toString().length() < 6) {
                    edtPassword.setError("Minimum 6 number");
                    return;
                }
                if (edtPassword.getText().toString().equals(edtConfirm.getText().toString())) {
                    Intent intent = new Intent(RegisterActivity.this,
                            InfoActivity.class);
                    intent.putExtra("username",
                            edtUsername.getText().toString());
                    intent.putExtra("password",
                            edtPassword.getText().toString());
                    intent.putExtra("email",edtEmail.getText().toString());
                    startActivity(intent);
                } else {
                    edtPassword.setError("Password and confirm password does not match");
                    edtConfirm.setText("");
                    return;
                }
            }
        });
    }
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}




