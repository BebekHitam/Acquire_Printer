package com.authenticate;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.DatePickerDialog;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.acquireprinter.MainActivity;
import com.example.acquireprinter.R;

import java.util.Calendar;

public class FillProfile extends AppCompatActivity {
    String selectedDate;
    Activity activity;
    View view;
    Spinner theGender, isMarried;
    TextView TextDate;
    Button pickDate;
    String Male = "Male";
    String Female = "Female";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_profile);



        //-----------------------------------------------------------------------------------------
        //ini untuk dropdown jenis kelamin
        theGender = findViewById(R.id.gender);

        String[] cwk = new String[]{"Gender","Male", "Female"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cwk);
        theGender.setAdapter(adapter);
        //apa yang dilakukan jika dropdown dipencet
        theGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                String soYouAre= (String) adapterView.getItemAtPosition(position);
                if (position==1){
                    Toast.makeText(getApplicationContext(), "so you are men", Toast.LENGTH_SHORT).show();
                }else if (position==2){
                    Toast.makeText(getApplicationContext(), "so you are women", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //------------------------------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------------------
        //ini untuk minta tanggal lahir
        TextDate = findViewById(R.id.TextDatee);
        pickDate = findViewById(R.id.buttonPickDate);


        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(FillProfile.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        selectedDate = day + "/" + (month+1) + "/" + year;
                        TextDate.setText(selectedDate);
                    }
                }, year, month, day);

            }
        });
        //--------------------------------------------------------------------------------------------



        //------------------------------------------------------------------------------------------
        //ini untuk dropdown marital status
        isMarried = findViewById(R.id.marital);
        String[] maritalList = new String[]{"Status","Single", "Married", "Divorce"};
        ArrayAdapter<String> maritalAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, maritalList);
        isMarried.setAdapter(maritalAdapter);
        //apa yang dilakukan jika dropdown dipencet

    }



}
