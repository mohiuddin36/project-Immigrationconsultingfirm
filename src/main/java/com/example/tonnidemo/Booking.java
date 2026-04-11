package com.example.tonnidemo;

public class Booking {

    private String name;
    private String visa;
    private String date;

    public Booking(String name, String visa, String date) {
        this.name = name;
        this.visa = visa;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getVisa() {
        return visa;
    }

    public String getDate() {
        return date;
    }
}