package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Model;

import java.io.Serializable;

public class ClientCommunication  implements Serializable {
    protected String responseDraft,username;
    protected int id;

    public String getResponseDraft() {
        return responseDraft;
    }

    public void setResponseDraft(String responseDraft) {
        this.responseDraft = responseDraft;
    }

    public ClientCommunication(String responseDraft) {
        this.responseDraft = responseDraft;
    }

    @Override
    public String toString() {
        return "ClientCommunication{" +
                "responseDraft='" + responseDraft + '\'' +
                ", username='" + username + '\'' +
                ", id=" + id +
                '}';
    }
}
