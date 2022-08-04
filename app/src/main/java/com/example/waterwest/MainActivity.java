package com.example.waterwest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button AlertBtn;
TextView WaterUsageBtn;
TextView WaterUsage;
TextView Wateramount;
Guideline tankguideline;
//new.
//private RecyclerView mRecycler;
//done.
    androidx.constraintlayout.widget.Guideline topwater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //new.
        //mRecycler = (RecyclerView) findViewById(R.id.recyclerView_days);
        WaterUsage=findViewById(R.id.todayL);
        Wateramount=findViewById(R.id.LitersRemaining1);
        tankguideline=findViewById(R.id.watertop);
        new FirebaseDatabaseHelper().readDays(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Day> days, List<String> keys) {
                //new RecyclerView_Config().setConfig(mRecycler, MainActivity.this, days, keys);

                Day latestday= days.get(days.size()-1);
                Double wateramount1= latestday.getTimes().get(latestday.getTimes().size()-1).getValue();
                Wateramount.setText(wateramount1.toString());
                WaterUsage.setText(new DecimalFormat("##.##").format(latestday.GetUsedAmount()));
                tankguideline.setGuidelinePercent((float) (wateramount1*(1-0.28))/20);
                //(float)(((20-wateramount1)*0.28)/20)(wateramount1*(1-0.28))/20)

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

        // topwater = findViewById(R.id.watertop);
      //  topwater.setGuidelinePercent((float) 0.3); // to raise water in the tank
        WaterUsageBtn = findViewById(R.id.WaterUsageBtn);
        AlertBtn = findViewById(R.id.AlertBtn);
        AlertBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
             Intent i = new Intent(getApplicationContext(),alerts_activity.class);
             startActivity(i);
             finish();

    }
});
        WaterUsageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),water_usage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}