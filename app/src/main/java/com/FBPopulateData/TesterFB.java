package com.FBPopulateData;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.acquireprinter.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class TesterFB extends AppCompatActivity {
    View view;
    private Button uplodd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tester_fb);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> printer = new HashMap<>();
        printer.put("first", "Epson");
        printer.put("city", "Cikarang");
        printer.put("type", 3221);

        uplodd = findViewById(R.id.uplodd);
        uplodd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.collection("users")
                        .add(printer)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(TesterFB.this, "Oke", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(TesterFB.this, "No", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
