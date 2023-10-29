package com.authenticate;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FillProfile extends AppCompatActivity {

    String selectedDate;
    Activity activity;
    View view;
    Spinner theGender, isMarried;
    TextView TextDate;
    Button pickDate;
    String Male = "Male";
    String Female = "Female";
    private EditText dateEditText;
    private Calendar calendar;
    Button submitPlease;

    //isi firebase dulu dong boss
    private FirebaseAuth auth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_profile);

        //initiate firebase
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        //cek user boolean null or not
        FirebaseUser user = auth.getCurrentUser();




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
        dateEditText = findViewById(R.id.dateEditText);
        calendar = Calendar.getInstance();

        //--------------------------------------------------------------------------------------------



        //------------------------------------------------------------------------------------------
        //ini untuk dropdown marital status
        isMarried = findViewById(R.id.marital);
        String[] maritalList = new String[]{"Status","Single", "Married", "Divorce"};
        ArrayAdapter<String> maritalAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, maritalList);
        isMarried.setAdapter(maritalAdapter);
        //apa yang dilakukan jika dropdown dipencet



        //---------------------------------------------
        //apa yang akan dilakukan ketika tombol submit dipencet
        submitPlease = findViewById(R.id.kirim_semuanya);
        submitPlease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if pertama adalah untuk melakukan checking apakah user ada

                if (user == null){
                    Toast.makeText(getApplicationContext(), "Anda Belum masuk", Toast.LENGTH_SHORT).show();
                } else if (user != null) {
                    Toast.makeText(getApplicationContext(), "Terkirim tapi belum kecantol", Toast.LENGTH_SHORT).show();

                }
            }
        });

        //-----------------------------------------------

    }

    //-------------------
    //membuat method picker date
    public void showDatePickerDialog(View view) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                calendar.set(selectedYear, selectedMonth, selectedDay);
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy", Locale.US);
                dateEditText.setText(sdf.format(calendar.getTime()));
            }
        }, year, month, day);

        datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                dateEditText.setText(""); // Clear the date if the user cancels the selection
            }
        });

        datePickerDialog.show();
    }

    //--------------------------



}
