package com.example.doandatvemaybay;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LotusmilesFragment extends Fragment {
    EditText edtUsername, edtPassword;
    String sex , name,email,pass,user;
    Button btnLogin, btnRegister;
    Boolean kt=true;
    public LotusmilesFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lotusmiles, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnRegister = view.findViewById(R.id.btnRegiser);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(getContext(), DangKiActivity.class);
                startActivity(startMain);
            }
        });
        super.onViewCreated(view, savedInstanceState);
        edtUsername = view.findViewById(R.id.edtUser);
        edtPassword = view.findViewById(R.id.edtPassWord);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnRegister = view.findViewById(R.id.btnRegiser);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=edtUsername.getText().toString();
                pass=edtPassword.getText().toString();
                if(edtPassword.getText().toString().equals("123456")&&edtUsername.getText().toString().equals("hai")) {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                }
            }
        });
    }
}
