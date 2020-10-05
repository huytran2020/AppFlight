package com.example.doandatvemaybay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.Context.MODE_PRIVATE;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(
                new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivty.class);
                startActivity(intent);
                finish();

                SharedPreferences pre = getSharedPreferences("trangthai",MODE_PRIVATE);

                String kt=pre.getString("status","true");
                if(kt.equals("true"))
                {
                    Intent intent1 = new Intent(WelcomeActivity.this, LoginActivty.class);
                    startActivity(intent1);
                    finish();
                }
                else {
                    Intent intent1 = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent1);
                    finish();
                }
            }
        },3000);
    }
}
