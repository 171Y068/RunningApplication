package com.example.a171y068.runningapplication;

import android.app.ActivityManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private int switchTime; //ボタン制御用
    private long startTime;
    private long stopTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchTime = 1;
        chronometer = findViewById(R.id.chronometer);

        Button Start = findViewById(R.id.StartStopButton);
        Button Stop = findViewById(R.id.StartStopButton);
        Button Restart = findViewById(R.id.StartStopButton);


        Start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(switchTime == 1){
                    //初期スタート
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    startTime = SystemClock.elapsedRealtime();
                    chronometer.start();
                    switchTime = 2;
                }else if(switchTime == 2){
                    //ストップ
                    chronometer.stop();
                    stopTime = SystemClock.elapsedRealtime();
                    switchTime = 3;
                }else if(switchTime == 3){
                    //リスタート

                    long time1 = stopTime - startTime;
                    long time2 = SystemClock.elapsedRealtime() - time1;

                    chronometer.setBase(time2);
                    chronometer.start();

                    switchTime = 2;

                }
            }
        });


    }



}
