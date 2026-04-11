package com.example.tonnidemo;

public class Notification {

    private String notificationId;
    private String message;
    private String date;
    private String status;

    public Notification(String notificationId, String message, String date) {
        this.notificationId = notificationId;
        this.message = message;
        this.date = date;
        this.status = "Unread";
    }

    public String getNotificationId() { return notificationId; }
    public String getMessage() { return message; }
    public String getDate() { return date; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}