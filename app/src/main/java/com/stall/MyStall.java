package com.stall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.FBPopulateData.ThePopulator;
import com.example.acquireprinter.R;

import java.util.ArrayList;


    public class MyStall extends Fragment {
        //mendapatkan activity dari fragment
        Activity activity = getActivity();
        RecyclerView recyclerView;
        ImageButton gotofill;
        ArrayList<DataStall> theDataList;
        View view;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            view = inflater.inflate(R.layout.fragment_my_stall, container, false);
            return view;
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            gotofill = view.findViewById(R.id.printer_in_the_sky);
            gotofill.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intenn = new Intent(getContext(), ThePopulator.class);
                    startActivity(intenn);
                }
            });
        }
    }