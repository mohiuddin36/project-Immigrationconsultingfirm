package com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel;

import java.time.LocalDate;

public class Consultant {
    private String name;
    private LocalDate availableDate;

    public Consultant(String name, LocalDate availableDate) {
        this.name = name;
        this.availableDate = availableDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "name='" + name + '\'' +
                ", availableDate=" + availableDate +
                '}';
    }
}
