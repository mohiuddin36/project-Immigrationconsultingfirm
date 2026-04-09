package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model;

import java.io.Serializable;

public class SteadyCashFlowOptimization  implements Serializable {
    protected String username, password;
    protected String paymentSchedule;
    protected String paymentStatus;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SteadyCashFlowOptimization(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "SteadyCashFlowOptimization{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", paymentSchedule='" + paymentSchedule + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
