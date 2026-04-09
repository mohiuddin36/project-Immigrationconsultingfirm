package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model;

import java.io.Serializable;

public class BudgetMonitor implements Serializable {
    //Enter budget figures for departments (Marketing, Legal, Admin) and working time.
    protected int id, amount;
    protected String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BudgetMonitor(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BudgetMonitor{" +
                "id=" + id +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
