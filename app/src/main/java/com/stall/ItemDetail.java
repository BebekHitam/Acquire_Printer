package com.stall;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.authenticate.ProfileView;
import com.example.acquireprinter.R;
import com.rental.path.RentalAggreement;

public class ItemDetail extends AppCompatActivity {
    View view;
    Button visit, rent, favourite;
    CardView profill;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_view);

        profill=findViewById(R.id.the_renter);
        rent = findViewById(R.id.apply_rent);

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
                Intent intenss = new Intent(ItemDetail.this, RentalAggreement.class);
                startActivity(intenss);
                finish();
            }
        });

    }
}
