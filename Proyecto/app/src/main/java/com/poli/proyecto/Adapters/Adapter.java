package com.poli.proyecto.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.poli.proyecto.Class.Restaurants;
import com.poli.proyecto.MyReserved_4_Activity;
import com.poli.proyecto.R;
import com.poli.proyecto.Reserves_3_Activity;

import java.util.ArrayList;

/**
 * Created by ahsierra on 06/04/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    private ArrayList<Restaurants> res;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView image;
        public TextView nameRes;
        public TextView add;
        public Button reservar;

        public MyViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.imagenres);
            image.setOnClickListener(this);
            nameRes = (TextView) v.findViewById(R.id.nombre_restaurante);
            add = (TextView) v.findViewById(R.id.direccion_restaurante);
            reservar = (Button)v.findViewById(R.id.reservar);
            reservar.setOnClickListener(this);

        }
        public void onClick(View v){
            if(v.getId() == reservar.getId()){

            }if(v.getId() == image.getId()){

            }
        }
    }
    public Adapter( ArrayList<Restaurants> res) {
        this.res = res;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurants_card, parent, false);

        return new MyViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Restaurants r = res.get(position);
        holder.image.setImageResource(r.getImagen());
        holder.nameRes.setText(r.getName());
        holder.add.setText(r.getAddress());
    }

    @Override
    public int getItemCount() {
        return res.size();
    }
}
