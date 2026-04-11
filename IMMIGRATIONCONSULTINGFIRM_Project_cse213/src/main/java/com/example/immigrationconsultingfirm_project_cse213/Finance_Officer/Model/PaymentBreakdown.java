package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model;

import java.io.Serializable;

public class PaymentBreakdown  implements Serializable {
    //Choose Client ID and application stream (Express Entry, Study Permit).
    protected int clientId, amount;
    protected String name, applicationStream;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public PaymentBreakdown(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "PaymentBreakdown{" +
                "clientId=" + clientId +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                ", applicationStream='" + applicationStream + '\'' +
                '}';
    }
}
