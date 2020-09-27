package com.example.cf_map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Camera;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    private MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapView = (MapView) findViewById(R.id.mapView);
        /*SINCRONIZANDO EL CICLO DE VIDA DEL MAPVIEW
        CON EL CICLO DE VIDA DE NUESTRO ACTIVITY */
        mapView.onCreate(savedInstanceState);
        //implementamos un evento para realizar cambios en el mapa
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng newYork = new LatLng(-0.69819,-80.0936127);
                //en este metodo se recibe el mapa actual el cual podemos modificar
                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                //agregando un marcador :D
                googleMap.addMarker(new MarkerOptions().position(newYork).title("New York"));
                //para que la camara se mueva a nuestro marcador
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(newYork));

            }
        });

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
        super.onPause();
        mapView.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
    /**
     * Dispatch onLowMemory() to all fragments.
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    /**
     * Dispatch onPause() to fragments.
     */


    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.
     */

}


/*
*
* AIzaSyD6HpHMgIt9KDjISBwZ4EjJUrS9B2Jt83k
*
* */