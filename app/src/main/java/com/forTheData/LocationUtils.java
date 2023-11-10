package com.forTheData;

import com.google.android.gms.location.LocationRequest;

public class LocationUtils {
    public static LocationRequest getLocationRequest() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10000); // Update location every 10 seconds
        locationRequest.setFastestInterval(5000); // The fastest update interval (5 seconds)

        return locationRequest;
    }
}
