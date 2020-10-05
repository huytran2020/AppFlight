package com.example.doandatvemaybay;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;

public class AccountFragment extends Fragment {

    Button btnDangXuat;
    EditText edtName,edtEmail,edtUsername,edtPass;
    public AccountFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        edtUsername=view.findViewById(R.id.user);
        edtPass=view.findViewById(R.id.pass);
        edtEmail=view.findViewById(R.id.email);
        edtName=view.findViewById(R.id.name);
        LoadDataFromSharePreferences();
        btnDangXuat = view.findViewById(R.id.btnDangXuat);
        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SharedPreferences pre = getContext().getSharedPreferences("statusLogin",MODE_PRIVATE);
                //tạo đối tượng để lưuu
                SharedPreferences trangthai =getContext().getSharedPreferences("trangthai",MODE_PRIVATE);
                SharedPreferences.Editor edit=trangthai.edit();
                edit.putString("status","false");
                edit.apply();

                SharedPreferences preInfo = getContext().getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editInfo=preInfo.edit();
                editInfo.putString("pass",edtPass.getText().toString());
                editInfo.putString("user",edtUsername.getText().toString());
                editInfo.putString("email",edtEmail.getText().toString());
                editInfo.putString("name",edtName.getText().toString());
                editInfo.apply();
                Intent startMain = new Intent(getContext(), LoginActivty.class);
                startActivity(startMain);
            }
        });
    }
    private void LoadDataFromSharePreferences(){

        SharedPreferences share = getContext().getSharedPreferences("infomation",MODE_PRIVATE);
        edtName.setText(share.getString("name","hai"));
        edtEmail.setText(share.getString("email","hai@gmail.com"));
        edtUsername.setText(share.getString("user","hai"));
        edtPass.setText(share.getString("pass","123456"));

    }
}


