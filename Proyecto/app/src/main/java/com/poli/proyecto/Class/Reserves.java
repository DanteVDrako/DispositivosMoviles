package com.poli.proyecto.Class;

/**
 * Created by ahsierra on 06/04/2018.
 */

public class Reserves {

    private String date;
    private String personAllowed;

    public Reserves(String date, String personAllowed) {
        this.date = date;
        this.personAllowed = personAllowed;
    }

    public String getDate() {
        return date;
    }

    public String getPersonAllowed() {
        return personAllowed;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPersonAllowed(String personAllowed) {
        this.personAllowed = personAllowed;
    }
}
