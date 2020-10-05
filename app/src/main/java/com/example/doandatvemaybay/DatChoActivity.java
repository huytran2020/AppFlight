package com.example.doandatvemaybay;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DatChoActivity extends AppCompatActivity {
    TextView ngaydi, ngayden, giobay, diemdi, machuyenbay, giodi, diemden, gioden, tonggiave, tongthanhtien;
    EditText edtHoTen, edtSdt, edtEmail, edtDiaChi;
    Button btnDatVe, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datvemaybay);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnDatVe = findViewById(R.id.btnChon);
        btnDatVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(DatChoActivity.this, GioHangActivity.class);
                startMain.putExtra("ngaydi", ngaydi.getText().toString());
                startMain.putExtra("gioden", gioden.getText().toString());
                startMain.putExtra("giodi", giodi.getText().toString());
                startMain.putExtra("diemdi", diemdi.getText().toString());
                startMain.putExtra("machuyenbay", machuyenbay.getText().toString());
                startMain.putExtra("diemden", diemden.getText().toString());
                startMain.putExtra("hoten", edtHoTen.getText().toString());
                startMain.putExtra("sdt", edtSdt.getText().toString());
                startActivity(startMain);
            }
        });
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(DatChoActivity.this, Detail.class);
                startActivity(startMain);
            }
        });
        anhXa();
        layThongTin();
    }
    public  void anhXa(){
        ngaydi = findViewById(R.id.textViewMoTaNgayDi);
        ngayden = findViewById(R.id.textViewMoTaNgayDen);
        gioden = findViewById(R.id.textViewMoTaGioDen);
        giodi = findViewById(R.id.textViewMoTaGioDi);
        diemdi = findViewById(R.id.textViewMoTaNoiDi);
        machuyenbay = findViewById(R.id.textViewMoTaMaMayBay);
        giobay = findViewById(R.id.textViewMoTaThoiGianBay);
        diemden = findViewById(R.id.textViewMoTaNoiDen);
        tonggiave = findViewById(R.id.textViewMoTaTongGiaVe);
        tongthanhtien= findViewById(R.id.textViewMoTaTongThanhTien);
        edtHoTen = findViewById(R.id.edtHoVaTen);
        edtSdt = findViewById(R.id.edtSdt);
        edtEmail = findViewById(R.id.edtEmail);
        edtDiaChi = findViewById(R.id.edtDiaChi);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        Intent t= new Intent(Detail.this,DatChoActivity.class);
//        startActivity(t);
//        finish();;
//        return false;
//    }

    public  void layThongTin(){
        Intent intent = getIntent();
        ngaydi.setText(intent.getStringExtra("ngaydi"));
        ngayden.setText(intent.getStringExtra("ngayden"));
        giodi.setText(intent.getStringExtra("giodi"));
        gioden.setText(intent.getStringExtra("gioden"));
        diemdi.setText(intent.getStringExtra("diemdi"));
        machuyenbay.setText(intent.getStringExtra("machuyenbay"));
        diemden.setText(intent.getStringExtra("diemden"));
        tonggiave.setText(intent.getStringExtra("giave"));
        giobay.setText(intent.getStringExtra("giobay"));
        tongthanhtien.setText(intent.getStringExtra("giave"));
        edtHoTen.setText(intent.getStringExtra("hoten"));
        edtSdt.setText(intent.getStringExtra("sdt"));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
