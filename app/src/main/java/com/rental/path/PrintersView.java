package com.rental.path;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import android.Manifest;
import com.example.acquireprinter.R;
import com.stall.DataStall;
import com.stall.StallAdapter;

import java.util.ArrayList;

public class PrintersView extends AppCompatActivity {

    RecyclerView recyclerView;
    View view;
    private static final int REQUEST_CODE_LOCATION = 1;

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
        printerList.add(new DataStall("Printer L15150",  R.drawable.printer_l15150, 30000,"Surabaya"));
        printerList.add(new DataStall("Printer L15150",  R.drawable.printer_l15150, 30000,"Surabaya"));
        printerList.add(new DataStall("Printer L15150",  R.drawable.printer_l15150, 30000,"Surabaya"));
        printerList.add(new DataStall("Printer L15150",  R.drawable.printer_l15150, 30000,"Surabaya"));
        printerList.add(new DataStall("Printer L15150",  R.drawable.printer_l15150, 30000,"Surabaya"));
        printerList.add(new DataStall("Printer L15150",  R.drawable.printer_l15150, 30000,"Surabaya"));
        printerList.add(new DataStall("Printer L15150",  R.drawable.printer_l15150, 30000,"Surabaya"));
        printerList.add(new DataStall("Printer L15150",  R.drawable.printer_l15150, 30000,"Surabaya"));

        StallAdapter adapter = new StallAdapter(printerList, this);
        GridLayoutManager layout = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(adapter);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request the permission.
            ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_LOCATION);
        } else {
            // The app already has the permission.
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // The user granted the permission.
            } else {
                // The user denied the permission.
            }
        }
    }
}
