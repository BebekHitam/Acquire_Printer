package com.rental.path;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ImageHandler.AdapterSlider;
import com.example.acquireprinter.R;
import com.stall.UnderProgress;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {
    Timer timer = new Timer();
    private ViewPager viewPager;
    private AdapterSlider adapterSlider;
    private List<Integer> listIklan;
    CardView isThePrinter, isTheProjector, isTheScanner;
    View view;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.rental_path_fragment_home, container, false);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isThePrinter = view.findViewById(R.id.cardview_for_printer);
        isTheProjector = view.findViewById(R.id.cardview_for_projector);
        isTheScanner = view.findViewById(R.id.cardview_for_scanner);
        viewPager = view.findViewById(R.id.view_pager);
        listIklan = new ArrayList<Integer>();

        context = getContext();
        //buatkan adapter untuk menangkap gambar terbaru dari internet
        listIklan.add(R.drawable.ep_886aw);
        listIklan.add(R.drawable.ep_m15140);
        listIklan.add(R.drawable.printer_bg);

        adapterSlider = new AdapterSlider(context, listIklan);
        viewPager.setAdapter(adapterSlider);

        startTimer();



        isThePrinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the fragment manager
                Intent intent = new Intent(getContext(), PrintersView.class);
                startActivity(intent);
            }
        });
        isTheProjector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Not Available Yet", Toast.LENGTH_SHORT).show();
                Intent inteni = new Intent(getContext(), UnderProgress.class);
                startActivity(inteni);
            }
        });
        isTheScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Not Available Yet", Toast.LENGTH_SHORT).show();
                Intent inteni = new Intent(getContext(), UnderProgress.class);
                startActivity(inteni);
            }
        });

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                // Handle the Back button press here
                Activity activity = getActivity();

                // If the activity is not null, call finish() to close the application.
                if (activity != null) {
                    activity.finish();


                }
                //getActivity().getSupportFragmentManager().popBackStack();
                return true; // Consume the event
            }
            return false;
        });

    }
    private void startTimer(){

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(() -> {
                    if (viewPager.getCurrentItem() < listIklan.size() - 1){
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                });
            }
        }, 3000, 3000);
    }
    @Override
    public void onDetach() {
        // Stop the timer when the fragment is destroyed or stopped
        super.onDetach();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        super.onDestroyView();
    }

}