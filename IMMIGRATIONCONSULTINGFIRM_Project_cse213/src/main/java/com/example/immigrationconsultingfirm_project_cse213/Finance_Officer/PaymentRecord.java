package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer;

import java.io.Serializable;

public class PaymentRecord implements Serializable {
    protected int id, amount;
    protected String  type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PaymentRecord(int id, int amount, String type) {
        this.id = id;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "PaymentRecord{" +
                "id=" + id +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
