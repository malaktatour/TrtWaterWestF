package com.example.waterwest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class water_usage extends AppCompatActivity {

    ImageView AlertImg;
    ImageView HomeImg;
    TextView WaterUsage;
    AppCompatButton AlertBtn, HomeBtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_usage);
        AlertImg = findViewById(R.id.stamm2);
        HomeImg = findViewById(R.id.stamm3);
        AlertBtn = findViewById(R.id.AlertBtn);
        HomeBtn = findViewById(R.id.homeBtn);
        WaterUsage=findViewById(R.id.textView);
        new FirebaseDatabaseHelper().readDays(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Day> days, List<String> keys) {
                //new RecyclerView_Config().setConfig(mRecycler, MainActivity.this, days, keys);

                Day latestday= days.get(days.size()-1);
                Double wateramount1= latestday.getTimes().get(latestday.getTimes().size()-1).getValue();
                WaterUsage.setText(new DecimalFormat("##.##").format(latestday.GetUsedAmount()));


            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
        //done.
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