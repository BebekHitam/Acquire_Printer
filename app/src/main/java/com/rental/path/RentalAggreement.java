package com.rental.path;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.acquireprinter.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RentalAggreement extends AppCompatActivity {
    View view;
    private EditText StartDate, EndDate;
    private Calendar calendar;
    Button finalRent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rental_form);

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
}
