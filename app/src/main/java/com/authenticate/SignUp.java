package com.authenticate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.acquireprinter.R;
import com.forTheData.DataAsistant;

public class SignUp extends AppCompatActivity {
    View view;
    EditText firstName, lastName, email, password, confirmPassword, city;
    String theFirstName, theLastName, theEmail, thePassword, theConfirmPassword, theCity;
    Button signUp, ferbesSignup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        firstName = findViewById(R.id.first_name_edit_text);
        lastName = findViewById(R.id.last_name_edit_text);
        email = findViewById(R.id.email_edit_text);
        password = findViewById(R.id.password_edit_text);
        confirmPassword = findViewById(R.id.confirm_password_edit_text);
        city = findViewById(R.id.city_edit_text);
        signUp = findViewById(R.id.sign_up_button);
        ferbesSignup = findViewById(R.id.firebes_signup);


        //------------------------------------------------------------------------------------------
        //mendapatkan string dari semuanya
        theFirstName = firstName.getText().toString().toLowerCase();
        theLastName = lastName.getText().toString().toLowerCase();
        theEmail = email.getText().toString();
        thePassword = password.getText().toString();
        theConfirmPassword = confirmPassword.getText().toString();
        theCity = city.getText().toString().toLowerCase();
        //------------------------------------------------------------------------------------------

        //------------------
        //menunggu action dari button submit
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mengkoleksi semua data menjadi string untuk dilempar ke databes
                theFirstName = firstName.getText().toString().toLowerCase();
                theLastName = lastName.getText().toString().toLowerCase();
                theEmail = email.getText().toString();
                thePassword = password.getText().toString();
                theConfirmPassword = confirmPassword.getText().toString();
                theCity = city.getText().toString().toLowerCase();

                if (theFirstName.isEmpty() || theEmail.isEmpty() || thePassword.isEmpty() || theCity.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Fill data", Toast.LENGTH_SHORT).show();


                        //Jalankan main perintahnya

                } else if (thePassword.equals(theConfirmPassword)) {
                    DataAsistant send = new DataAsistant(getApplicationContext());
                    send.insertProfile(theFirstName, theLastName, theEmail, thePassword, theCity);
                    Intent intent=new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);

                    //Jalankan main perintahnya

                } else{
                    Toast.makeText(getApplicationContext(), "Password not same as confirm password", Toast.LENGTH_SHORT).show();
                }


            }
        });
        ferbesSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FBSign.class);
                startActivity(intent);
            }
        });

        //------------------

        //------------------------------------------------------------------------------------------
        //ini untuk toast jika password sama confirm beda

        //------------------------------------------------------------------------------------------

        //------------------------------------------------------------------------------------------
        //disini adalah untuk sqlite dabes helper
    }
}
