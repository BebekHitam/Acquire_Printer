package com.stall;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.details.object.DetailForPrinter;
import com.example.acquireprinter.R;


public class FavouriteFragment extends Fragment {
    Button next, tesImageView;

   View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favourite, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        next=(Button) view.findViewById(R.id.toss);
        tesImageView = (Button) view.findViewById(R.id.tes_image_preview);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DetailForPrinter.class);
                startActivity(intent);
            }
        });
        tesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent intens = new Intent(getContext(), ima.class);
                startActivity(intens);*/

            }
        });


    }
}