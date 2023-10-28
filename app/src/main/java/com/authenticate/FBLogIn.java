package com.authenticate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.acquireprinter.MainActivity;
import com.example.acquireprinter.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FBLogIn extends AppCompatActivity {
    private FirebaseAuth mAuth;
    View view;
    private Button login, sugnup;
    private EditText email, password;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebes_login_strike);

        email = findViewById(R.id.in_for_email);
        password = findViewById(R.id.in_for_psw);

        mAuth = FirebaseAuth.getInstance();

        login = findViewById(R.id.ke_login);
        sugnup = findViewById(R.id.ke_sign_up);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emaile = email.getText().toString();
                String passworde = password.getText().toString();
                if (emaile.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Fill email", Toast.LENGTH_SHORT).show();
                }
                if (passworde.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Fill Password", Toast.LENGTH_SHORT).show();
                }
                mAuth.signInWithEmailAndPassword(emaile, passworde)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    Intent intenn = new Intent(FBLogIn.this, MainActivity.class);
                                    startActivity(intenn);
                                    finish();
                                    Toast.makeText(FBLogIn.this, "Selamat datang " + emaile, Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(FBLogIn.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });
        sugnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inton = new Intent(getApplicationContext(), FBSign.class);
                startActivity(inton);
                finish();
            }
        });


    }
}
