package com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes;

import java.time.LocalDate;

public class Appointment {
    private String appointmentId;
    private String serviceType;
    private LocalDate date;   // LocalDate type
    private String time;
    private String status;

    public Appointment(String appointmentId, String serviceType, LocalDate date, String time, String status) {
        this.appointmentId = appointmentId;
        this.serviceType = serviceType;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public String getAppointmentId() { return appointmentId; }
    public String getServiceType() { return serviceType; }
    public LocalDate getDate() { return date; }
    public String getTime() { return time; }
    public String getStatus() { return status; }

    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setTime(String time) { this.time = time; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
