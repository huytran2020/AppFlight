package com.example.doandatvemaybay;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    Button btnChiTiet, getBtnChiTietTrucTiep;
    Button btnDangKi, btnDatVe;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        btnChiTiet = view.findViewById(R.id.btnchiTietKhuyenMai);
        btnChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(getContext(), DetailSale.class);
                startActivity(startMain);
            }
        });
        getBtnChiTietTrucTiep = view.findViewById(R.id.btnXemChiTiet);
        getBtnChiTietTrucTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(getContext(), DetailSateTrucTiep.class);
                startActivity(startMain);
            }
        });
        btnDangKi = view.findViewById(R.id.btnDangKi);
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(getContext(), DangKiActivity.class);
                startActivity(startMain);
            }
        });
        btnDatVe = view.findViewById(R.id.btnDatChuyenBay);
        btnDatVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(getContext(), DatChoActivity.class);
                startActivity(startMain);
            }
        });
    }
}
