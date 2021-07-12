package com.blackbirds.shakil.currentdatetime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class NextActivity extends AppCompatActivity {

    //broadcast class is used as nested class
    private BroadcastReceiver mtimeInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context c, Intent i) {
            //initialize objects
            TextView textv=(TextView)findViewById(R.id.textView1);
            Calendar calendar=Calendar.getInstance();
            //display time on toast
            Toast.makeText(c, "current time is--- :-"+calendar.getTime(), Toast.LENGTH_LONG).show();
            //set time on text view
            textv.setText(""+calendar.getTime());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        //use action time tick for getting update every minute
        IntentFilter mTime = new IntentFilter(Intent.ACTION_TIME_TICK);
        //register broadcast receiver
        registerReceiver(mtimeInfoReceiver, mTime);
    }
}