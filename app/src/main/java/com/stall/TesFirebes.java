package com.stall;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.authenticate.Profile;
import com.example.acquireprinter.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TesFirebes extends AppCompatActivity {
    String firsname, lastname, email, password, city;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tes_firebes);
        //nitialize the Firebase Realtime Database
        FirebaseDatabase fbdatabase = FirebaseDatabase.getInstance();
        //Create a new node in the Firebase Realtime Database for your data
        DatabaseReference referensidata = fbdatabase.getReference("profiles");
        //referensidata.setValue(new profile(firsname, lastname, email, password, city));


    }
}
