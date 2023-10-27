package com.SplashScreen;
import com.authenticate.Login;
import com.example.acquireprinter.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class SplashScreen extends AppCompatActivity {
    Handler theFirstPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        theFirstPage = new Handler();
        theFirstPage.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent van = new Intent(SplashScreen.this, Login.class);
                startActivity(van);
                finish();
            }
        }, 3000);

    }

}
