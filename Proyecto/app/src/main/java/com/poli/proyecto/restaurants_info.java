package com.poli.proyecto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class restaurants_info extends AppCompatActivity implements View.OnClickListener{

    private ImageView imagen_res_des;
    private TextView name_res_des;
    private TextView description_res;
    private TextView address_res;
    private Button reservar_res_des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_info);

        imagen_res_des = (ImageView)findViewById(R.id.image_res_des);
        name_res_des = (TextView)findViewById(R.id.name_res);
        description_res = (TextView)findViewById(R.id.description_res);
        address_res = (TextView)findViewById(R.id.address_res);
        reservar_res_des = (Button)findViewById(R.id.reservas_res_des);
        reservar_res_des.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("Nombre");
        String address = extras.getString("Dir");
        final String image = extras.getString("Imagen");
        String description = extras.getString("Descripcion");

        name_res_des.setText(name);
        description_res.setText(description);
        address_res.setText(address);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream is = null;
                try {
                    is = new URL(image).openStream();
                    final Bitmap logo = BitmapFactory.decodeStream(is);
                    imagen_res_des.post(new Runnable() {
                        @Override
                        public void run() {
                            imagen_res_des.setImageBitmap(logo);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();

        loadImageFromURL(image, imagen_res_des);



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
    public void onClick(View v) {
        if(v.getId() == reservar_res_des.getId()){
            Intent reserva = new Intent(restaurants_info.this, Reserves3Activity.class);
            reserva.putExtra("Nombre", name_res_des.getText());
            startActivity(reserva);
        }
    }
}
