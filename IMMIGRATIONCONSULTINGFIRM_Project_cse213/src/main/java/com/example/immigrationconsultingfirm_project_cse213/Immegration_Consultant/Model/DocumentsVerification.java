package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class DocumentsVerification implements Serializable {
    protected String username,documentName,password ,loginSuccess,documentType,documentStatus;
    protected int clientId;
    protected LocalDate expiryDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DocumentsVerification(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "DocumentsVerification{" +
                "username='" + username + '\'' +
                ", documentName='" + documentName + '\'' +
                ", password='" + password + '\'' +
                ", loginSuccess='" + loginSuccess + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentStatus='" + documentStatus + '\'' +
                ", clientId=" + clientId +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
