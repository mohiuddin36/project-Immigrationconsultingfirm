package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class MonthlyFinanceReports implements Serializable {
    protected int fees, operationalCosts;
    protected String month;
    protected LocalDate date;

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public MonthlyFinanceReports(int fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "MonthlyFinanceReports{" +
                "fees=" + fees +
                ", operationalCosts=" + operationalCosts +
                ", month='" + month + '\'' +
                ", date=" + date +
                '}';
    }
}
