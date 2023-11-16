package com.details.object;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.acquireprinter.R;

import org.w3c.dom.Text;

public class DetailForPrinter extends AppCompatActivity {
    View view;
    TextView NameofThePrinter, PriceforRent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_detail_f_print_alpha);

        NameofThePrinter = findViewById(R.id.nama_printer_di_alpha);
        PriceforRent = findViewById(R.id.price_for_rentall);


        PrinterModelHolder forPrinter = new ViewModelProvider(this).get(PrinterModelHolder.class);
        forPrinter.getPrinterName().observe(this, new Observer<DataForPrinter>() {
            @Override
            public void onChanged(DataForPrinter dataForPrinter) {
                NameofThePrinter.setText(dataForPrinter.getPrinterName());
                //kalau data awalnya integer jika ingin ditaruh di text edit, usahakan untuk rubah semuanya menjadi string
                PriceforRent.setText(dataForPrinter.getPrinterPrice().toString());
            }
        });

    }
}
