package com.poli.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Map_2_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_2_);
    }












    //Metodos del Menu
    @Override
    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.menu_proyecto, m);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem m_i){
        int id = m_i.getItemId();
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
        return super.onOptionsItemSelected(m_i);
    }
    public void executeRestaurantList(View v){
        Intent ejecutar = new Intent(Map_2_Activity.this, Reserves_3_Activity.class);
        startActivity(ejecutar);
    }
}
