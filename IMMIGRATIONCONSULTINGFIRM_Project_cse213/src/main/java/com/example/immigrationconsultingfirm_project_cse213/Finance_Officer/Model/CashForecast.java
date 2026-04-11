package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class CashForecast implements Serializable {
    protected String username, password;
    protected LocalDate applicationDeadlines;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CashForecast(String username) {
        this.username = username;
    }

    public CashForecast(String username, String password, LocalDate applicationDeadlines) {
        this.username = username;
        this.password = password;
        this.applicationDeadlines = applicationDeadlines;
    }

    @Override
    public String toString() {
        return "CashForecast{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", applicationDeadlines=" + applicationDeadlines +
                '}';
    }
}
