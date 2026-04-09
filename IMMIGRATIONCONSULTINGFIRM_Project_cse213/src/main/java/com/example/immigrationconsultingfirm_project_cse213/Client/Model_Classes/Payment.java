package com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes;

public class Payment {
    private final String paymentId;   // immutable
    private double amount;
    private String method;
    private String status;

    public Payment(String paymentId, double amount, String method, String status) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    public String getPaymentId() {
        return paymentId;
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

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", method='" + method + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
