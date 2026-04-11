package com.example.tonnidemo;

public class Payment {

    private String paymentId;
    private String applicationId;
    private double amount;
    private String method;   // Cash, bKash, Nagad, Rocket, Card
    private String status;

    public Payment(String paymentId, String applicationId, double amount, String method) {
        this.paymentId = paymentId;
        this.applicationId = applicationId;
        this.amount = amount;
        this.method = method;
        this.status = "Pending";
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}