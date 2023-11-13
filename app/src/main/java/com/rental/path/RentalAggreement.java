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
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.acquireprinter.R;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class RentalAggreement extends AppCompatActivity {
    private LocationManager locationManager;
    private MapView mapView;
    View view;
    private EditText StartDate, EndDate;
    private Calendar calendar;
    private TextView totalan, bill;
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
        totalan = findViewById(R.id.totalan_hari);
        bill = findViewById(R.id.the_price);
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
        getCalendar();

        //ini untuk calendar

    }
    public void getCalendar(){
        calendar = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat okedate = new SimpleDateFormat("dd-mm-yyyy");
        String currentDate = okedate.format(date);
        StartDate.setText(currentDate);
    }
    public void showDatePickerDialog(View view) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        Calendar minDate = Calendar.getInstance();
        minDate.add(Calendar.DAY_OF_MONTH, 0);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                calendar.set(selectedYear, selectedMonth, selectedDay);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy", Locale.US);

                EndDate.setText(sdf.format(calendar.getTime()));
                try {
                    calculateDayDifference();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }, year, month, day);

        //limiter
        datePickerDialog.getDatePicker().setMinDate(minDate.getTimeInMillis());


        datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                 // Clear the date if the user cancels the selection
                EndDate.setText("");
            }
        });

        datePickerDialog.show();
    }
    private void calculateDayDifference() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        // Create a SimpleDateFormat object to parse the dates
        // Get the current date as a string
        String currentDateString = StartDate.getText().toString();

        // Get the future date from the date picker
        String futureDateString = EndDate.getText().toString();

        // Parse the dates into Date objects
        Date currentDate = sdf.parse(currentDateString);
        Date futureDate = sdf.parse(futureDateString);

        // Calculate the difference between the two dates in days
        long daysDifference = futureDate.getTime() - currentDate.getTime();
        long price;
        daysDifference = daysDifference / (1000 * 60 * 60 * 24);
        price = daysDifference*75000;

        // Set the text of the TextView to the number of days difference
        totalan.setText(String.valueOf(daysDifference));

        bill.setText(String.valueOf(price));
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
