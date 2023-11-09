package com.FBPopulateData;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.acquireprinter.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class ThePopulator extends AppCompatActivity {
    View view;
    private EditText printerName, printerPrice, printerLocation;
    ImageView printerView;
    private Button chooseImage, submit;
    private TextView nameOfImage;
    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.populator_layout);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseStorage storage = FirebaseStorage.getInstance();


        printerName = findViewById(R.id.nameoftheprinter);
        chooseImage = findViewById(R.id.go_to_file);
        nameOfImage = findViewById(R.id.image_name);
        printerView = findViewById(R.id.the_sample);
        printerPrice = findViewById(R.id.the_harga);
        printerLocation = findViewById(R.id.printer_lokasi);
        submit = findViewById(R.id.launch_to);


        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImage();
            }
        });



        /*
        //masukkan dulu dalam set on click listener
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namanya = printerName.getText().toString();
                String harga = printerPrice.getText().toString();
                String lokasi = printerLocation.getText().toString();


                FBDataModelPrinter printer = new FBDataModelPrinter();
                printer.setName(namanya);

                printer.setPrice(Integer.parseInt(harga));
                printer.setCity(lokasi);
                db.collection("printers")
                        .add(printer)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    // Successfully added data to Firestore
                                    Toast.makeText(ThePopulator.this, "Upload oke", Toast.LENGTH_SHORT).show();
                                }
                            })
                        .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // Handle the error
                                    Toast.makeText(ThePopulator.this, "Failed Upload", Toast.LENGTH_SHORT).show();
                                }
                            });






            }
        });*/

    }
    private void pickImage() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    //handle user image selection
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {
            if (data != null) {

                final Uri imageUri = data.getData();

                Glide.with(this)
                        .load(imageUri)
                        .diskCacheStrategy(DiskCacheStrategy.ALL) // Optional: Cache the image
                        .into(printerView);
                //preview nama imagenya
                String imageName = imageUri.getLastPathSegment();
                nameOfImage.setText(imageName);


                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FirebaseFirestore db = FirebaseFirestore.getInstance();

                        String namanya = printerName.getText().toString();
                        String harga = printerPrice.getText().toString();
                        String lokasi = printerLocation.getText().toString();

                        if (namanya.isEmpty()|| harga.isEmpty() || lokasi.isEmpty()){
                            Toast.makeText(ThePopulator.this, "Please Fill the data", Toast.LENGTH_SHORT).show();
                        }

                        FBDataModelPrinter printer = new FBDataModelPrinter();
                        printer.setName(namanya);
                        printer.setPrice(Integer.parseInt(harga));
                        printer.setCity(lokasi);
                        db.collection("printers")
                                .add(printer)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        // Successfully added data to Firestore
                                        Toast.makeText(ThePopulator.this, "Upload oke", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        // Handle the error
                                        Toast.makeText(ThePopulator.this, "Failed Upload", Toast.LENGTH_SHORT).show();
                                    }
                                });





                        // Upload the selected image to Firebase Storage
                        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("images/" + imageUri.getLastPathSegment());
                        storageReference.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                // The image has been successfully uploaded to Firebase Storage
                                // Get the download URL for the image
                                //Uri downloadUrl = taskSnapshot.getDownloadUrl();
                                Toast.makeText(ThePopulator.this, "Upload succesfull", Toast.LENGTH_SHORT).show();

                                // Do something with the download URL (e.g., display it or save it to a database)
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // The image failed to upload to Firebase Storage
                                // Handle the error
                                Toast.makeText(ThePopulator.this, "Upload Failed Succesfully", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });


            }
        }
    }
    public void stringCollector(){

    }




}
