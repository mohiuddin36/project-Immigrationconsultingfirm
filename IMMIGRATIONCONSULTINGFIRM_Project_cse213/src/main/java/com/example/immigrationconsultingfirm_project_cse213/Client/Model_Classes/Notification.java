package com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes;

public class Notification {
    private String id;
    private String message;
    private String status;

    public Notification(String id, String message, String status) {
        this.id = id;
        this.message = message;
        this.status = status;
    }

    public String getMessage() { return message; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }


}

