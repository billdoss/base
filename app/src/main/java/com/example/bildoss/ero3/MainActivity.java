package com.example.bildoss.ero3;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        int statutBar = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        getWindow().getDecorView().setSystemUiVisibility(statutBar);
        setContentView(R.layout.activity_main);
        Thread myThread = new Thread(){
            @Override
            public void run() {
               try {
                   sleep(2000);
                   Intent benevoleActivity= new Intent(getApplicationContext(), inscription2.class);
                   startActivity(benevoleActivity);
                   finish();

               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
            }
        };
        myThread.start();
        /*SystemClock.sleep(2000);
        Intent benevoleActivity= new Intent(MainActivity.this, benevole.class);
        startActivity(benevoleActivity);
        finish();*/


    }
}
