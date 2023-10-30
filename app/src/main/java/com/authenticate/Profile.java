package com.authenticate;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.acquireprinter.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Profile extends Fragment {
    View view;
    ProgressBar progressBar;
    TableLayout tableLayout;
    Button keluar, masukKembali, toUserProfile;
    FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        keluar = view.findViewById(R.id.to_out);
        toUserProfile = view.findViewById(R.id.see_user_profile);
        masukKembali = view.findViewById(R.id.masuk_kembali);
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //terlalu berantakan buatkan viewmodel

        //wrap this in another call/method
        if (currentUser == null){
            masukKembali.setVisibility(View.VISIBLE);
        }else if (currentUser != null) {
            masukKembali.setVisibility((View.INVISIBLE));
        }
        //jika lulus permanensi coba di wrap/dalam func/method/callback lain
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(currentUser != null){
                    FirebaseAuth.getInstance().signOut();
                    Intent inten = new Intent(getContext(), Login.class);
                    startActivity(inten);

                } else if (currentUser == null) {
                    Toast.makeText(getContext(), "Anda belum login", Toast.LENGTH_SHORT).show();

                }

            }
        });


        masukKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(getContext(), Login.class);
                startActivity(inten);
            }
        });

        tableLayout = view.findViewById(R.id.table_view_percentage);
        tableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FillProfile.class);
                startActivity(intent);
            }
        });
        progressBar = view.findViewById(R.id.progres_profile);
        progressBar.setProgress(50);

        //Ke User
        toUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intens = new Intent(getContext(), ProfileViewUser.class);
                startActivity(intens);
            }
        });

    }

}