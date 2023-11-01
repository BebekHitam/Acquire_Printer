package com.SplashScreen;
import com.authenticate.FBLogIn;
import com.authenticate.Login;
import com.example.acquireprinter.MainActivity;
import com.example.acquireprinter.R;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class SplashScreen extends AppCompatActivity {
    FirebaseAuth mAuth;
    Handler theFirstPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();


        theFirstPage = new Handler();
        theFirstPage.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentUser == null){
                    Intent van = new Intent(SplashScreen.this, FBLogIn.class);
                    startActivity(van);
                    finish();
                } else if (currentUser != null) {
                    Intent vane = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(vane);
                    finish();

                }
            }
        }, 3000);

    }

}
