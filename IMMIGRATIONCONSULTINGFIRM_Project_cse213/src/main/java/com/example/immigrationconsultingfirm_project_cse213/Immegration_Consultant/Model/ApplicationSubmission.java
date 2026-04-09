package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class ApplicationSubmission implements Serializable {
    protected String username, password, applicationType;
    protected LocalDate submissionDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ApplicationSubmission(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ApplicationSubmission{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", applicationType='" + applicationType + '\'' +
                ", submissionDate=" + submissionDate +
                '}';
    }
}
