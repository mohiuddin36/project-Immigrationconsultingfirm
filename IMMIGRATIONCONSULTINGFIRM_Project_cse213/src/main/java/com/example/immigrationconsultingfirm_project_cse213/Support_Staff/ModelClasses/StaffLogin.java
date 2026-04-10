package com.example.immigrationconsultingfirm_project_cse213.Support_Staff.ModelClasses;

public class StaffLogin {
    private String staffId;
    private String email;
    private String password;
    private boolean loginStatus;

    public StaffLogin(String staffId, String email, String password) {
        this.staffId = staffId;
        this.email = email;
        this.password = password;
        this.loginStatus = false;
    }

    // ✅ FIX: this method was missing
    public boolean validateCredentials(String validEmail, String validPassword) {
        return this.email.equals(validEmail) && this.password.equals(validPassword);
    }

    public String getStaffId() {
        return staffId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Override
    public String toString() {
        return "StaffLogin{" +
                "staffId='" + staffId + '\'' +
                ", email='" + email + '\'' +
                ", loginStatus=" + loginStatus +
                '}';
    }
}