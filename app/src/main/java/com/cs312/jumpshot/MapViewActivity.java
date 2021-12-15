package com.cs312.jumpshot;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.cs312.jumpshot.databinding.MapViewBinding;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MapViewActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationClickListener {
    static final String TAG = "MapViewActivity";
    static final int LOCATION_REQUEST_CODE = 1;
    private GoogleMap mMap;
    private MapViewBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Created map view");
        super.onCreate(savedInstanceState);

        binding = MapViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }
}
