package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer;

import java.io.Serializable;
import java.time.LocalDate;

public class ClientFundControl implements Serializable {
    protected String name;
    protected int id;
    protected LocalDate date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientFundControl(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClientFundControl{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", date=" + date +
                '}';
    }
}
