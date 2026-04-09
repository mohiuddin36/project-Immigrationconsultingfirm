package com.example.immigrationconsultingfirm_project_cse213.Staff.Model_Classes;

import java.time.LocalDateTime;

public class notifications {

    private final String notificationId;
    private String message;
    private LocalDateTime timestamp;
    private boolean read;

    public notifications(String notificationId, String message) {
        this.notificationId = notificationId;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.read = false;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isRead() {
        return read;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", read=" + read +
                '}';
    }
}