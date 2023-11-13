package com.authenticate;

import static android.content.pm.PackageManager.*;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.acquireprinter.R;
import com.forTheData.LocationUtils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
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
        //initMap();


        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PERMISSION_GRANTED) {
            // Request the permission.
            // Get the FusedLocationProviderClient object.
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_LOCATION);


            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_LOCATION);
        } else {
            initMap();
            // The app already has the permission.
        }

    }
    private void initMap(){
        mapView.getMapAsync(this::onMapReady);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, initialize the map
                initMap();
            } else {
                // Permission denied, handle the error or show a message
            }
        }
    }
    public void onMapReady(GoogleMap googleMap){
        //cek permition
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PERMISSION_GRANTED){
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, location -> {
                if (location != null){
                    LatLng currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());
                    googleMap.addMarker(new MarkerOptions().position(currentLatLng).title("kamu sekarang"));
                    float zoomLevel = 14.0f;
                    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(currentLatLng, zoomLevel);
                    googleMap.moveCamera(cameraUpdate);
                }else{
                    LatLng RumahUser = new LatLng(43.158576, 141.239727);

                    float zoomLevel = 14.0f;
                    CameraUpdate cameraLepel = CameraUpdateFactory.newLatLngZoom(RumahUser, zoomLevel);
                    googleMap.moveCamera(cameraLepel);

                }
            });
        }
        //posisi untuk latlng nanti akan mengguanakan getter tapi ndak tahu caranya
    }
}
