package com.example.tonnidemo;

public class Ticket {

    private String ticketId;
    private String subject;
    private String category;
    private String status;

    public Ticket(String ticketId, String subject, String category, String status) {
        this.ticketId = ticketId;
        this.subject = subject;
        this.category = category;
        this.status = status;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getSubject() {
        return subject;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}