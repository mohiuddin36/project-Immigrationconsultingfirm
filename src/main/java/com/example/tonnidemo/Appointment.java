package com.example.tonnidemo;

public class Appointment {

    private String appointmentId;
    private String name;
    private String visaType;
    private String country;
    private String date;
    private String timeSlot;
    private String status;
    private String officer;

    public Appointment(String appointmentId, String name, String visaType,
                       String country, String date, String timeSlot, String status) {
        this.appointmentId = appointmentId;
        this.name = name;
        this.visaType = visaType;
        this.country = country;
        this.date = date;
        this.timeSlot = timeSlot;
        this.status = status;
    }

    public String getAppointmentId() { return appointmentId; }
    public String getName() { return name; }
    public String getVisaType() { return visaType; }
    public String getCountry() { return country; }
    public String getDate() { return date; }
    public String getTimeSlot() { return timeSlot; }
    public String getStatus() { return status; }
    public String getOfficer() { return officer; }

    public void setStatus(String status) { this.status = status; }
    public void setOfficer(String officer) { this.officer = officer; }
}