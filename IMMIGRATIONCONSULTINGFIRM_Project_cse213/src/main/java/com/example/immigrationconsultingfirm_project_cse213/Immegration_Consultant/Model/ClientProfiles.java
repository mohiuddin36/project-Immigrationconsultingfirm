package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Model;

import java.io.Serializable;

public class ClientProfiles implements Serializable {
    protected String name, email, address, nationality;
    protected int passportNo, contactInfo;

    public ClientProfiles() {
    }

    public ClientProfiles(String name, String email, String address, String nationality, int passportNo, int contactInfo) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
        this.passportNo = passportNo;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(int passportNo) {
        this.passportNo = passportNo;
    }

    public int getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(int contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "ClientProfiles{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nationality='" + nationality + '\'' +
                ", passportNo=" + passportNo +
                ", contactInfo=" + contactInfo +
                '}';
    }
}
