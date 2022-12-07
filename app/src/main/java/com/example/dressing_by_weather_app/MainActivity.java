package com.example.dressing_by_weather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    // 4mp-ig látható a splash screen
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Elrejti az action bar-t, (Dressing_by_weather_app)-ot.
        getSupportActionBar().hide();

        // SplashScreen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                // a dedikált back gomb a telefonon így nem fog a Splash screen-re visszanavigálni.
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}