package com.authenticate;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.acquireprinter.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ProfileViewUser extends AppCompatActivity {

    private static final int REQUEST_CODE_LOCATION = 1;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback;
    View view;
    private MapView mapView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_view);

        mapView = findViewById(R.id.mapview_for_the_user);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this::onMapReady);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request the permission.
            // Get the FusedLocationProviderClient object.



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
