package com.rental.path;

import android.content.Intent;
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
import android.widget.Toast;

import com.example.acquireprinter.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
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
        fetchFirestoreData();
        /*
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
        */

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
    private void fetchFirestoreData() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("printers")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        // Clear existing data
                        printerList.clear();
                        // Iterate through Firestore documents and add data to the list
                        for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                            String name = document.getString("name");
                            long price = document.getLong("price");
                            String location = document.getString("city");
                            // Add this data to your printerList
                            int priceInt = (int) price;
                            printerList.add(new DataStall(name, R.drawable.printer_l1210, priceInt, location));
                        }
                        // Notify the adapter that data has changed
                        StallAdapter adapter = new StallAdapter(printerList, PrintersView.this);
                        GridLayoutManager layout = new GridLayoutManager(PrintersView.this, 2);
                        recyclerView.setLayoutManager(layout);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PrintersView.this, "failed read database", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
