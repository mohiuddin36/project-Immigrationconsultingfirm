package com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes;

import com.example.immigrationconsultingfirm_project_cse213.model.User;

public class Client extends User {
    private String passportNumber;
    private String phoneNumber;

    public Client(String userId, String name, String email, String password,
                  String passportNumber, String phoneNumber) {
        super(userId, name, email, password);
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Override abstract method
    @Override
    public void login() {
        System.out.println("Client logged in: " + getName() + " (" + getEmail() + ")");
    }

    // toString for debugging
    @Override
    public String toString() {
        return "Client{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

