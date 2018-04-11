package com.poli.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.poli.proyecto.Class.Restaurants;
import com.poli.proyecto.Adapters.Adapter;
import java.util.ArrayList;
public class Reserves_3_Activity extends AppCompatActivity {

    private ArrayList<Restaurants> restaurantList;
    private RecyclerView recyclerView;
    private Adapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserves_3_);

        restaurantList = new ArrayList<Restaurants>();
        recyclerView = findViewById(R.id.recicler);
        recyclerView.setHasFixedSize(true);
        Adapter = new Adapter(restaurantList);

        RecyclerView.LayoutManager manejador = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manejador);
        recyclerView.setAdapter(Adapter);

        fillRestaurants ();


    }
    public void fillRestaurants (){
        Restaurants r0 = new Restaurants("Andres Carne De Res", "Calle 82 No 12-21", R.drawable.andres_carne_res);
        restaurantList.add(r0);
        Restaurants r1 = new Restaurants("Armadillo", "C.C Santafé Local 395", R.drawable.armadillo);
        restaurantList.add(r1);
        Restaurants r2 = new Restaurants("Boca", "Cra 10 No 27-51 Local 174", R.drawable.boca);
        restaurantList.add(r2);
        Restaurants r3 = new Restaurants("Casa Vieja", "Cra 6-A No 117-35", R.drawable.casa_vieja);
        restaurantList.add(r3);
        Restaurants r4 = new Restaurants("Divino", "Calle 70 No 11-29", R.drawable.andres_carne_res);
        restaurantList.add(r4);
        Restaurants r5 = new Restaurants("Don Jediondo", "C.C Santafé Local 395", R.drawable.andres_carne_res);
        restaurantList.add(r5);
        Restaurants r6 = new Restaurants("Doña Elvira", "Calle 50 No 20-26", R.drawable.andres_carne_res);
        restaurantList.add(r6);
        Restaurants r7 = new Restaurants("El Buque", "Calle 69-A No 10-231", R.drawable.andres_carne_res);
        restaurantList.add(r7);
        Restaurants r8 = new Restaurants("El boliche", "Calle 70 No 11-29",R.drawable.andres_carne_res);
        restaurantList.add(r8);
        Restaurants r9 = new Restaurants("El Pórtico", "Auto. Norte Km 19", R.drawable.andres_carne_res);
        restaurantList.add(r9);
        Restaurants r10 = new Restaurants("El Techo", "Calle 82 No 11-94 Piso 5", R.drawable.andres_carne_res);
        restaurantList.add(r10);
        Restaurants r11 = new Restaurants("Gato Gris", "Calle 1-A No 13-12", R.drawable.andres_carne_res);
        restaurantList.add(r11);
        Restaurants r12 = new Restaurants("La Fragata Radisson", "Calle 114 No 9-65", R.drawable.andres_carne_res);
        restaurantList.add(r12);
        Restaurants r13 = new Restaurants("Las Margaritas", "Calle 62 No 7-77", R.drawable.andres_carne_res);
        restaurantList.add(r13);
        Restaurants r14 = new Restaurants("Vamos Pal Monte", "Km 5 vía Suesca", R.drawable.andres_carne_res);
        restaurantList.add(r14);
        }
}



