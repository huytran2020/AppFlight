package com.example.doandatvemaybay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GioHangActivity extends AppCompatActivity {
    TextView txtHoTen, txtSdt;
    TextView ngaydi, ngayden, giobay, diemdi, machuyenbay, giodi, diemden, gioden;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_giohang);
        anhXa();
        layThongTin();
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(GioHangActivity.this, MainActivity.class);
                startActivity(startMain);
            }
        });
    }
    public  void anhXa(){
        ngaydi = findViewById(R.id.textViewMoTaNgayDi);
        gioden = findViewById(R.id.textViewMoTaGioDen);
        giodi = findViewById(R.id.textViewMoTaGioDi);
        diemdi = findViewById(R.id.textViewMoTaNoiDi);
        machuyenbay = findViewById(R.id.textViewMoTaMaMayBay);
        diemden = findViewById(R.id.textViewMoTaNoiDen);
        txtHoTen = findViewById(R.id.textViewMoTaHoTen);
        txtSdt = findViewById(R.id.textViewMoSdt);
    }
    public  void layThongTin(){
        Intent intent = getIntent();
        ngaydi.setText(intent.getStringExtra("ngaydi"));
        giodi.setText(intent.getStringExtra("giodi"));
        gioden.setText(intent.getStringExtra("gioden"));
        diemdi.setText(intent.getStringExtra("diemdi"));
        machuyenbay.setText(intent.getStringExtra("machuyenbay"));
        diemden.setText(intent.getStringExtra("diemden"));
        txtHoTen.setText(intent.getStringExtra("hoten"));
        txtSdt.setText(intent.getStringExtra("sdt"));
    }
}
