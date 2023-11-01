package com.stall;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.authenticate.FBLogIn;
import com.authenticate.FBSign;
import com.authenticate.ProfileView;
import com.example.acquireprinter.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rental.path.RentalAggreement;

public class ItemDetail extends AppCompatActivity {
    FirebaseAuth isMe;
    View view;
    private Button visit, rent, favourite, chat;
    CardView profill;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_view);

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
                Intent inte = new Intent(ItemDetail.this, comChat.class);
                startActivity(inte);
                finish();
            }
        });

    }
}
