package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Model;

import java.io.Serializable;

public class AdminResponsibilties implements Serializable {
    protected String username, password;
    protected int clientId,professionalFees,taxRate, discountApplied;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AdminResponsibilties(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "AdminResponsibilties{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", clientId=" + clientId +
                ", professionalFees=" + professionalFees +
                ", taxRate=" + taxRate +
                ", discountApplied=" + discountApplied +
                '}';
    }
}
