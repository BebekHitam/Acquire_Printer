package com.rental.path;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acquireprinter.R;
import com.stall.DataStall;
import com.stall.StallAdapter;

import java.util.ArrayList;

public class PrintersView extends AppCompatActivity {

    RecyclerView recyclerView;
    View view;

    ArrayList<DataStall> printerList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.printers_view);
        recyclerView = findViewById(R.id.listed_print_view);
        //inisiasi list
        printerList = new ArrayList<>();
        //isi list berdasar data
        printerList.add(new DataStall("Printer L1210", R.drawable.printer_l1210, 25000, "Jogja"));
        printerList.add(new DataStall("Printer L4266",  R.drawable.printer_l4266,10000, "Jakarta"));
        printerList.add(new DataStall("Printer M1100",  R.drawable.printer_m1100_sfp_m, 20000,"Bandung"));
        printerList.add(new DataStall("Printer L15150",  R.drawable.printer_l15150, 30000,"Surabaya"));

        StallAdapter adapter = new StallAdapter(printerList, this);
        GridLayoutManager layout = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(adapter);
    }
}
