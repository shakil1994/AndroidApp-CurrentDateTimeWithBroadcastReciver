package com.blackbirds.shakil.currentdatetime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView txtCurrentTime, txtTodayDate;
    AppCompatButton btnNext, btnNext1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCurrentTime = findViewById(R.id.txtCurrentTime);
        txtTodayDate = findViewById(R.id.txtTodayDate);
        btnNext = findViewById(R.id.btnNext);
        btnNext1 = findViewById(R.id.btnNext1);

        txtCurrentTime.setText(getTime());
        txtTodayDate.setText(getDate());

        btnNext.setOnClickListener(v -> {
            startActivity(new Intent(this, NextActivity.class));
        });

        btnNext1.setOnClickListener(v -> {
            startActivity(new Intent(this, NextActivity1.class));
        });
    }

    private String getTime(){
        return new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
    }

    private String getDate(){
        return new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
    }
}