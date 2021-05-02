package com.example.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguide.R;
import com.example.cityguide.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {
    //animate timer(002)
    public static int SPLASH_TIMER=5000;
  // inflate splash screen vraibles(002    )
    ImageView backgroundimageView;
    TextView poweredbyline;
    //Animation inflate variables(002)
    Animation slidanim,bottomanim;
    //vraible (004)
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 001   remove status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        // inflate splash screen (002    8:07)
        backgroundimageView=findViewById(R.id.backgroind_image);
        poweredbyline=findViewById(R.id.powered_by_line);
        //Animation(002)
        slidanim= AnimationUtils.loadAnimation(this,R.anim.slide_anim);
        bottomanim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        //set Animation on element(002)
        backgroundimageView.setAnimation(slidanim);
        poweredbyline.setAnimation(bottomanim);
        //animate timer on screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //(004)
                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isfristtime = onBoardingScreen.getBoolean("fristtime", true);
                if (isfristtime) {
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("fristtime", false);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), OnBoarding.class);
                    startActivity(intent);
                    finish();

                } else {

                    Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                    startActivity(intent);
                    finish();
                }

            }

        },SPLASH_TIMER);


    }
}