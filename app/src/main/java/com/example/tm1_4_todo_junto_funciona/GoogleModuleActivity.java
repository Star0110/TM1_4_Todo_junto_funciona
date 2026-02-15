package com.example.tm1_4_todo_junto_funciona;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleModuleActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_module);

        mapView = findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        MobileAds.initialize(this, initializationStatus -> { });
        adView = findViewById(R.id.ad_view);
        adView.loadAd(new AdRequest.Builder().build());

        Button btnVolver = findViewById(R.id.btn_google_volver);
        btnVolver.setOnClickListener(v -> finish());

        if ("YOUR_MAPS_API_KEY".contentEquals(getString(R.string.google_maps_key))) {
            Toast.makeText(this, "Configura google_maps_key para habilitar el mapa real", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng quito = new LatLng(-0.1807, -78.4678);
        googleMap.addMarker(new MarkerOptions().position(quito).title("Quito"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(quito, 11f));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        mapView.onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
