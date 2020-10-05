package com.example.doandatvemaybay;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class DetailSale extends AppCompatActivity {
    Button btnDatNgay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_chitietsale);
    }
        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            Intent t= new Intent(DetailSale.this,MainActivity.class);
            startActivity(t);
            finish();;
            return false;
        }
   /* @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        btnDatNgay = view.findViewById(R.id.btnchiTietKhuyenMai);
        btnDatNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(getContext(), DetailSale.class);
                startActivity(startMain);
            }
        });
    }*/
}
