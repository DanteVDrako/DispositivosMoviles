package com.poli.proyecto;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Map_2_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout menu;
    private ActionBarDrawerToggle icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_2_);

        //Funcionalidad del menu
        menu = (DrawerLayout)findViewById(R.id.draw);
        icon = new ActionBarDrawerToggle(this, menu, R.string.open, R.string.close);
        menu.addDrawerListener(icon);
        icon.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv = (NavigationView)findViewById(R.id.nav);
        nv.setNavigationItemSelectedListener(this);

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
        Intent ejecutar = new Intent(Map_2_Activity.this, Reserves_3_Activity.class);
        startActivity(ejecutar);
    }


}
