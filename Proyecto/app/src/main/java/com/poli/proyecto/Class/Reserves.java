package com.poli.proyecto.Class;

public class Reserves {

    private String date;
    private String hour;
    private int personAllowed;
    private String userName;
    private String restaurantName;
    private int state;

    public Reserves() {
    }

    public Reserves(String date, String hour, int personAllowed, String userName, String restaurantName, int state) {
        this.date = date;
        this.hour = hour;
        this.personAllowed = personAllowed;
        this.userName = userName;
        this.restaurantName = restaurantName;
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getPersonAllowed() {
        return personAllowed;
    }

    public void setPersonAllowed(int personAllowed) {
        this.personAllowed = personAllowed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
