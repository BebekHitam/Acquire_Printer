package com.rental.path;

import static android.app.PendingIntent.getActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.acquireprinter.R;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

public class RentalAggreement extends AppCompatActivity {
    private LocationManager locationManager;
    private MapView mapView;
    View view;
    private EditText StartDate, EndDate;
    private Calendar calendar;
    Button finalRent, getLocation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rental_form);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        getLocation = findViewById(R.id.get_location);
        //tambahkan mapview
        //mapView = findViewById(R.layout.map_view);


        StartDate = findViewById(R.id.start_rent_date);
        EndDate = findViewById(R.id.end_rent_date);
        finalRent = findViewById(R.id.final_apply_rent_button);
        finalRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RentalAggreement.this, RentalStatus.class);
                startActivity(intent);
            }
        });


        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //ini untuk calendar
        calendar = Calendar.getInstance();
    }
    public void showDatePickerDialog(View view) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                calendar.set(selectedYear, selectedMonth, selectedDay);
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy", Locale.US);
                StartDate.setText(sdf.format(calendar.getTime()));
                EndDate.setText(sdf.format(calendar.getTime()));
            }
        }, year, month, day);


        datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                StartDate.setText(""); // Clear the date if the user cancels the selection
                EndDate.setText("");
            }
        });

        datePickerDialog.show();
    }
    //ini adalah fungsi untuk call map saat tombol ditekan
    /*
    @Override
    public void onClick(View view) {
        // Get the user's location.
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        // Create a Map object.
        Map map = mapView.getMapAsync();

        // Add a marker to the user's location.
        map.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())));

        // Display the map to the user.
        mapView.setVisibility(View.VISIBLE);
    }*/
}
