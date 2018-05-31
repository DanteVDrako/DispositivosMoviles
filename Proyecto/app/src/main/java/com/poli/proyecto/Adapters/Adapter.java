package com.poli.proyecto.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
        public ConstraintLayout a3;

        public MyViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.imagenres);
            image.setOnClickListener(this);
            nameRes = (TextView) v.findViewById(R.id.nombre_restaurante);
            add = (TextView) v.findViewById(R.id.direccion_restaurante);
            reservar = (Button)v.findViewById(R.id.reservar);
            reservar.setOnClickListener(this);
            a3 = (ConstraintLayout) v.findViewById(R.id.cards);
            a3.setOnClickListener(this);

        }
        public void onClick(View v){
            if(v.getId() == reservar.getId()){

            }if(v.getId() == a3.getId()){

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
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Restaurants r = res.get(position);
        holder.nameRes.setText(r.getName());
        holder.add.setText(r.getAddress());

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream is = null;
                try {
                    is = new URL(r.getImagen()).openStream();
                    final Bitmap logo = BitmapFactory.decodeStream(is);
                    holder.image.post(new Runnable() {
                        @Override
                        public void run() {
                            holder.image.setImageBitmap(logo);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();

        loadImageFromURL(r.getImagen(), holder.image);
    }

    public boolean loadImageFromURL(String fileUrl,ImageView iv){
        try {
            URL myFileUrl = new URL (fileUrl);
            HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            iv.setImageBitmap(BitmapFactory.decodeStream(is));
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getItemCount() {
        return res.size();
    }
}
