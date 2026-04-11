package com.example.tonnidemo;

public class Staff extends User {

    private String role;

    public Staff(String userId, String name, String email, String password, String role) {
        super(userId, name, email, password);
        this.role = role;
    }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }
}