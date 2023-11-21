package com.stall;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.authenticate.FBLogIn;
import com.authenticate.FBSign;
import com.authenticate.ProfileView;
import com.example.acquireprinter.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.rental.path.RentalAggreement;

public class ItemDetail extends AppCompatActivity {
    FirebaseAuth isMe;
    View view;
    private Button visit, rent, favourite, chat;
    CardView profill;
    ImageView object;
    TextView thePrinterName, priceForRent, printerLocation, id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_view);
        thePrinterName = findViewById(R.id.item_name);
        priceForRent = findViewById(R.id.item_price);
        printerLocation = findViewById(R.id.item_location);
        object = findViewById(R.id.item_image);
        ImageDownloader imegg = new ImageDownloader(object);
        //AdapterImageViewForItemDetail adapImage = new AdapterImageViewForItemDetail(object);



        Intent intent = getIntent();
        String myExtra = intent.getStringExtra("identifikasi");

        if (myExtra != null) {
            Toast.makeText(getApplicationContext(), myExtra, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "noDataReceived", Toast.LENGTH_SHORT).show();
        }
        FirebaseFirestore dbase = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = dbase.collection("printers");
        //CollectionReference collectionReference = (CollectionReference) dbase.collection("printers").orderBy("documentID");


        String iydi = myExtra;
        Query query = collectionReference.whereEqualTo("laneID", myExtra);
        //Query query = collectionReference.orderBy("laneID", Query.Direction.ASCENDING).whereEqualTo("documentID", myExtra);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        String printerName = documentSnapshot.getString("name");
                        thePrinterName.setText(printerName);
                        String city = documentSnapshot.getString("city");
                        printerLocation.setText(city);
                        Double price = (double) documentSnapshot.get("price");
                        String pricy = price.toString();
                        priceForRent.setText(pricy);
                        String image = documentSnapshot.getString("image");
                        imegg.execute(image);


                    }
                }else {
                    Toast.makeText(ItemDetail.this, "error get data", Toast.LENGTH_SHORT).show();
                }
            }
        });



        isMe = FirebaseAuth.getInstance();
        FirebaseUser currentUser = isMe.getCurrentUser();
        profill=findViewById(R.id.the_renter);
        rent = findViewById(R.id.apply_rent);
        chat = findViewById(R.id.to_talk);

        profill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ProfileView.class);
                startActivity(intent);

            }
        });
/*
        rent=view.findViewById(R.id.apply_rent);
        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentb = new Intent(getApplicationContext(), RentalAggreement.class);
                startActivity(intentb);
            }
        });*/

        favourite = findViewById(R.id.favoritt);
        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favourite.setBackground(getResources().getDrawable(R.drawable.select_favourite));
            }
        });
        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentUser == null){
                    Toast.makeText(ItemDetail.this, "Please Login First", Toast.LENGTH_SHORT).show();
                    Intent intenss = new Intent(ItemDetail.this, FBLogIn.class);
                    startActivity(intenss);
                    finish();
                }else if (currentUser != null) {
                    Intent intenss = new Intent(ItemDetail.this, RentalAggreement.class);
                    startActivity(intenss);
                    finish();
                }


            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(ItemDetail.this, TalkTo.class);
                startActivity(inte);
                finish();
            }
        });

    }
}
