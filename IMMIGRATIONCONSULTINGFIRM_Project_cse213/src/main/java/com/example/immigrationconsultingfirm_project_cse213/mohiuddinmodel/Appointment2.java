package com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel;

public class Appointment2 {
    private String id;
    private String name;
    private String date;
    private String id;
    private String name;
    private String consultant;

    @Override
    public String toString() {
        return "Appointment2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", consultant='" + consultant + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getConsultant() {
        return consultant;
    }

    public void setConsultant(String consultant) {
        this.consultant = consultant;
    }

    public Appointment2(String name, String consultant, String date, String id) {
        this.name = name;
        this.consultant = consultant;
        this.date = date;
        this.id = id;
    }

    private String date;

    public Appointment2(String id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
