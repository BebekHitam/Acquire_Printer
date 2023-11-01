package com.authenticate;
import com.example.acquireprinter.MainActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.acquireprinter.R;
import com.google.firebase.auth.FirebaseAuth;
import com.stall.ItemDetail;

/*
* this is the path where i connect to the firebase
* what i'm doing is i press the tools > firebase > and i choose authentication
* i follow what authentication want me to do
* i make an project to firebase web with the same name in project
* untuk menambahkan keystone masuk ke terminal
* keytool -list -v \
  -alias androiddebugkey -keystore ~/.android/debug.keystore
*


 */

public class Login extends AppCompatActivity {

    //initiate firebase
    private FirebaseAuth AuthenticationLogin;
    Button login;
    Button signup, logFirebes;
    private TextView skip;
    EditText email, passwored;
    String ehmail, ohpassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        logFirebes = findViewById(R.id.kefirebes_login);

        //Start firebase in here
        AuthenticationLogin = FirebaseAuth.getInstance();
        skip = (TextView) findViewById(R.id.skip_button);
        email = (EditText) findViewById(R.id.input_email);
        passwored = (EditText) findViewById(R.id.the_passwored_that_i_got);
        signup = (Button) findViewById(R.id.signupBbutton);
        login = (Button) findViewById(R.id.ButtonLogin);




        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intens = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intens);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ehmail = email.getText().toString();
                ohpassword = passwored.getText().toString();
                if (ehmail.isEmpty() && ohpassword.isEmpty()){

                    Toast.makeText(getApplicationContext(), "Please fill true data", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "SelamatDatang " + ehmail, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                }
            }
        });
        logFirebes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, FBLogIn.class);
                startActivity(intent);
            }
        });



    }
    @Override
    public void onBackPressed() {
        // Call finish to exit the activity
        finish();
    }
}
