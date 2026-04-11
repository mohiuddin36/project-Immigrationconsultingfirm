package com.example.tonnidemo;

public class Application {

    private String appId;
    private String clientName;
    private String visaType;
    private String country;
    private String date;
    private String timeSlot;
    private String status;
    private String officer;

    public Application(String appId, String clientName, String visaType,
                       String country, String date, String timeSlot,
                       String status) {

        this.appId = appId;
        this.clientName = clientName;
        this.visaType = visaType;
        this.country = country;
        this.date = date;
        this.timeSlot = timeSlot;
        this.status = status;
        this.officer = "Not Assigned";
    }

    public String getAppId() { return appId; }
    public String getClientName() { return clientName; }
    public String getVisaType() { return visaType; }
    public String getCountry() { return country; }
    public String getDate() { return date; }
    public String getTimeSlot() { return timeSlot; }
    public String getStatus() { return status; }
    public String getOfficer() { return officer; }

    public void setStatus(String status) { this.status = status; }
    public void setOfficer(String officer) { this.officer = officer; }
}