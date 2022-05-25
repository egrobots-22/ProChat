package com.egrobots.prochat.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.egrobots.prochat.MainActivity;
import com.egrobots.prochat.R;

public class SplashScreen extends AppCompatActivity {

    private static final long SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashScreen.this, SignUpActivity.class));
        }, SPLASH_TIME_OUT);
    }
}