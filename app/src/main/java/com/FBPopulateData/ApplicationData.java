package com.FBPopulateData;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class ApplicationData extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(ApplicationData.this, FirebaseOptions.fromResource(this));
    }
}
