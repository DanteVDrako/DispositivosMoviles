package com.poli.proyecto.Class;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by ahsierra on 06/04/2018.
 */

public class Restaurants {

    private String name;
    private String address;
    private String imagen;

    public Restaurants(){

    }

    public Restaurants(String name, String address, String a) {
        this.imagen = a;
        this.name = name;
        this.address = address;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
