package com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes;

import java.time.LocalDateTime;

public class Appointment {
    private final String appointmentId;   // immutable
    private LocalDateTime dateTime;
    private String status;

    public Appointment(String appointmentId, LocalDateTime dateTime, String status) {
        this.appointmentId = appointmentId;
        this.dateTime = dateTime;
        this.status = status;

    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", dateTime=" + dateTime +
                ", status='" + status + '\'' +
                '}';
    }
}
