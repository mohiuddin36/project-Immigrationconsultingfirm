package com.example.tonnidemo;

public class Client {

    private String clientId;
    private String name;
    private String birthDate;
    private String address;
    private String phone;
    private String email;

    public Client(String clientId, String name, String birthDate,
                  String address, String phone, String email) {

        this.clientId = clientId;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getClientId() { return clientId; }
    public String getName() { return name; }
    public String getBirthDate() { return birthDate; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
}