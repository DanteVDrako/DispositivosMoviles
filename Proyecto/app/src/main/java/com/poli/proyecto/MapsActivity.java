package com.poli.proyecto;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback,NavigationView.OnNavigationItemSelectedListener  {
    private DrawerLayout menu;
    private ActionBarDrawerToggle icon;
    private GoogleMap mMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //Funcionalidad del menu
        menu = (DrawerLayout)findViewById(R.id.draw);
        icon = new ActionBarDrawerToggle(this, menu, R.string.open, R.string.close);
        menu.addDrawerListener(icon);
        icon.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv = (NavigationView)findViewById(R.id.nav);
        nv.setNavigationItemSelectedListener(this);



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney= new LatLng(4.0000000, -72.0000000);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Colombia papá"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


    }

    //Metodos del Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem m_i) {
        if(icon.onOptionsItemSelected(m_i)){
            return true;
        }
        return super.onOptionsItemSelected(m_i);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.user_profile){
            return true;
        }else if(id == R.id.my_reserves){
            return true;
        }else if(id == R.id.restaurant_list){
            executeRestaurantList(null);
            return true;
        }else if(id == R.id.settings){
            return true;
        }else if(id == R.id.logout){
            return true;
        }
        return false;
    }
    //Metodos para cambiar de activity
    public void executeRestaurantList(View v){
        Intent ejecutar = new Intent(MapsActivity.this, Reserves_3_Activity.class);
        startActivity(ejecutar);
    }


}
