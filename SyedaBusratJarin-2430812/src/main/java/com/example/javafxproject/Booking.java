package com.example.javafxproject;

public class Booking {

    private String username;   // NEW (important for client/receptionist separation)
    private String name;
    private String phone;
    private String service;
    private String date;
    private String time;

    private String status;
    private String paymentStatus;
    private String amount;

    // ✅ OLD constructor still works (no breaking)
    public Booking(String name, String phone, String service, String date, String time) {
        this.username = name; // fallback
        this.name = name;
        this.phone = phone;
        this.service = service;
        this.date = date;
        this.time = time;

        this.status = "Pending";
        this.paymentStatus = "Unpaid";
        this.amount = "0";
    }

    // ✅ NEW constructor (recommended for future)
    public Booking(String username, String name, String phone, String service, String date, String time) {
        this.username = username;  // login user
        this.name = name;          // real name
        this.phone = phone;
        this.service = service;
        this.date = date;
        this.time = time;

        this.status = "Pending";
        this.paymentStatus = "Unpaid";
        this.amount = "0";
    }

    // GETTERS
    public String getUsername() { return username; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getService() { return service; }
    public String getDate() { return date; }
    public String getTime() { return time; }

    public String getStatus() { return status; }
    public String getPaymentStatus() { return paymentStatus; }
    public String getAmount() { return amount; }

    // SETTERS
    public void setTime(String time) { this.time = time; }
    public void setStatus(String status) { this.status = status; }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}