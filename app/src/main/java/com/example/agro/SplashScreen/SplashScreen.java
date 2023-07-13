package com.example.agro.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.agro.Login.LoginActivity;
import com.example.agro.Activities.MainActivity;
import com.example.agro.Session.SessionManagement;
import com.example.agro.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {

    ActivitySplashScreenBinding splashXml;
    SessionManagement sessionManagement;
    Handler handle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashXml=ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(splashXml.getRoot());


        splashXml.loadingImg.animate().translationY(3400).setDuration(1000).setStartDelay(3000);
        splashXml.splashConstraint.animate().translationY(3400).setDuration(1000).setStartDelay(3000);
        splashXml.agroImg.animate().scaleX(5.0f).setDuration(1000).setStartDelay(3100);
        splashXml.agroImg.animate().scaleY(5.0f).setDuration(1000).setStartDelay(3100);
        splashXml.agroImg.animate().alpha(0).setDuration(1000).setStartDelay(3300);
        handle=new Handler();

        handle.postDelayed(new Runnable() {
            @Override
            public void run() {


               sessionManagement=new SessionManagement(SplashScreen.this);


                if (sessionManagement.GetEmail().equals("") ) {
                    Intent intent1 = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(intent1);
                    finish();

                } else {
                    Intent intent2 = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent2);

                }
                finish();

            }
        },4500);



    }
}