package com.authenticate;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.acquireprinter.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ProfileView extends AppCompatActivity implements OnMapReadyCallback {
    /*
    * cara melakukan pemasangan api
    * buat projek di google play
    * minta api, buat api
    * setelah dapat api selanjutnya
    * konfigurasi apinya jangan dibuat tidak punya restriction
    * lakukan enable map sdk for android
    * lalu isi restriction dengan map sdk for android
    * baru kode disini */

    //inisiasi mapview
    private MapView mapView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.i_see_a_man);

        //kenalkan mapview ke layout ------------------------------------------------------------
        mapView = findViewById(R.id.mapview_for_the_mister_who);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this::onMapReady);


    }
    public void onMapReady(GoogleMap googleMap){
        //posisi untuk latlng nanti akan mengguanakan getter tapi ndak tahu caranya

        LatLng borobudur = new LatLng(-6.339120, 107.144470);
        googleMap.addMarker(new MarkerOptions()
                .position(borobudur)
                .title("Borobudur"));
        float zoomLevel = 14.0f;
        CameraUpdate cameraLepel = CameraUpdateFactory.newLatLngZoom(borobudur, zoomLevel);
        googleMap.moveCamera(cameraLepel);


    }
}
