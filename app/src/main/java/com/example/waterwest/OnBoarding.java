package com.example.waterwest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import androidx.core.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Currency;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager2;
    LinearLayout dots;
    SliderAdapter sliderAdapter;
    androidx.appcompat.widget.AppCompatButton Lets;
    Animation animation;
    Button Next;
    int currentPos;
    TextView[] dotsLayout;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);
        viewPager2 = findViewById(R.id.slider);
        dots= findViewById(R.id.dotss);
        Lets = findViewById(R.id.lets_start);
        Next = findViewById(R.id.Next);
        img = findViewById(R.id.pur);
        img.setVisibility(View.INVISIBLE);

        viewPager2.setHorizontalFadingEdgeEnabled(false);//no scroll sign
        viewPager2.setOverScrollMode(View.OVER_SCROLL_NEVER);//No scroll sign

        sliderAdapter = new SliderAdapter(this);
        viewPager2.setAdapter(sliderAdapter);
        AddDots(0);
        viewPager2.addOnPageChangeListener(changeListener);
        RelativeLayout ali = findViewById(R.id.relativeLayout);
        Lets.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class); // open new activity
                ActivityOptionsCompat options1 = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(OnBoarding.this, img, "apple");
                startActivity(intent,options1.toBundle()); // open new activity with transition
                img.setVisibility(View.VISIBLE);
                finish();

            }
        });
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2.setCurrentItem(currentPos+1);
            }
        });


    }

    @SuppressLint("ResourceAsColor")
    private void AddDots(int p){
        dotsLayout = new TextView[3];
        dots.removeAllViews();
        for(int i =0 ;i <3;i++)
        {
            dotsLayout[i] = new TextView(this);
            dotsLayout[i].setText(Html.fromHtml("&#8226;"));
            dotsLayout[i].setTextSize(35);
            dotsLayout[i].setTextColor(getResources().getColor(R.color.hintColor));
            dots.addView(dotsLayout[i]); //creating dots into the dots layout(dots)

        }
        if(dotsLayout.length  >0)
        { // change dot color according to current page number
            dotsLayout[p].setTextColor(getResources().getColor(R.color.blue_palette));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            if(currentPos == 3)
                img.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onPageSelected(int position) {
            AddDots(position);
            currentPos = position;
           if(position ==0){
                Lets.setVisibility(View.INVISIBLE);
                img.setVisibility(View.INVISIBLE);

            }else if(position ==1){
                Lets.setVisibility(View.INVISIBLE);
                img.setVisibility(View.INVISIBLE);

            }else if(position ==2)
            {
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bottom_anim);
                Lets.setAnimation(animation);
               // dotsLayout[3].setTextColor(getResources().getColor(R.color.purble_palette));
                Lets.setVisibility(View.VISIBLE);

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}