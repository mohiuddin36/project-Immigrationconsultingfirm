package com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes;

import java.time.LocalDate;

public class Notification {
    private String subject;
    private String type;
    private String status;
    private LocalDate date;
    private String sender;

    public Notification(String subject, String type, String status, LocalDate date, String sender) {
        this.subject = subject;
        this.type = type;
        this.status = status;
        this.date = date;
        this.sender = sender;
    }

    public String getSubject() { return subject; }
    public String getType() { return type; }
    public String getStatus() { return status; }
    public LocalDate getDate() { return date; }
    public String getSender() { return sender; }
}

