package com.rental.path;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.SplashScreen.ItemData;
import com.SplashScreen.ListRentAdapter;
import com.example.acquireprinter.R;

import java.util.ArrayList;
import java.util.List;

public class RentalStatus extends AppCompatActivity {
    View view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rental_status_layout);

        List<ItemData> items = new ArrayList<>();
        items.add(new ItemData(R.drawable.pin_day, "Day 1 Start of Rent"));
        items.add(new ItemData(R.drawable.pin_day, "Day 2"));
        items.add(new ItemData(R.drawable.pin_day, "Day 3"));
        items.add(new ItemData(R.drawable.pin_day, "Day 4"));
        items.add(new ItemData(R.drawable.pin_day, "Day 5"));
        items.add(new ItemData(R.drawable.pin_day, "Day 6"));
        items.add(new ItemData(R.drawable.pin_day, "Day 7"));
        items.add(new ItemData(R.drawable.pin_day, "Day 8"));
        items.add(new ItemData(R.drawable.pin_day, "Day 9"));
        items.add(new ItemData(R.drawable.pin_day, "Day 10"));
        items.add(new ItemData(R.drawable.pin_day, "Day 11 End of Rent"));
        // Add more items as needed
        //add day calculator in here, so if the day change the list added

        ListRentAdapter adapter = new ListRentAdapter(this, items);

        ListView listView = findViewById(R.id.the_view_of_rental_status); // Make sure to have a ListView with id 'listView' in your layout
        listView.setAdapter(adapter);

    }
}
