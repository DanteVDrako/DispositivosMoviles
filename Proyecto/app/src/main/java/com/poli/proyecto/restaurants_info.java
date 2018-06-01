package com.poli.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class restaurants_info extends AppCompatActivity implements View.OnClickListener{

    private ImageView imagen_res_des;
    private TextView name_res_des;
    private TextView description_res;
    private TextView desc_res_des;
    private Button reservar_res_des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_info);

        imagen_res_des = (ImageView)findViewById(R.id.image_res_des);
        name_res_des = (TextView)findViewById(R.id.name_res);
        description_res = (TextView)findViewById(R.id.description_res);
        desc_res_des = (TextView)findViewById(R.id.description_res);
        reservar_res_des = (Button)findViewById(R.id.reservas_res_des);
        reservar_res_des.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("Nombre");
        String address = extras.getString("Direccion");
        String image = extras.getString("Imagen");
        String description = extras.getString("Descripcion");

        name_res_des.setText(name);
        description_res.setText(address);
        desc_res_des.setText(description);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == reservar_res_des.getId()){
            Intent reserva = new Intent(restaurants_info.this, Reserves3Activity.class);
            startActivity(reserva);
        }
    }
}
