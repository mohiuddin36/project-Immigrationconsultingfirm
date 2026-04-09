package com.example.immigrationconsultingfirm_project_cse213.Staff.Model_Classes;

import com.example.immigrationconsultingfirm_project_cse213.model.User;

public class Staff extends User {
    private String role;   // e.g., "Consultant", "Admin"

    public Staff(String userId, String name, String email, String password, String role) {
        super(userId, name, email, password);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Override abstract method
    @Override
    public void login() {
        System.out.println("Staff logged in: " + getName() + " (" + getEmail() + ") with role " + role);
    }

    // toString for debugging
    @Override
    public String toString() {
        return "Staff{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}