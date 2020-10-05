package com.example.doandatvemaybay;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DetailSateTrucTiep extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_chitietsaletructiep);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent t= new Intent(DetailSateTrucTiep.this,MainActivity.class);
        startActivity(t);
        finish();;
        return false;
    }
}
