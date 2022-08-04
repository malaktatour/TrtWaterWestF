package com.example.waterwest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.Guideline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.List;

public class water_usage extends AppCompatActivity {

    ImageView AlertImg;
    ImageView HomeImg;
    TextView WaterUsage;
    AppCompatButton AlertBtn, HomeBtn ;
    Guideline[] WU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_usage);
        AlertImg = findViewById(R.id.stamm2);
        HomeImg = findViewById(R.id.stamm3);
        AlertBtn = findViewById(R.id.AlertBtn);
        HomeBtn = findViewById(R.id.homeBtn);
        WaterUsage=findViewById(R.id.textView);
        WU=new Guideline[7];
        String[] s={"top_graph1","top_graph2","top_graph3","top_graph4","top_graph5","top_graph6","top_graph7"};
        WU[0]=findViewById(R.id.top_graph1);
        WU[1]=findViewById(R.id.top_graph2);
        WU[2]=findViewById(R.id.top_graph3);
        WU[3]=findViewById(R.id.top_graph4);
        WU[4]=findViewById(R.id.top_graph5);
        WU[5]=findViewById(R.id.top_graph6);
        WU[6]=findViewById(R.id.top_graph7);


        //
        new FirebaseDatabaseHelper().readDays(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Day> days, List<String> keys) {
                //new RecyclerView_Config().setConfig(mRecycler, MainActivity.this, days, keys);

                Day latestday= days.get(days.size()-1);
                Double wateramount1= latestday.getTimes().get(latestday.getTimes().size()-1).getValue();
                WaterUsage.setText(new DecimalFormat("##.##").format(latestday.GetUsedAmount()));

                for(int i=0;i< days.size()&&i<7;i++)
                {
                    if(days.size()>=7)
                        WU[i].setGuidelinePercent((float) (0.83-((days.get(days.size()-7+i).GetUsedAmount()/20)*0.13)));
                    else
                        WU[i].setGuidelinePercent((float) (0.83-((days.get(i).GetUsedAmount()/20)*0.13)));;
                }
                //.setGuidelinePercent((float) (wateramount1*(1-0.28))/20);(days.get(i).GetUsedAmount()*(1-0.475))/20

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