package com.example.waterwest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class water_usage extends AppCompatActivity {

    ImageView AlertImg;
    ImageView HomeImg;
    AppCompatButton AlertBtn, HomeBtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_usage);
        AlertImg = findViewById(R.id.stamm2);
        HomeImg = findViewById(R.id.stamm3);
        AlertBtn = findViewById(R.id.AlertBtn);
        HomeBtn = findViewById(R.id.homeBtn);
        AlertImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),alerts_activity.class));
                finish();
            }

        });
        AlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),alerts_activity.class));
                finish();
            }

        });
        HomeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }
}