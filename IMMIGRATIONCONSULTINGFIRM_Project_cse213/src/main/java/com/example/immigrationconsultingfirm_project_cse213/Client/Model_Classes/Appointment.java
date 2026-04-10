package com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes;

import java.time.LocalDate;

public class Appointment {

    private String serviceType;
    private LocalDate date;
    private String time;
    private String status;

    // Constructor
    public Appointment(String serviceType, LocalDate date, String time, String status) {
        this.serviceType = serviceType;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public String getServiceType() {
        return serviceType;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "serviceType='" + serviceType + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}