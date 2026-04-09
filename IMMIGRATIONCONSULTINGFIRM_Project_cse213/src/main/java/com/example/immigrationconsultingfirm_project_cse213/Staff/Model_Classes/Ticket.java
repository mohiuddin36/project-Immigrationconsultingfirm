package com.example.immigrationconsultingfirm_project_cse213.Staff.Model_Classes;

import java.time.LocalDateTime;

public class Ticket {
    private final String ticketId;   // immutable
    private String clientId;
    private String issue;
    private LocalDateTime createdAt;
    private TicketStatus status; // enum type

    public Ticket(String ticketId, String clientId, String issue) {
        this.ticketId = ticketId;
        this.clientId = clientId;
        this.issue = issue;
        this.createdAt = LocalDateTime.now();
        this.status = TicketStatus.OPEN; // default
    }


    public String getTicketId() {
        return ticketId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getIssue() {
        return issue;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", issue='" + issue + '\'' +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                '}';
    }
}
