package com.authenticate;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.acquireprinter.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FBSign extends AppCompatActivity {
    private FirebaseAuth mAuth;
    View view;
    EditText emailToSend, passwordToSend, confirmPassword;
    Button send;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast.makeText(getApplicationContext(), "not login", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.firebes_sign_data);
        emailToSend = findViewById(R.id.input_emaile);
        passwordToSend = findViewById(R.id.the_passwored_fbs);
        confirmPassword = findViewById(R.id.the_confirm_password);
        send = findViewById(R.id.send_to_firebes);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailPack, passwordPack, pleaseConfirmFirst;
                emailPack = String.valueOf(emailToSend.getText());
                passwordPack = String.valueOf(passwordToSend.getText());
                pleaseConfirmFirst = String.valueOf(confirmPassword.getText());
                if (TextUtils.isEmpty(emailPack)){
                    Toast.makeText(getApplicationContext(), "Please fill email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(passwordPack)) {
                    Toast.makeText(getApplicationContext(), "Please Fill Password", Toast.LENGTH_SHORT).show();
                }
                else if (pleaseConfirmFirst.equals(passwordPack)){
                    mAuth.createUserWithEmailAndPassword(emailPack, passwordPack)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(FBSign.this, "Authentication oke",
                                                Toast.LENGTH_SHORT).show();


                                    } else {
                                        // If sign in fails, display a message to the user.

                                        Toast.makeText(FBSign.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                } else {
                    Toast.makeText(getApplicationContext(), "Password Must same as Confirm Password", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

}
