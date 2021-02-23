package com.example.searchviewonactionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private float progresses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                gotoApp();
            }
        });
        thread.start();
    }

    public void doWork(){
        for (progresses = (float) .2; progresses<=100; progresses= (float) (progresses+.2)){
            try {
                Thread.sleep(5);
                progressBar.setProgress((int) progresses);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void gotoApp(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}