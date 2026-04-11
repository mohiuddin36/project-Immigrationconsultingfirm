package com.example.javafxproject;

public class User {

    private String username;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String password;
    private String role;

    public User(String username, String name, String phone, String email,
                String address, String password, String role) {

        this.username = username;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
        this.role = role;
    }

    public String getUsername() { return username; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}