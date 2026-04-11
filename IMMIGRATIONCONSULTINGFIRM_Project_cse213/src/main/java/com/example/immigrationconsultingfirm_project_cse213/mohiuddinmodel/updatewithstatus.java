package com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel;

public class updatewithstatus {
    private String id;
    private String name;
    private String date;
    private String status;

    public updatewithstatus(String id, String name, String date, String status) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "updatewithstatus{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
