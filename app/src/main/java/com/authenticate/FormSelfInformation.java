package com.authenticate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.acquireprinter.R;

public class FormSelfInformation extends AppCompatActivity {
    View view;

    EditText currentLocation;
    Button getLocation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_self_information);
        getLocation = findViewById(R.id.to_the_map);

    }
}
