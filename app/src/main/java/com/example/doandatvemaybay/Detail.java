package com.example.doandatvemaybay;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class Detail extends AppCompatActivity {
    TextView ngaydi, ngayden, giobay, diemdi, machuyenbay, giodi, diemden, gioden, giave;
    Button btnTiepTucDatVe, btnback;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        anhXa();
        layThongTin();
        btnTiepTucDatVe = findViewById(R.id.btntieptheo);
        btnTiepTucDatVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(Detail.this, DatChoActivity.class);
                startMain.putExtra("ngaydi", ngaydi.getText().toString());
                startMain.putExtra("ngayden", ngayden.getText().toString());
                startMain.putExtra("gioden", gioden.getText().toString());
                startMain.putExtra("giodi", giodi.getText().toString());
                startMain.putExtra("diemdi", diemdi.getText().toString());
                startMain.putExtra("machuyenbay", machuyenbay.getText().toString());
                startMain.putExtra("diemden", diemden.getText().toString());
                startMain.putExtra("giave", giave.getText().toString());
                startMain.putExtra("giobay", giobay.getText().toString());
                startActivity(startMain);
            }
        });
        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(Detail.this,MainActivity.class);
                startActivity(startMain);
            }
        });

    }
    public  void anhXa(){
        ngaydi = findViewById(R.id.MoTaNgayDi);
        ngayden = findViewById(R.id.MoTaNgayDen);
        gioden = findViewById(R.id.MoTaGioDen);
        giodi = findViewById(R.id.MoTaGioBay);
        diemdi = findViewById(R.id.MoTaNoiDi);
        machuyenbay = findViewById(R.id.MoTaMaChuyenBay);
        giobay = findViewById(R.id.MoTaThoiGianBay);
        diemden = findViewById(R.id.MoTaNoiDem);
        giave = findViewById(R.id.MoTaGiaVe);
        //giave = findViewById(R.id.tongtien);
    }

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent t= new Intent(Detail.this,DatChoActivity.class);
        startActivity(t);
        finish();;
        return false;
    }*/

    public  void layThongTin(){
        Intent intent = getIntent();
        Furniture   fur=intent.getParcelableExtra("xuly");
        //img.setImageBitmap(Furniture.convertStringToBitmapFromAccess(DetailActivity.this, fur.getImageName()));
        ngaydi.setText(fur.getNgaydi());
        giodi.setText(fur.getGiodi());
        diemdi.setText(fur.getDiemdi());
        giobay.setText(fur.getGiobay());
        machuyenbay.setText(fur.getMamaybay());
        ngayden.setText(fur.getNgayden());
        gioden.setText(fur.getGioden());
        diemden.setText(fur.getDiemden());
        giave.setText(fur.getGiave());
        /*ngaydi.setText(t.getStringExtra("ngaydi"));
        giodi.setText(t.getStringExtra("giodi"));
        diemdi.setText(t.getStringExtra("diemdi"));
        giobay.setText(t.getStringExtra("giobay"));
        machuyenbay.setText(t.getStringExtra("machuyenbay"));
        ngayden.setText(t.getStringExtra("ngayden"));
        gioden.setText(t.getStringExtra("gioden"));
        diemden.setText(t.getStringExtra("diemden"));
        giave.setText(t.getStringExtra("giave"));*/

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
   /* public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }*/
}
