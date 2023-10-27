package com.stall;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acquireprinter.R;

import java.util.ArrayList;


    public class MyStall extends Fragment {
    //mendapatkan activity dari fragment
    Activity activity = getActivity();
    RecyclerView recyclerView;
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
        recyclerView = view.findViewById(R.id.recycler_stall);
        //inisiasi arrya list
        theDataList = new ArrayList<>();
        //menambahkan data ke array dengan metode getter di datastall
        theDataList.add(new DataStall("Printer L1210", R.drawable.printer_l1210, 25000, "Jogja"));
        theDataList.add(new DataStall("Printer L4266",  R.drawable.printer_l4266,10000, "Jakarta"));
        theDataList.add(new DataStall("Printer M1100",  R.drawable.printer_m1100_sfp_m, 20000,"Bandung"));
        theDataList.add(new DataStall("Printer L15150",  R.drawable.printer_l15150, 30000,"Surabaya"));




        //initiate kelas recyclerview adapter ke
        StallAdapter adapter = new StallAdapter(theDataList, activity);
        GridLayoutManager theLayout = new GridLayoutManager(activity, 2);
        recyclerView.setLayoutManager(theLayout);
        recyclerView.setAdapter(adapter);
    }
}