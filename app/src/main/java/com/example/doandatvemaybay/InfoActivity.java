package com.example.doandatvemaybay;



import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class InfoActivity extends AppCompatActivity
{

    EditText edtName, edtEmail, edtPass, edtUsername;
    RadioGroup rdbGender;
    RadioButton Male,Female;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Male=findViewById(R.id.radiobutton1);
        Female=findViewById(R.id.radiobutton2);
        edtName = findViewById(R.id.editText4);
        edtEmail = findViewById(R.id.editText);
        edtUsername = findViewById(R.id.editText2);
        edtPass = findViewById(R.id.editText3);
        getSupportActionBar().setTitle("Account Info");
        Intent intent = getIntent();
        edtUsername.setText(intent.getStringExtra("username"));
        edtEmail.setText(intent.getStringExtra("email"));
        edtPass.setText(intent.getStringExtra("password"));
        edtName.setText(intent.getStringExtra("name"));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuSave){
            Intent intent = new Intent(InfoActivity.this,LoginActivty.class);
            intent.putExtra("email", edtEmail.getText().toString());
            intent.putExtra("username", edtUsername.getText().toString());
            intent.putExtra("password", edtPass.getText().toString());
            intent.putExtra("name", edtName.getText().toString());
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);

    }
}

