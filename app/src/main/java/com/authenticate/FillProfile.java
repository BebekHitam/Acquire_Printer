package com.authenticate;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FillProfile extends AppCompatActivity {

    String selectedDate;
    Activity activity;
    View view;
    Spinner theGender, isMarried;
    TextView TextDate;
    Button pickDate;
    String Male = "Male";
    String Female = "Female";
    private EditText FirstName, LastName, dateEditText, jobs, kanpani, ahome, lastEducation, telep, emergencyTelep;
    private Calendar calendar;
    Button submitPlease;
    private String firstname, lastname, gendernya, birth, job, companyon, hometown, marriedal, lasteducation, phone, emergencyphone ;

    //isi firebase dulu dong boss
    private FirebaseAuth auth;
    private FirebaseFirestore db;
    FirebaseDatabase database;
    private FirebaseUser userNow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_profile);

        //userNow = FirebaseAuth.getInstance().getCurrentUser();



        //initiate firebase
        auth = FirebaseAuth.getInstance();
        userNow = auth.getCurrentUser();
        db = FirebaseFirestore.getInstance();
        FirstName = findViewById(R.id.first_name_edit_text);
        LastName = findViewById(R.id.last_name_edit_text);
        //gender
        jobs = findViewById(R.id.job_edit_text);
        kanpani = findViewById(R.id.office_or_agency_edit_text);
        ahome = findViewById(R.id.hometown_edit_text);
        //marital status
        lastEducation = findViewById(R.id.last_education_edit_text);
        telep = findViewById(R.id.phone_number_edit_text);
        emergencyTelep = findViewById(R.id.emergency_phone_number_edit_text);


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
                    Toast.makeText(getApplicationContext(), "Hello Mr.", Toast.LENGTH_SHORT).show();
                    gendernya = "male";
                }else if (position==2){
                    Toast.makeText(getApplicationContext(), "Hello Mrs.", Toast.LENGTH_SHORT).show();
                    gendernya = "female";
                }else{
                    gendernya = "unknown";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                gendernya = "unknown";

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
                    Toast.makeText(getApplicationContext(), "You not logged in yet", Toast.LENGTH_SHORT).show();
                } else if (user != null) {

                    onItemSubmitted();

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
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                dateEditText.setText(sdf.format(calendar.getTime()));
                birth = sdf.format(calendar.getTime());
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

    //get semua data dan pada saat onclick langsung kirim ke firebase
    /*
    private void onItemSubmitted() {
        String firstname = FirstName.getText().toString();
        String lastname = LastName.getText().toString();
        String job = jobs.getText().toString();
        String companyon = kanpani.getText().toString();
        String hometown = ahome.getText().toString();
        String lasteducation = lastEducation.getText().toString();
        String phone = telep.getText().toString();
        String emergencyphone = emergencyTelep.getText().toString();

        if (firstname.isEmpty() || hometown.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill in all data", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userNow != null) {
            String Uid = userNow.getUid();
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(Uid);

            Map<String, Object> profilData = new HashMap<>();
            profilData.put("firstname", firstname);
            profilData.put("lastname", lastname);
            profilData.put("job", job);
            profilData.put("company", companyon);
            profilData.put("hometown", hometown);
            profilData.put("education", lasteducation);
            profilData.put("telp", phone);
            profilData.put("emergency telp", emergencyphone);

            userRef.setValue(profilData)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(), "Data delivered successfully", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Data failed to deliver", Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            Toast.makeText(getApplicationContext(), "Please login first", Toast.LENGTH_SHORT).show();
        }
    }*/


    private void onItemSubmitted(){


        firstname = FirstName.getText().toString();
        lastname = LastName.getText().toString();
        //gendernya = gendernya.toString();
        //birth
        job = jobs.getText().toString();
        companyon = kanpani.getText().toString();
        hometown = ahome.getText().toString();
        //marriedStatus
        lasteducation = lastEducation.getText().toString();
        phone = telep.getText().toString();
        emergencyphone = emergencyTelep.getText().toString();

        if (firstname.isEmpty()){
            Toast.makeText(getApplicationContext(), "please fill data first", Toast.LENGTH_SHORT).show();
        } else if (hometown.isEmpty()) {
            Toast.makeText(getApplicationContext(), "please fill complete data", Toast.LENGTH_SHORT).show();
        }else{
            if (userNow != null){
                String Uid = userNow.getUid();
                //DocumentReference documentReference = db.collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
                Map<String, Object> profilData = new HashMap<>();
                profilData.put("firstname", firstname);
                profilData.put("lastname", lastname);
                profilData.put("job", job);
                profilData.put("company", companyon);
                profilData.put("hometown", hometown);
                profilData.put("education", lasteducation);
                profilData.put("telp", phone);
                profilData.put("emergency telp", emergencyphone);
                DocumentReference userRef = FirebaseFirestore.getInstance().collection("users").document(Uid);

                // Write the user profile data to Firebase


                //tambahkan bila sukses dan bila gagal
                //documentReference.set(profilData).addOnSuccessListener()

                //Toast.makeText(getApplicationContext(), "data delivered succesfully", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(this, Profile.class);
                userRef.set(profilData).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Data uploaded successfully
                        Toast.makeText(getApplicationContext(), "data delivered succesfully", Toast.LENGTH_SHORT).show();

                        // Perform actions related to successful upload
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Data upload failed
                        Toast.makeText(getApplicationContext(), "data fail to deliver", Toast.LENGTH_SHORT).show();

                        // Handle upload failure scenario
                    }
                });

                //startActivity(intent);
            } else if (userNow == null) {
                Toast.makeText(getApplicationContext(), "please login first", Toast.LENGTH_SHORT).show();

            }

        }


    }



}
