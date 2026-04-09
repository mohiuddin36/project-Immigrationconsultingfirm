package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Model;

import java.io.Serializable;

public class ClientCommunication  implements Serializable {
    protected String username;
    protected int id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ClientCommunication(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ClientCommunication{" +
                "username='" + username + '\'' +
                ", id=" + id +
                '}';
    }
}

