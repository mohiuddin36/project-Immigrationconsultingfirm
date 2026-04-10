package com.example.immigrationconsultingfirm_project_cse213.Support_Staff.ModelClasses;

import java.time.LocalDate;

public class StaffAppointment {
    private String appointmentId;
    private String staffId;
    private String clientName;
    private LocalDate appointmentDate;
    private String status;

    // Constructor
    public StaffAppointment(String appointmentId, String staffId, String clientName, LocalDate appointmentDate, String status) {
        this.appointmentId = appointmentId;
        this.staffId = staffId;
        this.clientName = clientName;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    // Getters
    public String getAppointmentId() { return appointmentId; }
    public String getStaffId() { return staffId; }
    public String getClientName() { return clientName; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public String getStatus() { return status; }

    // Setters
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "StaffAppointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", staffId='" + staffId + '\'' +
                ", clientName='" + clientName + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", status='" + status + '\'' +
                '}';
    }
}
