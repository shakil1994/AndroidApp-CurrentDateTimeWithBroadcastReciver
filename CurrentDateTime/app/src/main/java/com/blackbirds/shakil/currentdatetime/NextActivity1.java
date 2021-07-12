package com.blackbirds.shakil.currentdatetime;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NextActivity1 extends AppCompatActivity {

    TextView txtCurrentTime, txtTodayDate;

    private BroadcastReceiver mtimeInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context c, Intent i) {
            //initialize objects
            txtCurrentTime = findViewById(R.id.txtCurrentTime);
            txtTodayDate = findViewById(R.id.txtTodayDate);

            String time = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
            String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
            /*Calendar calendar=Calendar.getInstance();
            //display time on toast
            Toast.makeText(c, "current time is--- :-"+calendar.getTime(), Toast.LENGTH_LONG).show();*/
            //set time on text view
            txtCurrentTime.setText(time);
            txtTodayDate.setText(date);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next1);

        //use action time tick for getting update every minute
        IntentFilter mTime = new IntentFilter(Intent.ACTION_TIME_TICK);
        IntentFilter mDate = new IntentFilter(Intent.ACTION_DATE_CHANGED);
        //register broadcast receiver
        registerReceiver(mtimeInfoReceiver, mTime);
        registerReceiver(mtimeInfoReceiver, mDate);
    }
}