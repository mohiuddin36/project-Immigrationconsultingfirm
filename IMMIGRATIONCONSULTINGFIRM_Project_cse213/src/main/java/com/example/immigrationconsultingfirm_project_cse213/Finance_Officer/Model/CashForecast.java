package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model;

import java.io.Serializable;

public class CashForecast implements Serializable {
    protected String username, password;
    protected String applicationDeadlines, operationalCosts;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CashForecast(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CashForecast{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", applicationDeadlines='" + applicationDeadlines + '\'' +
                ", operationalCosts='" + operationalCosts + '\'' +
                '}';
    }
}
