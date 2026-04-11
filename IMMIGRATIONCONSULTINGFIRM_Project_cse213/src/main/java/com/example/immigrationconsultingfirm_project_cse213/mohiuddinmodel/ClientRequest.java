package com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel;

import java.time.LocalDate;

public class ClientRequest {
    private String clientName;
    private String consultantName;
    private LocalDate date;

    public ClientRequest(String clientName, String consultantName, LocalDate date) {
        this.clientName = clientName;
        this.consultantName = consultantName;
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "clientName='" + clientName + '\'' +
                ", consultantName='" + consultantName + '\'' +
                ", date=" + date +
                '}';
    }
}
