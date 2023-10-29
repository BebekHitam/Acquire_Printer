package com.authenticate;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.acquireprinter.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ProfileViewUser extends AppCompatActivity {
    View view;
    private MapView mapView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_view);

        mapView = findViewById(R.id.mapview_for_the_user);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this::onMapReady);
    }
    public void onMapReady(GoogleMap googleMap){
        //posisi untuk latlng nanti akan mengguanakan getter tapi ndak tahu caranya

        LatLng RumahUser = new LatLng(-7.833798, 110.117289);
        googleMap.addMarker(new MarkerOptions()
                .position(RumahUser)
                .title("Borobudur"));
        float zoomLevel = 14.0f;
        CameraUpdate cameraLepel = CameraUpdateFactory.newLatLngZoom(RumahUser, zoomLevel);
        googleMap.moveCamera(cameraLepel);


    }
}
