package com.example.dressing_by_weather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvResAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResAct = findViewById(R.id.tvResAct);

        String temp2 = getIntent().getStringExtra("TEMP");

        tvResAct.setText(temp2);

    }
}