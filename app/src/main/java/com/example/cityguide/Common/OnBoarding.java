package com.example.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cityguide.HelperClasses.SliderAdapter;
import com.example.cityguide.R;
import com.example.cityguide.User.UserDashboard;

public class OnBoarding extends AppCompatActivity {

    //(003 variable inflate)

    ViewPager viewPager;
    LinearLayout dotslayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    //(004 vraible )
    Button letsgetstarted;
    Animation animation;
    int currentpostion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        //(003 inflate item in layout  Hooks)
        viewPager=findViewById(R.id.slider);
        dotslayout=findViewById(R.id.dots);
        letsgetstarted=findViewById(R.id.get_started_btn);

        //call adapter
        sliderAdapter=new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

      //(003  add function to add dots )
        adddots(0);
        viewPager.addOnPageChangeListener(changeListener);

    }

    //(004 to skip buton and next button )

    public void Skip(View view){
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
    }
    public void next(View view){
        viewPager.setCurrentItem(currentpostion+1);
    }

    //(003  create adots)
    private void adddots(int position){
        dots=new TextView[4];
        dotslayout.removeAllViews();
        for (int i=0; i<dots.length; i++){

            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotslayout.addView(dots[i]);
        }
        if (dots.length>0){
            dots[position] .setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
           adddots(position);
           currentpostion=position;
          //(004 for ivisible button)
           if (position==0){
               letsgetstarted.setVisibility(View.INVISIBLE);
           }else if (position==1){
               letsgetstarted.setVisibility(View.INVISIBLE);

           }else if (position==2){

               letsgetstarted.setVisibility(View.INVISIBLE);
           }else{
               animation= AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
               letsgetstarted.setAnimation(animation);
                letsgetstarted.setVisibility(View.VISIBLE);

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}